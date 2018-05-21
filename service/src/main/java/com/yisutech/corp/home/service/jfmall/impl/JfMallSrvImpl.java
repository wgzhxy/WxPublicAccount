package com.yisutech.corp.home.service.jfmall.impl;

import com.google.common.collect.Lists;
import com.yisutech.corp.domain.repository.mapper.WxExchangeProductMapper;
import com.yisutech.corp.domain.repository.mapper.WxExchangeRecordMapper;
import com.yisutech.corp.domain.repository.mapper.WxUserMapper;
import com.yisutech.corp.domain.repository.pojo.*;
import com.yisutech.corp.home.service.jfmall.JfMallSrv;
import com.yisutech.corp.home.service.jfmall.vo.MyExchangeRecord;
import com.yisutech.corp.home.service.wxcore.WxUserSrv;
import com.yisutech.corp.home.service.wxcore.dto.WxUserInfo;
import com.yisutech.corp.home.tools.DateUtil;
import com.yisutech.corp.home.tools.result.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.service.jfmall.impl.JfMallSrvImpl
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-19 下午1:19
 **/
@Service
public class JfMallSrvImpl implements JfMallSrv {

    @Resource
    private WxUserSrv wxUserSrv;
    @Resource
    private WxUserMapper wxUserMapper;
    @Resource
    private WxExchangeRecordMapper wxExchangeRecordMapper;
    @Resource
    private WxExchangeProductMapper wxExchangeProductMapper;

    @Transactional
    @Override
    public Result<Boolean> exchange(String code, String state, Long prodId) {

        // 1. 参数检查
        if (StringUtils.isBlank(code) || prodId == null || prodId == 0) {
            return new Result<>(false, "params_is_error", "参数不正确");
        }

        // 2. 查用户信息
        WxUserInfo wxUserInfo = wxUserSrv.getOauth2Token(code, state);
        if (wxUserInfo == null || StringUtils.isBlank(wxUserInfo.getOpenId())) {
            return new Result<>(false, "user_info_error", "找不到用户信息");
        }
        WxUserExample example = new WxUserExample();
        example.createCriteria().andOpenIdEqualTo(wxUserInfo.getOpenId());
        List<WxUser> wxUsers = wxUserMapper.selectByExample(example);
        if (wxUsers == null || wxUsers.size() == 0) {
            return new Result<>(false, "user_not_exists", "用户不存在");
        }
        WxUser wxUser = wxUsers.get(0);
        if (wxUser.getScore() <= 0) {
            return new Result<>(false, "user_score_not_enough", "用户积分不足");
        }

        // 3. 查询兑换产品
        WxExchangeProduct wxExchangeProduct = wxExchangeProductMapper.selectByPrimaryKey(prodId.intValue());
        if (wxExchangeProduct.getStock() <= 0) {
            return new Result<>(false, "product_stock_not_enough", "商品库存不足");
        }

        // 4. 扣减积分
        if (wxUser.getScore() < wxExchangeProduct.getNeedScore()) { // 判断积分是否够扣减
            return new Result<>(false, "user_score_no_exchange", "用户积分不");
        }
        // 4.1 扣减用户积分
        wxUser.setScore(wxUser.getScore() - wxExchangeProduct.getNeedScore());
        wxUser.setGmtModify(DateUtil.getNowTime());
        int update = wxUserMapper.updateByPrimaryKey(wxUser);
        // 4.2 扣减商品库存
        if (update > 0) {
            wxExchangeProduct.setStock(wxExchangeProduct.getStock() - 1);
            wxExchangeProduct.setGmtModify(DateUtil.getNowTime());
            update = wxExchangeProductMapper.updateByPrimaryKey(wxExchangeProduct);
            if (update > 0) {
                WxExchangeRecord record = new WxExchangeRecord();
                record.setGmtCreate(DateUtil.getNowTime());
                record.setOpenId(wxUser.getOpenId());
                record.setUnionId(wxUser.getUnionId());
                record.setProductId(wxExchangeProduct.getId());
                record.setScore(wxExchangeProduct.getNeedScore());
                wxExchangeRecordMapper.insert(record);
            } else {
                throw new RuntimeException("exchange fail");
            }
        }

        return new Result<>(true);
    }

    @Override
    public List<WxExchangeProduct> queryExchangeProducts() {

        WxExchangeProductExample example = new WxExchangeProductExample();

        example.setOrderByClause(" id desc");
        return wxExchangeProductMapper.selectByExample(example);
    }

    @Override
    public List<MyExchangeRecord> queryExchangeRecords(String code, String state) {

        // 1. 查用户信息
        WxUserInfo wxUserInfo = wxUserSrv.getOauth2Token(code, state);
        if (wxUserInfo == null || StringUtils.isBlank(wxUserInfo.getOpenId())) {
            return Lists.newArrayList();
        }

        // 2. 查询兑换记录
        WxExchangeRecordExample example = new WxExchangeRecordExample();
        example.createCriteria().andOpenIdEqualTo(wxUserInfo.getOpenId());
        List<WxExchangeRecord> exchangeRecords = wxExchangeRecordMapper.selectByExample(example);
        if (exchangeRecords == null || exchangeRecords.size() == 0) {
            return Lists.newArrayList();
        }

        // 3. 数据处理
        List<MyExchangeRecord> ls = Lists.newArrayList();
        exchangeRecords.forEach(exchangeRecord -> {

            MyExchangeRecord myExchangeRecord = new MyExchangeRecord();
            BeanUtils.copyProperties(exchangeRecord, myExchangeRecord);

            WxExchangeProduct wxExchangeProduct = wxExchangeProductMapper.selectByPrimaryKey(exchangeRecord.getProductId());
            if (wxExchangeProduct != null) {
                myExchangeRecord.setTitle(wxExchangeProduct.getTitle());
            }
            ls.add(myExchangeRecord);
        });

        return ls;
    }

    @Override
    public boolean saveExchangeProduct(WxExchangeProduct wxExchangeProduct) {

        if (wxExchangeProduct == null) {
            return false;
        }

        int update = 0;
        WxExchangeProduct wxExchange;
        if (wxExchangeProduct.getId() != null && wxExchangeProduct.getId() > 0) {
            wxExchange = wxExchangeProductMapper.selectByPrimaryKey(wxExchangeProduct.getId());
            BeanUtils.copyProperties(wxExchange, wxExchangeProduct);

            update = wxExchangeProductMapper.updateByPrimaryKey(wxExchange);
            return update > 0;

        } else {
            wxExchange = wxExchangeProduct;
            update = wxExchangeProductMapper.insert(wxExchange);
            return update > 0;
        }
    }

    @Override
    public WxExchangeProduct getExchangeProduct(Long productId) {
        return wxExchangeProductMapper.selectByPrimaryKey(productId.intValue());
    }
}

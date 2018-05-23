package com.yisutech.corp.home.service.pay.impl;

import com.yisutech.corp.domain.repository.mapper.WxBuyRecordMapper;
import com.yisutech.corp.domain.repository.mapper.WxOrderMapper;
import com.yisutech.corp.domain.repository.pojo.WxOrder;
import com.yisutech.corp.domain.repository.pojo.WxOrderExample;
import com.yisutech.corp.home.service.common.Constants.OrderSts;
import com.yisutech.corp.home.service.pay.OrderSrv;
import com.yisutech.corp.home.tools.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.service.pay.impl.OrderSrvImpl
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-22 下午9:21
 **/
@Service
public class OrderSrvImpl implements OrderSrv {

    @Resource
    private WxOrderMapper wxOrderMapper;
    @Resource
    private WxBuyRecordMapper wxBuyRecordMapper;

    @Override
    public WxOrder saveOrder(WxOrder wxOrder) {

        if (wxOrder == null) {
            return null;
        }

        wxOrder.setGmtCreateTime(DateUtil.getNowTime());
        wxOrder.setGmtModifyTime(DateUtil.getNowTime());
        wxOrder.setSts(OrderSts.ready.name());
        wxOrder.setOutTradeNo(UUID.randomUUID().toString().replace("-", ""));
        wxOrderMapper.insert(wxOrder);

        if (wxOrder.getId() != null && wxOrder.getId() > 0) {
            return wxOrder;
        } else {
            return null;
        }
    }

    @Override
    public WxOrder payOrder(String outTradeNo, String bankType, String transactionId, OrderSts orderSts) {

        if (StringUtils.isBlank(outTradeNo)) {
            return null;
        }

        // 查询定单是否存在
        WxOrderExample example = new WxOrderExample();
        example.createCriteria().andOutTradeNoEqualTo(outTradeNo)
                .andStsNotEqualTo(OrderSts.payed.name());

        List<WxOrder> wxOrders = wxOrderMapper.selectByExample(example);
        if (wxOrders == null || wxOrders.size() == 0) {
            return null;
        }

        // 修改定单状态
        WxOrder wxOrder = wxOrders.get(0);
        wxOrder.setTransactionId(transactionId);
        wxOrder.setSts(orderSts.name());
        wxOrder.setBankType(bankType);
        wxOrder.setGmtModifyTime(DateUtil.getNowTime());

        int update = wxOrderMapper.updateByPrimaryKeySelective(wxOrder);
        return update > 0 ? wxOrder : null;
    }


}

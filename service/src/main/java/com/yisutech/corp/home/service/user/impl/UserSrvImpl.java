package com.yisutech.corp.home.service.user.impl;

import com.google.common.collect.Maps;
import com.yisutech.corp.domain.repository.mapper.WxUserMapper;
import com.yisutech.corp.domain.repository.pojo.WxUser;
import com.yisutech.corp.domain.repository.pojo.WxUserExample;
import com.yisutech.corp.home.service.common.Config;
import com.yisutech.corp.home.service.user.UserSrv;
import com.yisutech.corp.home.service.wxcore.WxUserSrv;
import com.yisutech.corp.home.service.wxcore.dto.WxUserInfo;
import com.yisutech.corp.home.third_party.sms.SendMessageSrv;
import com.yisutech.corp.home.tools.DateUtil;
import com.yisutech.corp.home.tools.result.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.service.user.impl.UserSrvImpl
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-19 下午12:14
 **/
@Service
public class UserSrvImpl implements UserSrv {

    @Resource
    private Config config;
    @Resource
    private WxUserSrv wxUserSrv;
    @Resource
    private WxUserMapper wxUserMapper;
    @Resource
    private SendMessageSrv sendMessageSrv;

    @Override
    public Result<Boolean> userRegister(String code, String mobile, String state) {

        if (!config.WxOpenState.equals(state)) {
            return new Result<>(false, "params_error", "state is error");
        }
        // 获取accessToken, refreshToken
        WxUserInfo wxUserInfo = wxUserSrv.getOauth2Token(code, state);
        if (wxUserInfo == null || StringUtils.isBlank(wxUserInfo.getOpenId())) {
            return new Result<>(false, "getOauth2Token", "凭证失效");
        }

        // 获取微信用户信息
        String lang = "zh_CN";
        WxUserInfo userDetailInfo = wxUserSrv.getUserInfo(wxUserInfo.getAccessToken(), config.WxAppId, lang);

        // 保存用户信息
        WxUserExample example = new WxUserExample();
        example.createCriteria().andUnionIdEqualTo(userDetailInfo.getOpenId());
        List<WxUser> wxUsers = wxUserMapper.selectByExample(example);


        WxUser wxUser;
        if (wxUsers != null && wxUsers.size() > 0) { // 更新用户信息
            wxUser = wxUsers.get(0);
            wxUser.setAvartorUrl(userDetailInfo.getHeadImgUrl());
            wxUser.setOpenId(userDetailInfo.getOpenId());
            wxUser.setMobile(mobile);
            wxUser.setNick(userDetailInfo.getNickname());
            wxUser.setGmtModify(DateUtil.getNowTime());
            wxUserMapper.updateByPrimaryKey(wxUser);
        } else { // 写入用户信息
            wxUser = new WxUser();
            wxUser.setUnionId(userDetailInfo.getUnionId());
            wxUser.setOpenId(userDetailInfo.getOpenId());
            wxUser.setMobile(mobile);
            wxUser.setAvartorUrl(userDetailInfo.getHeadImgUrl());
            wxUser.setApp(config.WxAppId);
            wxUser.setSecurity(config.WxAppSecret);
            wxUser.setNick(userDetailInfo.getNickname());
            wxUser.setCity(userDetailInfo.getCity());
            wxUser.setProvince(userDetailInfo.getProvince());
            wxUser.setCountry(userDetailInfo.getCountry());
            wxUser.setSex(userDetailInfo.getSex());
            wxUser.setScore(0);
            wxUser.setGmtModify(DateUtil.getNowTime());
            wxUser.setGmtCreate(DateUtil.getNowTime());
            wxUserMapper.insert(wxUser);
        }

        return new Result<>(true);
    }

    @Override
    public WxUser getUserInfo(String code) {

        if (StringUtils.isBlank(code)) {
            return null;
        }
        // 获取accessToken, refreshToken
        WxUserInfo wxUserInfo = wxUserSrv.getOauth2Token(code, config.WxOpenState);
        if (wxUserInfo == null || StringUtils.isBlank(wxUserInfo.getOpenId())) {
            return null;
        }

        // 查询用户信息
        WxUserExample example = new WxUserExample();
        example.createCriteria().andOpenIdEqualTo(wxUserInfo.getOpenId());
        List<WxUser> wxUsers = wxUserMapper.selectByExample(example);

        if (wxUsers == null || wxUsers.size() == 0) {
            return null;
        }

        // 对象转换
        return wxUsers.get(0);
    }

    @Override
    public boolean sendVerifyCode(String mobile, String code) {

        String corpTag = "";
        String outId = "";
        String mobiles = mobile;
        String templateCode = "";

        Map<String, Object> params = Maps.newHashMap();
        params.putIfAbsent("code", code);

        return sendMessageSrv.sendSms(corpTag, mobiles, templateCode, params, outId);
    }
}

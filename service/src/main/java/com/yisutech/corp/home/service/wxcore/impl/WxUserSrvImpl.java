package com.yisutech.corp.home.service.wxcore.impl;

import com.alibaba.fastjson.JSONObject;
import com.yisutech.corp.home.service.common.Config;
import com.yisutech.corp.home.service.wxcore.WxUserSrv;
import com.yisutech.corp.home.service.wxcore.dto.WxUserInfo;
import com.yisutech.corp.home.tools.HttpUtils;
import org.apache.commons.codec.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.service.wxcore.impl.WxUserSrvImpl
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-19 上午8:50
 **/
@Service
public class WxUserSrvImpl implements WxUserSrv {

    @Resource
    private Config config;

    @Override
    public WxUserInfo getOauth2Token(String code, String state) {

        if (StringUtils.isBlank(code)) {
            return null;
        }

        StringBuilder url = new StringBuilder(config.WxCgiUrl);
        url.append("/sns/oauth2/access_token?")
                .append("appid=").append(config.WxAppId).append("&")
                .append("secret=").append(config.WxAppSecret).append("&")
                .append("code=").append("CODE").append("&")
                .append("grant_type=").append("authorization_code");

        String respJson = HttpUtils.getReq(url.toString(), Charsets.UTF_8);
        if (StringUtils.isBlank(respJson)) {
            return null;
        }

        WxUserInfo userInfo = new WxUserInfo();
        JSONObject repJson = JSONObject.parseObject(respJson);

        userInfo.setAccessToken(repJson.getString("access_token"));
        userInfo.setRefreshToken(repJson.getString("refresh_token"));
        userInfo.setOpenId(repJson.getString("openid"));

        return userInfo;
    }

    @Override
    public WxUserInfo refreshOauth2Token(String appid, String grantType, String refreshToken) {

        if (StringUtils.isBlank(refreshToken)) {
            return null;
        }

        StringBuilder url = new StringBuilder(config.WxCgiUrl);
        url.append("/sns/oauth2/refresh_token?")
                .append("appid=").append(config.WxAppId).append("&")
                .append("grant_type=").append("refresh_token").append("&")
                .append("refresh_token=").append(refreshToken);

        String respJson = HttpUtils.getReq(url.toString(), Charsets.UTF_8);
        if (StringUtils.isBlank(respJson)) {
            return null;
        }

        WxUserInfo userInfo = new WxUserInfo();
        JSONObject repJson = JSONObject.parseObject(respJson);

        userInfo.setAccessToken(repJson.getString("access_token"));
        userInfo.setRefreshToken(repJson.getString("refresh_token"));
        userInfo.setOpenId(repJson.getString("openid"));

        return userInfo;
    }

    @Override
    public WxUserInfo getUserInfo(String accessToken, String openId, String lang) {

        if (StringUtils.isBlank(accessToken)) {
            return null;
        }

        StringBuilder url = new StringBuilder(config.WxCgiUrl);
        url.append("/sns/userinfo?")
                .append("access_token=").append(accessToken).append("&")
                .append("openid=").append(openId).append("&")
                .append("lang=").append(lang);

        String respJson = HttpUtils.getReq(url.toString(), Charsets.UTF_8);
        if (StringUtils.isBlank(respJson)) {
            return null;
        }

        WxUserInfo userInfo = new WxUserInfo();
        JSONObject repJson = JSONObject.parseObject(respJson);

        userInfo.setOpenId(repJson.getString("openid"));
        userInfo.setCity(repJson.getString("city"));
        userInfo.setProvince(repJson.getString("province"));
        userInfo.setCountry(repJson.getString("country"));
        userInfo.setHeadImgUrl(repJson.getString("headimgurl"));
        userInfo.setNickname(repJson.getString("nickname"));
        userInfo.setSex(repJson.getString("sex"));
        userInfo.setUnionId(repJson.getString("unionid"));

        return userInfo;
    }
}

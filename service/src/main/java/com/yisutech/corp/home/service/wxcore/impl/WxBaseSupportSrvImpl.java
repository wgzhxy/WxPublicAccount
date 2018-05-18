package com.yisutech.corp.home.service.wxcore.impl;

import com.alibaba.fastjson.JSONObject;
import com.yisutech.corp.home.service.common.Config;
import com.yisutech.corp.home.service.wxcore.WxBaseSupportSrv;
import com.yisutech.corp.home.tools.HttpUtils;
import org.apache.commons.codec.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.service.wxcore.impl.WxBaseSupportSrvImpl
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-18 下午2:07
 **/
@Service
public class WxBaseSupportSrvImpl implements WxBaseSupportSrv {

    @Resource
    private Config config;

    private static Logger LOG = LoggerFactory.getLogger(WxBaseSupportSrvImpl.class);


    @Override
    public String getAccessToken() {
        return getAccessToken(config.WxAppId, config.WxAppSecret);
    }

    @Override
    public String getAccessToken(final String appId, final String secret) {

        if (StringUtils.isBlank(appId) || StringUtils.isBlank(secret)) {
            return "";
        }

        StringBuilder url = new StringBuilder(config.WxCgiUrl);

        url.append("token?").append("grant_type=client_credential").append("&")
                .append("appid=").append(appId).append("&")
                .append("secret=").append(secret);

        String respStr = "";
        try {
            respStr = HttpUtils.getReq(url.toString(), Charsets.UTF_8);

        } catch (Throwable e) {
            LOG.error("getAccessToken_error", e);
        }
        if (StringUtils.isBlank(respStr)) {
            return "";
        }

        JSONObject json = JSONObject.parseObject(respStr);
        return json == null ? "" : json.getString("access_token");
    }
}

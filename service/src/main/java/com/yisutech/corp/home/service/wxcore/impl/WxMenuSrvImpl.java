package com.yisutech.corp.home.service.wxcore.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.yisutech.corp.home.service.common.Config;
import com.yisutech.corp.home.service.wxcore.WxBaseSupportSrv;
import com.yisutech.corp.home.service.wxcore.WxMenuSrv;
import com.yisutech.corp.home.tools.HttpUtils;
import org.apache.commons.codec.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.service.wxcore.impl.WxMenuSrvImpl
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-18 下午2:56
 **/
@Service
public class WxMenuSrvImpl implements WxMenuSrv {

    @Resource
    private Config config;
    @Resource
    private WxBaseSupportSrv wxBaseSupportSrv;

    private static Logger LOG = LoggerFactory.getLogger(WxMenuSrvImpl.class);

    @Override
    public boolean createMenu(String menuJson) {

        String validToken = wxBaseSupportSrv.getAccessToken();
        if (StringUtils.isBlank(validToken)) {
            return false;
        }

        StringBuilder url = new StringBuilder(config.WxCgiUrl);
        url.append("/menu/create?").append("access_token=").append(validToken);

        Map<String, Object> params = Maps.newHashMap();
        params.putIfAbsent("body", menuJson);

        String respJson = HttpUtils.postReq(url.toString(), menuJson, ContentType.APPLICATION_JSON, Charsets.UTF_8);
        if (StringUtils.isBlank(respJson)) {
            return false;
        }

        JSONObject repJson = JSONObject.parseObject(respJson);
        boolean ops = (repJson == null ? false : repJson.getInteger("errcode") == 0);
        if (!ops) {
            LOG.error("createMenu_error, {}, {}", menuJson, respJson);
        }
        return ops;
    }

    @Override
    public String getMenu(String token) {
        String validToken = token;
        if (StringUtils.isBlank(validToken)) {
            validToken = wxBaseSupportSrv.getAccessToken();
        }

        if (StringUtils.isBlank(validToken)) {
            return null;
        }

        StringBuilder url = new StringBuilder(config.WxCgiUrl);
        url.append("/menu/get?").append("access_token=").append(validToken);

        String respJson = HttpUtils.getReq(url.toString(), Charsets.UTF_8);
        if (StringUtils.isBlank(respJson)) {
            return null;
        }

        return respJson;
    }

    @Override
    public boolean deleteMenu() {

        String validToken = wxBaseSupportSrv.getAccessToken();
        if (StringUtils.isBlank(validToken)) {
            return false;
        }

        StringBuilder url = new StringBuilder(config.WxCgiUrl);
        url.append("/menu/delete?").append("access_token=").append(validToken);

        String respJson = HttpUtils.getReq(url.toString(), Charsets.UTF_8);
        if (StringUtils.isBlank(respJson)) {
            return false;
        }

        JSONObject repJson = JSONObject.parseObject(respJson);
        return repJson == null ? false : repJson.getInteger("errcode") == 0;
    }
}

package com.yisutech.corp.home.service.wxcore.impl;

import com.yisutech.corp.home.service.common.Config;
import com.yisutech.corp.home.service.wxcore.WxBaseSupportSrv;
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


    @Override
    public String getAccessToken() {


        return null;
    }

    @Override
    public String getAccessToken(String appId, String secret) {
        return null;
    }
}

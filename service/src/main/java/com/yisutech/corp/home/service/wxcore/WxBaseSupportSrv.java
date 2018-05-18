package com.yisutech.corp.home.service.wxcore;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.service.wxcore.WxBaseSupportSrv
 * 描述：
 * <p>
 * <p>
 * 微信公众号-基础支持管理
 *
 * @author guangzhong.wgz
 * @create 2018-05-18 下午2:07
 **/
public interface WxBaseSupportSrv {

    /**
     * 获取方问token
     *
     * @return token
     */
    String getAccessToken();

    /**
     * 获取方问token
     *
     * @param appId
     * @param secret
     * @return token
     */
    String getAccessToken(String appId, String secret);
}

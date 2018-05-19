package com.yisutech.corp.home.service.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.service.common.Config
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-18 下午2:14
 **/
@Component
public class Config {

    @Value("${wx.test.appId}")
    public String WxAppId;

    @Value("${wx.test.appSecret}")
    public String WxAppSecret;

    public String WxCgiUrl = "https://api.weixin.qq.com/cgi-bin";

    public String WxOpenUrl = "https://open.weixin.qq.com";

    public String accessToken = "";

    public String mobile_tmeplateCode = "SMS_135042847";

    public String mobile_sign_name = "贵州贵人";
}

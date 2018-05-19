package com.yisutech.corp.home.service.wxcore;

import com.yisutech.corp.home.service.wxcore.dto.WxUserInfo;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.service.wxcore.WxUserSrv
 * 描述：
 * <p>
 * 微信公众号-用户管理
 *
 * @author guangzhong.wgz
 * @create 2018-05-18 下午2:08
 **/
public interface WxUserSrv {

    /**
     * 微信公众号页面授权, 获取方问用户信息token
     *
     * @param code  code作为换取access_token的票据
     *              ps : 每次用户授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期
     * @param state 重定向后会带上state参数
     *              ps : 开发者可以填写a-zA-Z0-9的参数值，最多128字节
     * @return
     */
    WxUserInfo getOauth2Token(String code, String state);


    /**
     * 刷新token
     *
     * @param appid        公众号appId
     * @param grantType    refresh_token
     * @param refreshToken 填写通过getOauth2Token获取到的refresh_token参数
     *                     ps : refresh_token有效期为30天,
     * @return
     */
    WxUserInfo refreshOauth2Token(String appid, String grantType, String refreshToken);

    /**
     * 获取授权用户信息
     *
     * @param accessToken 网页授权接口调用凭证
     * @param openId      公众号appId
     * @param lang        返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     * @return
     */
    WxUserInfo getUserInfo(String accessToken, String openId, String lang);
}

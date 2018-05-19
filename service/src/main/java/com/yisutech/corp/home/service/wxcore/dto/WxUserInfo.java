package com.yisutech.corp.home.service.wxcore.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.service.wxcore.dto.WxUserInfo
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-19 上午9:35
 **/
@Data
public class WxUserInfo implements Serializable {

    private static final long serialVersionUID = 649680381211468591L;

    /**
     * 公众号ID
     */
    String openId;
    /**
     * 统一ID
     */
    String unionId;
    /**
     * 访问token
     */
    String accessToken;
    /**
     * 刷新token
     */
    String refreshToken;
    /**
     * 用户昵称
     */
    String nickname;
    /**
     * 性别
     * ps: 值为1时是男性，值为2时是女性，值为0时是未知
     */
    String sex;
    /**
     * 省份
     */
    String province;
    /**
     * 城市
     */
    String city;
    /**
     * 国家
     */
    String country;
    /**
     * 用户头像
     * <p>
     * ps: 用户头像，
     * 最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），
     * 用户没有头像时该项为空。若用户更换头像，
     * 原有头像URL将失效
     */
    String headImgUrl;

}

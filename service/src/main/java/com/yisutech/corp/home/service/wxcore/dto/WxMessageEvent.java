package com.yisutech.corp.home.service.wxcore.dto;

import lombok.Data;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：WxMessageText
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-18 下午11:48
 **/
@Data
public class WxMessageEvent extends WxMessage {

    String event;
    String eventKey;
    String msgId;
    /**
     * 地理位置纬度
     */
    float latitude;
    /**
     * 地理位置经度
     */
    float longitude;
    /**
     * 地理位置精度
     */
    float precision;
    /**
     * 二维码的ticket，可用来换取二维码图片
     */
    String ticket;
}

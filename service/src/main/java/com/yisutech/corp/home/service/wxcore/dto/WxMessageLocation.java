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
public class WxMessageLocation extends WxMessage {
    /**
     * 经度
     */
    String LocationX;
    /**
     * 纬度
     */
    String LocationY;
    /**
     * 消息ID
     */
    String msgId;
    /**
     * 缩放
     */
    Integer scale;
    /**
     * 文件描述
     */
    String label;
}

package com.yisutech.corp.home.service.wxcore.dto;

import lombok.Data;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.service.wxcore.dto.WxMessage
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-18 下午11:39
 **/
@Data
public abstract class WxMessage {
    /**
     * 消息接收人
     */
    String toUserName;
    /**
     * 消息发送人
     */
    String fromUserName;
    /**
     * 创建时间
     */
    String createTime;
    /**
     * 消息类型
     */
    String msgType;

    public enum MsgType {
        text, event, image, voice, video, shortvideo, music, news, location, link;
    }
}

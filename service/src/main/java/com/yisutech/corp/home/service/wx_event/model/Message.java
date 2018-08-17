package com.yisutech.corp.home.service.wx_event.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yisutech.corp.home.service.common.Constants.MsgType;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 版权：Copyright by www.yisutech.com
 * 项目：WxPublicAccount
 * 文件名：com.yisutech.corp.home.service.wx_event.model.Message
 * 描述：
 * Message
 *
 * @author guangzhong.wgz@yisutech.com
 * @version 1.0
 * @create 2018-08-16 15:48
 **/
@Data
@XStreamAlias("xml")
public abstract class Message {
	/**
	 * 接收人
	 */
	@NotEmpty
	@XStreamAlias("ToUserName")
	String toUserName;
	/**
	 * 发送人
	 */
	@NotEmpty
	@XStreamAlias("FromUserName")
	String fromUserName;
	/**
	 * 消息类型
	 */
	@NotNull
	@XStreamAlias("MsgType")
	MsgType msgType;
	/**
	 * 创建时间
	 */
	@NotEmpty
	@XStreamAlias("CreateTime")
	Long createTime;
}

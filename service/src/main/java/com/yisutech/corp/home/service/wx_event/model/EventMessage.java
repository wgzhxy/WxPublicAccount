package com.yisutech.corp.home.service.wx_event.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yisutech.corp.home.service.common.Constants.EventType;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 版权：Copyright by www.yisutech.com
 * 项目：WxPublicAccount
 * 文件名：com.yisutech.corp.home.service.wx_event.model.EventMessage
 * 描述：
 * EventMessage
 *
 * @author guangzhong.wgz@yisutech.com
 * @version 1.0
 * @create 2018-08-16 16:41
 **/
@Data
@XStreamAlias("xml")
public class EventMessage extends Message {
	/**
	 * 事件类型
	 */
	@NotNull
	@XStreamAlias("Event")
	EventType event;
}

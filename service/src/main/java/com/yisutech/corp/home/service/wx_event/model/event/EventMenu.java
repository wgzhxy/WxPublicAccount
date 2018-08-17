package com.yisutech.corp.home.service.wx_event.model.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yisutech.corp.home.service.common.Constants;
import com.yisutech.corp.home.service.wx_event.model.EventMessage;
import com.yisutech.corp.home.service.wx_event.model.Message;
import lombok.Data;

/**
 * 版权：Copyright by www.yisutech.com
 * 项目：WxPublicAccount
 * 文件名：com.yisutech.corp.home.service.wx_event.model.event.EventFocusOrUnFocus
 * 描述：
 * EventFocusOrUnFocus
 *
 * @author guangzhong.wgz@yisutech.com
 * @version 1.0
 * @create 2018-08-16 16:18
 **/
@Data
@XStreamAlias("xml")
public class EventMenu extends EventMessage {

	/**
	 * 事件类型，CLICK
	 * ps:
	 * <p>
	 * 1) 点击菜单跳转链接时的事件推送 VIEW
	 * 2) 点击菜单拉取消息时的事件推送 CLICK
	 */
	@XStreamAlias("Event")
	Constants.EventType event;
	/**
	 * 事件KEY值，与自定义菜单接口中KEY值对应
	 */
	@XStreamAlias("EventKey")
	String eventKey;
}

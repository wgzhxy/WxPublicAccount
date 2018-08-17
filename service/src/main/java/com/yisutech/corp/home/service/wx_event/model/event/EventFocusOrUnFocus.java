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
public class EventFocusOrUnFocus extends EventMessage {

	/**
	 * 事件类型，subscribe(订阅)、SCAN
	 * <p>
	 * ps
	 * 1) 用户未关注时，进行关注后的事件推送, 事件类型，subscribe
	 * 2) 用户已关注时的事件推送, 事件类型，SCAN
	 */
	@XStreamAlias("Event")
	Constants.EventType event;
}

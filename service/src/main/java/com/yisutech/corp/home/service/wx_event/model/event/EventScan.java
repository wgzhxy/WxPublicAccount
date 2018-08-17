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
public class EventScan extends EventMessage {

	/**
	 * 事件类型，subscribe(订阅)、unsubscribe(取消订阅)
	 */
	@XStreamAlias("Event")
	Constants.EventType event;
	/**
	 * 事件KEY值，qrscene_为前缀，后面为二维码的参数值
	 */
	@XStreamAlias("EventKey")
	String eventKey;
	/**
	 * 二维码的ticket，可用来换取二维码图片
	 */
	@XStreamAlias("Ticket")
	String ticket;
}

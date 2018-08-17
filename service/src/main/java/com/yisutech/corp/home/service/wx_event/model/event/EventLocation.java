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
public class EventLocation extends EventMessage {

	/**
	 * 事件类型，LOCATION
	 */
	@XStreamAlias("Event")
	Constants.EventType event;
	/**
	 * 地理位置纬度
	 */
	@XStreamAlias("Latitude")
	String latitude;
	/**
	 * 地理位置经度
	 */
	@XStreamAlias("Longitude")
	String longitude;
	/**
	 * 地理位置精度
	 */
	@XStreamAlias("Precision")
	String precision;
}

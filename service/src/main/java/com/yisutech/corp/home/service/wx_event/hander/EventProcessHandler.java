package com.yisutech.corp.home.service.wx_event.hander;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.thoughtworks.xstream.XStream;
import com.yisutech.corp.home.service.wx_event.EventHandler;
import com.yisutech.corp.home.service.wx_event.model.EventMessage;
import com.yisutech.corp.home.service.wx_event.model.Message;
import com.yisutech.corp.home.tools.DateUtil;
import org.springframework.stereotype.Component;

import static com.yisutech.corp.home.service.common.Constants.EventType.*;

import java.util.List;

/**
 * 版权：Copyright by www.yisutech.com
 * 项目：WxPublicAccount
 * 文件名：com.yisutech.corp.home.service.wx_event.hander.CommReplyHandler
 * 描述：
 * CommReplyHandler
 *
 * @author guangzhong.wgz@yisutech.com
 * @version 1.0
 * @create 2018-08-16 16:31
 **/
@Component
public class EventProcessHandler implements EventHandler {

	@Override
	public String process(Message message) {

		if (!(message instanceof EventMessage)) {
			throw new RuntimeException("event type error!");
		}

		EventMessage eventMessage = (EventMessage) message;
		switch (eventMessage.getEvent()) {
			case SCAN:
			case subscribe:
			case unsubscribe:
			case LOCATION:
			case VIEW:
			default:
				break;
		}

		String toUser = message.getToUserName();
		String fromUser = message.getFromUserName();

		message.setToUserName(fromUser);
		message.setFromUserName(toUser);
		message.setCreateTime(DateUtil.getNowTime().getTime());

		XStream xStream = new XStream();
		xStream.processAnnotations(message.getClass());
		return xStream.toXML(message);
	}

	@Override
	public List<String> getMappingEvent() {
		return Lists.newArrayList(SCAN.name(), subscribe.name(),
				unsubscribe.name(), LOCATION.name());
	}
}

package com.yisutech.corp.home.service.wx_event;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.yisutech.corp.home.service.common.Constants;
import com.yisutech.corp.home.service.common.Constants.MsgType;
import com.yisutech.corp.home.service.wx_event.model.EventMessage;
import com.yisutech.corp.home.service.wx_event.model.Message;
import com.yisutech.corp.home.service.wx_event.model.event.EventFocusOrUnFocus;
import com.yisutech.corp.home.service.wx_event.model.event.EventLocation;
import com.yisutech.corp.home.service.wx_event.model.event.EventMenu;
import com.yisutech.corp.home.service.wx_event.model.event.EventScan;
import com.yisutech.corp.home.service.wx_event.model.msg.*;
import com.yisutech.corp.home.tools.XmlParseUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 版权：Copyright by www.yisutech.com
 * 项目：WxPublicAccount
 * 文件名：com.yisutech.corp.home.service.wx_event.EventProcessorImpl
 * 描述：
 * EventProcessorImpl
 *
 * @author guangzhong.wgz@yisutech.com
 * @version 1.0
 * @create 2018-08-16 15:30
 **/
@Service
public class EventProcessorImpl implements MessageProcessor {

	private static AtomicBoolean initOne = new AtomicBoolean();
	private final Map<String, EventHandler> messageProcessorMap = Maps.newConcurrentMap();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response, String xml) {

		Map<String, Object> xmlMap = XmlParseUtils.parseXmlToMap(xml);

		String msgTypeName = (String) xmlMap.get("MsgType");
		if (StringUtils.isBlank(msgTypeName)) {
			throw new RuntimeException("MsgType is empty");
		}

		initMessageProcessor(request);

		String replyContent = "";
		MsgType msgType = MsgType.valueOf(msgTypeName);
		switch (msgType) {
			case text:
				replyContent = messageProcessorMap.get(msgType.name()).process(toMessage(xmlMap, msgTypeName));
				break;
			case image:
			case voice:
			case video:
			case music:
			case news:
			case location:
			case link:
				replyContent = messageProcessorMap.get(msgType.name()).process(toMessage(xmlMap, msgTypeName));
				break;
			case event:
				replyContent = messageProcessorMap.get(msgType.name()).process(toMessage(xmlMap, msgTypeName));
				break;
			default:
				break;
		}
		return replyContent;
	}

	private void initMessageProcessor(HttpServletRequest request) {
		if (initOne.compareAndSet(false, true)) {
			WebApplicationContext context;
			context = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
			Map<String, EventHandler> tpMap = context.getBeansOfType(EventHandler.class);
			tpMap.values().forEach(eventHandler -> {
				eventHandler.getMappingEvent().forEach(event -> {
					messageProcessorMap.putIfAbsent(event, eventHandler);
				});
			});
		}
	}

	private Message toMessage(Map<String, Object> xmlMap, String msgTypeName) {
		JSONObject msgJson = new JSONObject();
		xmlMap.forEach((k, v) -> {
			String key = StringUtils.lowerCase(k.charAt(0) + "") + k.substring(1, k.length());
			msgJson.putIfAbsent(key, v);
		});
		switch (MsgType.valueOf(msgTypeName)) {
			case text:
				return JSON.toJavaObject(msgJson, MessageText.class);

			case image:
				return JSON.toJavaObject(msgJson, MessageImage.class);

			case video:
				return JSON.toJavaObject(msgJson, MessageVideo.class);

			case voice:
				return JSON.toJavaObject(msgJson, MessageVoice.class);

			case music:
				return JSON.toJavaObject(msgJson, MessageMusic.class);

			case news:
				return JSON.toJavaObject(msgJson, MessageNews.class);

			case event:
				EventMessage eventMessage = JSON.toJavaObject(msgJson, EventMessage.class);

				if (eventMessage.getEvent() == Constants.EventType.CLICK
						|| eventMessage.getEvent() == Constants.EventType.VIEW) {
					return JSON.toJavaObject(JSONObject.parseObject(JSON.toJSONString(xmlMap)), EventMenu.class);

				} else if (eventMessage.getEvent() == Constants.EventType.LOCATION) {
					return JSON.toJavaObject(JSONObject.parseObject(JSON.toJSONString(xmlMap)), EventLocation.class);

				} else if (eventMessage.getEvent() == Constants.EventType.SCAN) {
					return JSON.toJavaObject(JSONObject.parseObject(JSON.toJSONString(xmlMap)), EventScan.class);

				} else if (eventMessage.getEvent() == Constants.EventType.subscribe
						|| eventMessage.getEvent() == Constants.EventType.unsubscribe) {
					return JSON.toJavaObject(JSONObject.parseObject(JSON.toJSONString(xmlMap)), EventFocusOrUnFocus.class);

				}
			default:
				break;
		}
		return null;
	}
}

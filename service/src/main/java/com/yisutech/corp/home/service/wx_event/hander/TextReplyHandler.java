package com.yisutech.corp.home.service.wx_event.hander;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.thoughtworks.xstream.XStream;
import com.yisutech.corp.home.service.chat.ChatService;
import com.yisutech.corp.home.service.wx_event.EventHandler;
import com.yisutech.corp.home.service.wx_event.model.Message;
import com.yisutech.corp.home.service.wx_event.model.msg.MessageText;
import com.yisutech.corp.home.tools.DateUtil;
import com.yisutech.corp.home.tools.MD5Util;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

import static com.yisutech.corp.home.service.common.Constants.MsgType.*;

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
public class TextReplyHandler implements EventHandler {

	@Resource
	private ChatService chatService;

	@Override
	public String process(Message message) {

		if (message.getMsgType() == text) {

			MessageText messageText = (MessageText) message;
			String reply = chatService.chat(messageText.getContent(), 0, MD5Util.MD5Encode(message.getFromUserName(), "utf-8"));

			String toUser = messageText.getToUserName();
			String fromUser = messageText.getFromUserName();

			messageText.setToUserName(fromUser);
			messageText.setFromUserName(toUser);

			if (!StringUtils.isEmpty(reply)) {

				JSONObject jsonObject = JSON.parseObject(reply);
				JSONArray result = jsonObject.getJSONArray("results");

				messageText.setContent("");
				result.stream().forEach(obj -> {
					JSONObject objJson = (JSONObject) obj;
					if (objJson != null && objJson.getString("resultType").equals("text")) {
						messageText.setContent(messageText.getContent() + "\n" + objJson.getJSONObject("values").getString("text"));
					}
				});
			}

			messageText.setCreateTime(DateUtil.getNowTime().getTime());
		}
		XStream xStream = new XStream();
		xStream.processAnnotations(MessageText.class);
		return xStream.toXML(message);
	}

	@Override
	public List<String> getMappingEvent() {
		return Lists.newArrayList(text.name());
	}
}

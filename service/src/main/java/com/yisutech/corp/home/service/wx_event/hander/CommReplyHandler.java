package com.yisutech.corp.home.service.wx_event.hander;

import com.google.common.collect.Lists;
import com.thoughtworks.xstream.XStream;
import com.yisutech.corp.home.service.wx_event.EventHandler;
import com.yisutech.corp.home.service.wx_event.model.Message;
import com.yisutech.corp.home.tools.DateUtil;
import org.springframework.stereotype.Component;

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
public class CommReplyHandler implements EventHandler {

	@Override
	public String process(Message message) {

		switch (message.getMsgType()) {
			case text:
			case image:
			case news:
			case video:
			case voice:
			case music:
			case link:
			case location:

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
		return Lists.newArrayList(text.name(),
				image.name(), news.name(),
				video.name(), voice.name(),
				music.name(), link.name(),
				location.name());
	}
}

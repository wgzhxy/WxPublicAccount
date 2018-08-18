package com.yisutech.corp.home.service.chat.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.yisutech.corp.home.service.chat.ChatService;
import com.yisutech.corp.home.tools.HttpUtils;
import org.apache.http.entity.ContentType;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 版权：Copyright by www.yisutech.com
 * 项目：WxPublicAccount
 * 文件名：com.yisutech.corp.home.service.chat.impl.ChatServiceImpl
 * 描述：
 * ChatServiceImpl
 *
 * @author guangzhong.wgz@yisutech.com
 * @version 1.0
 * @create 2018-08-18 17:33
 **/
@Service
public class TuringRobotChatServiceImpl implements ChatService {

	final String TURING_ROBOT_API = "http://openapi.tuling123.com/openapi/api/v2";
	final String USER_APP_KEY = "beaaaf2d858c465991a01ced5bb91009";

	@Override
	public String chat(String text, Integer type, String userId)    {

		// 输入类型:0-文本(默认)、1-图片、2-音频
		JSONObject req = new JSONObject();
		req.put("reqType", type);

		// 用户信息
		Map<String, String> userInfo = Maps.newHashMap();
		userInfo.putIfAbsent("apiKey", USER_APP_KEY);
		userInfo.putIfAbsent("userId", userId);
		req.put("userInfo", userInfo);

		//
		Map<String, Object> perception = Maps.newHashMap();

		JSONObject inputText = new JSONObject();
		if(type == 0) {
			inputText.put("text", text);
			perception.putIfAbsent("inputText", inputText);

		} else if(type == 1) {
			inputText.put("url", text);
			perception.putIfAbsent("inputImage", inputText);

		} else if(type == 2) {
			inputText.put("text", text);
			perception.putIfAbsent("inputImage", "");
		}

		req.put("perception", perception);

		return HttpUtils.postReq(TURING_ROBOT_API, req.toJSONString(), ContentType.APPLICATION_JSON, Charsets.UTF_8);
	}
}

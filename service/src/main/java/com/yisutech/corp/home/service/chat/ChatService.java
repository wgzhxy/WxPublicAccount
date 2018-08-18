package com.yisutech.corp.home.service.chat;

/**
 * 版权：Copyright by www.yisutech.com
 * 项目：WxPublicAccount
 * 文件名：com.yisutech.corp.home.service.chat.ChatService
 * 描述：
 * ChatService
 *
 * @author guangzhong.wgz@yisutech.com
 * @version 1.0
 * @create 2018-08-18 17:32
 **/
public interface ChatService {

	String chat(String inputText, Integer type, String userId);
}

package com.yisutech.corp.home.service.wx_event;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 版权：Copyright by www.yisutech.com
 * 项目：WxPublicAccount
 * 文件名：com.yisutech.corp.home.service.wx_event.MessageProcessor
 * 描述：
 * MessageProcessor
 *
 * @author guangzhong.wgz@yisutech.com
 * @version 1.0
 * @create 2018-08-16 15:26
 **/
public interface MessageProcessor {

	/**
	 * 微信公众号消息处理
	 *
	 * @param request
	 * @param response
	 * @param xml
	 */
	String process(HttpServletRequest request, HttpServletResponse response, String xml);
}

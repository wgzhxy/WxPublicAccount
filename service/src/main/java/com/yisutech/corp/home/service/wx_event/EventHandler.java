package com.yisutech.corp.home.service.wx_event;

import com.yisutech.corp.home.service.wx_event.model.Message;

import java.util.List;

/**
 * 版权：Copyright by www.yisutech.com
 * 项目：WxPublicAccount
 * 文件名：com.yisutech.corp.home.service.wx_event.EventHandler
 * 描述：
 * EventHandler
 *
 * @author guangzhong.wgz@yisutech.com
 * @version 1.0
 * @create 2018-08-16 15:18
 **/
public interface EventHandler {
	/**
	 * 处理器
	 *
	 * @return 返回xml文件
	 */
	String process(Message message);

	/**
	 * 映射到处理事件
	 *
	 * @return
	 */
	List<String> getMappingEvent();
}

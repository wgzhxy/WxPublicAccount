package com.yisutech.corp.home.service.common;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.service.common.Constants
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-22 下午9:34
 **/
public interface Constants {

	String CHARSET_UTF_8 = "utf-8";

	enum OrderSts {
		ready, payed, fail
	}

	enum MsgType {
		text, image, voice, video, music, news, location, link, event;
	}

	enum EventType {
		subscribe, unsubscribe, SCAN, LOCATION, CLICK, VIEW;
	}
}

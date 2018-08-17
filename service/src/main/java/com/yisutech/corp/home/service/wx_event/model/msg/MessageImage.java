package com.yisutech.corp.home.service.wx_event.model.msg;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yisutech.corp.home.service.wx_event.model.Message;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 版权：Copyright by www.yisutech.com
 * 项目：WxPublicAccount
 * 文件名：com.yisutech.corp.home.service.wx_event.model.MessageText
 * 描述：
 * MessageText
 *
 * @author guangzhong.wgz@yisutech.com
 * @version 1.0
 * @create 2018-08-16 15:51
 **/
@Data
@XStreamAlias("xml")
public class MessageImage extends Message {

	/**
	 * 图片媒体ID
	 */
	@NotEmpty
	@XStreamAlias("MediaId")
	String mediaId;
}

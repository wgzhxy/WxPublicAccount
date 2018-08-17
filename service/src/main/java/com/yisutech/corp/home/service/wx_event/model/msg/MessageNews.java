package com.yisutech.corp.home.service.wx_event.model.msg;

import com.google.common.collect.Lists;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yisutech.corp.home.service.wx_event.model.Message;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

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
public class MessageNews extends Message {
	/**
	 * 图文消息个数，限制为8条以内
	 */
	@NotNull
	@Positive
	@XStreamAlias("ArticleCount")
	Integer articleCount;
	/**
	 * 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过8，则将会无响应
	 */
	@NotNull
	@NotEmpty
	@XStreamAlias("ArticleCount")
	List<String> articles = Lists.newArrayList();
	/**
	 * 图文消息标题
	 */
	@NotEmpty
	@XStreamAlias("Title")
	String title;
	/**
	 * 图文消息描述
	 */
	@NotEmpty
	@XStreamAlias("Description")
	String description;
	/**
	 * 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	 */
	@NotEmpty
	@XStreamAlias("PicUrl")
	String picUrl;
	/**
	 * 点击图文消息跳转链接
	 */
	@NotEmpty
	@XStreamAlias("Url")
	String url;
}

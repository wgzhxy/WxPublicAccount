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
public class MessageMusic extends Message {

	/**
	 * 音乐标题
	 */
	@XStreamAlias("Title")
	String title;
	/**
	 * 音乐描述
	 */
	@XStreamAlias("Description")
	String description;
	/**
	 * 音乐链接
	 */
	@XStreamAlias("MusicURL")
	String musicURL;
	/**
	 * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	 */
	@XStreamAlias("HQMusicUrl")
	String hQMusicUrl;
	/**
	 * 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
	 */
	@NotEmpty
	@XStreamAlias("ThumbMediaId")
	String thumbMediaId;
}

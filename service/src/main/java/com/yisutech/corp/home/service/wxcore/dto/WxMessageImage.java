package com.yisutech.corp.home.service.wxcore.dto;

import lombok.Data;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：WxMessageImage
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-18 下午11:50
 **/
@Data
public class WxMessageImage extends WxMessage {

    String picUrl;
    String mediaId;
    String msgId;
}

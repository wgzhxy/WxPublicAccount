package com.yisutech.corp.home.service.wxcore.dto;

import lombok.Data;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.service.wxcore.dto.WxMessageText
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-18 下午11:48
 **/
@Data
public class WxMessagelink extends WxMessage {

    String title;
    String description;
    String url;
    String msgId;

}

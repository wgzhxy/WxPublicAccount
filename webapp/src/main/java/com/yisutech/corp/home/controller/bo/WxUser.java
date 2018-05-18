package com.yisutech.corp.home.controller.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.controller.bo.WxUser
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-18 下午6:12
 **/
@Data
public class WxUser implements Serializable {
    private static final long serialVersionUID = -2415772632729888469L;
    String mobile;
    String name;
    String nick;
}

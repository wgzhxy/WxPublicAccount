package com.yisutech.corp.home.service.user;

import com.yisutech.corp.domain.repository.pojo.WxUser;
import com.yisutech.corp.home.service.wxcore.dto.WxUserInfo;
import com.yisutech.corp.home.tools.result.Result;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.service.user.UserSrv
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-19 下午12:14
 **/
public interface UserSrv {

    /**
     * 新用户注册
     *
     * @param code
     * @param mobile
     * @param state
     */
    Result<Boolean> userRegister(String code, String mobile, String state);

    /**
     * @param code
     * @return
     */
    WxUser getUserInfo(String code);

}

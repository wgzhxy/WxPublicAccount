package com.yisutech.corp.home.service.wxcore;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.service.wxcore.WxMenuSrv
 * 描述：
 * <p>
 * <p>
 * 微信公众号-菜单管理
 *
 * @author guangzhong.wgz
 * @create 2018-05-18 下午2:12
 **/
public interface WxMenuSrv {

    /**
     * 获取菜单
     *
     * @param token 访问token
     * @return
     */
    String getMenu(final String token);

    /**
     * 创建菜单
     *
     * @param menuJson
     * @return true, false
     */
    boolean createMenu(final String menuJson);

    /**
     * 删除菜单
     *
     * @return
     */
    boolean deleteMenu();


}

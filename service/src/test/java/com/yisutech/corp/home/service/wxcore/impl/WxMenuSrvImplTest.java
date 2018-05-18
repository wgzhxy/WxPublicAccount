package com.yisutech.corp.home.service.wxcore.impl;

import com.yisutech.corp.home.service.StarterApplication;
import com.yisutech.corp.home.service.wxcore.WxMenuSrv;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StarterApplication.class)
public class WxMenuSrvImplTest {

    @Resource
    private WxMenuSrv wxMenuSrv;

    @Test
    public void createMenu() throws Exception {
        String menuJson = "{\"button\":[{\"type\":\"view\",\"name\":\"企业简介\",\"url\":\"http://www.yisutech.com/corp/corpHome.html\"},{\"type\":\"view\",\"name\":\"积分商城\",\"key\":\"http://www.yisutech.com/jf/jfHome.html\"},{\"name\":\"会员\",\"sub_button\":[{\"type\":\"view\",\"name\":\"会员信息\",\"url\":\"http://www.yisutech.com/user/userInfo.html\"},{\"type\":\"view\",\"name\":\"绑定手机号\",\"key\":\"http://www.yisutech.com/user/register.html\"},{\"type\":\"click\",\"name\":\"我的商品\",\"key\":\"V1001_GOOD\"}]}]}";
        Assert.assertTrue(wxMenuSrv.createMenu(menuJson));

    }

    @Test
    public void getMenu() throws Exception {
        String menuStr = wxMenuSrv.getMenu("");
        Assert.assertNotNull(menuStr);
    }

    @Test
    public void deleteMenu() throws Exception {
        boolean status = wxMenuSrv.deleteMenu();
        Assert.assertTrue(status);
    }

}
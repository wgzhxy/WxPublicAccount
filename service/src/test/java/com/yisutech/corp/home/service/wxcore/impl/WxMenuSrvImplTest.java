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
        String menuJson = "{\"button\":[{\"type\":\"click\",\"name\":\"企业简介\",\"key\":\"V1001_TODAY_VIEW\"},{\"type\":\"click\",\"name\":\"今日歌曲\",\"key\":\"V1001_TODAY_MUSIC\"},{\"name\":\"菜单\",\"sub_button\":[{\"type\":\"view\",\"name\":\"搜索\",\"url\":\"http://www.soso.com/\"},{\"type\":\"miniprogram\",\"name\":\"wxa\",\"url\":\"http://mp.weixin.qq.com\",\"appid\":\"wx286b93c14bbf93aa\",\"pagepath\":\"pages/lunar/index\"},{\"type\":\"click\",\"name\":\"赞一下我们\",\"key\":\"V1001_GOOD\"}]}]}";
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
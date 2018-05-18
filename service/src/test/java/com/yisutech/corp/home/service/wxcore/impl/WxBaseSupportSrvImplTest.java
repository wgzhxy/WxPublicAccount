package com.yisutech.corp.home.service.wxcore.impl;

import com.yisutech.corp.home.service.StarterApplication;
import com.yisutech.corp.home.service.wxcore.WxBaseSupportSrv;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = StarterApplication.class)
public class WxBaseSupportSrvImplTest {

    @Resource
    private WxBaseSupportSrv wxBaseSupportSrv;

    @Test
    public void getAccessToken() throws Exception {
        String token = wxBaseSupportSrv.getAccessToken();
        Assert.assertNotNull(token);
    }

}
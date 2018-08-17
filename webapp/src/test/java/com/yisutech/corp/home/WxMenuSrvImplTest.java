package com.yisutech.corp.home;

import com.yisutech.corp.home.service.common.Config;
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
    private Config config;
    @Resource
    private WxMenuSrv wxMenuSrv;

    @Test
    public void createMenu() throws Exception {

        String testDomain = "localyisu.s1.natapp.cc";
        String onlineDomain = "www.yisutech.com";
        String domain = testDomain;


        String menuJson = "{\"button\":[{\"sub_button\":[{\"name\":\"时光贵州\",\"type\":\"view\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc4d8005e75ad417f&redirect_uri=http%3a%2f%2flocalyisu.s1.natapp.cc%2fuser%2fuserInfo.html&response_type=code&scope=snsapi_userinfo&state=123456#wechat_redirect\"},{\"name\":\"民族风情\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc4d8005e75ad417f&redirect_uri=http%3a%2f%2flocalyisu.s1.natapp.cc%2fuser%2fuserInfo.html&response_type=code&scope=snsapi_userinfo&state=123456#wechat_redirect\",\"type\":\"view\"},{\"type\":\"view\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc4d8005e75ad417f&redirect_uri=http%3a%2f%2flocalyisu.s1.natapp.cc%2fuser%2fuserInfo.html&response_type=code&scope=snsapi_userinfo&state=123456#wechat_redirect\",\"name\":\"美食文化\"},{\"type\":\"view\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc4d8005e75ad417f&redirect_uri=http%3a%2f%2flocalyisu.s1.natapp.cc%2fuser%2fuserInfo.html&response_type=code&scope=snsapi_userinfo&state=123456#wechat_redirect\",\"name\":\"立体贵州\"}],\"name\":\"立体贵州\"},{\"name\":\"社区动态\",\"sub_button\":[{\"name\":\"热点分享\",\"type\":\"view\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc4d8005e75ad417f&redirect_uri=http%3a%2f%2flocalyisu.s1.natapp.cc%2fuser%2fuserInfo.html&response_type=code&scope=snsapi_userinfo&state=123456#wechat_redirect\"},{\"name\":\"社区头条\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc4d8005e75ad417f&redirect_uri=http%3a%2f%2flocalyisu.s1.natapp.cc%2fuser%2fuserInfo.html&response_type=code&scope=snsapi_userinfo&state=123456#wechat_redirect\",\"type\":\"view\"}]},{\"name\":\"百宝箱\",\"sub_button\":[{\"name\":\"趣味笑话\",\"type\":\"view\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc4d8005e75ad417f&redirect_uri=http%3a%2f%2flocalyisu.s1.natapp.cc%2fuser%2fregister.html&response_type=code&scope=snsapi_userinfo&state=123456#wechat_redirect\"},{\"name\":\"育儿闹瞌\",\"type\":\"view\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc4d8005e75ad417f&redirect_uri=http%3a%2f%2flocalyisu.s1.natapp.cc%2fuser%2fuserInfo.html&response_type=code&scope=snsapi_userinfo&state=123456#wechat_redirect\"},{\"name\":\"轻松办事\",\"type\":\"view\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc4d8005e75ad417f&redirect_uri=http%3a%2f%2flocalyisu.s1.natapp.cc%2fuser%2fuserInfo.html&response_type=code&scope=snsapi_userinfo&state=123456#wechat_redirect\"},{\"name\":\"意见反馈\",\"type\":\"view\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc4d8005e75ad417f&redirect_uri=http%3a%2f%2flocalyisu.s1.natapp.cc%2fuser%2fregister.html&response_type=code&scope=snsapi_userinfo&state=123456#wechat_redirect\"}]}]}";
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
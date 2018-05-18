package com.yisutech.corp.home.controller;

import com.alibaba.fastjson.JSONObject;
import com.yisutech.corp.home.tools.SHA1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.controller.HomeController
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-17 下午12:25
 **/
@Controller
public class HomeController {


    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/parseToken")
    @ResponseBody
    public String parseToken(@RequestParam(required = false) String signature, @RequestParam(required = false) String timestamp,
                             @RequestParam(required = false) String nonce, @RequestParam(required = false) String echostr) {

        logger.info("acess parseToken, {}, {}, {}, {}, {}", signature, timestamp, nonce, echostr);

        if (StringUtils.isEmpty(signature) || StringUtils.isEmpty(timestamp) || StringUtils.isEmpty(nonce)) {
            return "params is error";
        }

        // 字典排序
        String token = "123456";
        String encrypt = "axcTaPHGMGDWLpCd1CldOQWdLDjL33RfXrU55rziAZ1";

        try {
            String sign = SHA1.getSHA1(token, timestamp, nonce, encrypt);
            if (sign.equals(signature)) {
                return echostr;

            } else {
                return "";

            }
        } catch (Throwable e) {
            logger.error("parseToken_error", e);
        }
        return "";
    }

    @RequestMapping("getToken")
    @ResponseBody
    public Object getToken() {
        JSONObject json = new JSONObject();
        json.put("token", UUID.randomUUID().toString());
        return json;
    }
}

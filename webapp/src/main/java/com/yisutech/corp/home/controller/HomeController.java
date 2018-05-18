package com.yisutech.corp.home.controller;

import com.alibaba.fastjson.JSONObject;
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

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping("/parseToken")
    @ResponseBody
    public Object parseToken(@RequestParam String token) {
        if (StringUtils.isEmpty(token)) {
            throw new RuntimeException("token is null");
        }

        JSONObject json = new JSONObject();
        if(token.equals("123456")) {
            json.put("ret", 0);
            json.put("success", true);
        } else {
            json.put("ret", -1);
            json.put("success", false);
        }
        return json;
    }

    @RequestMapping("getToken")
    @ResponseBody
    public Object getToken() {
        JSONObject json = new JSONObject();
        json.put("token", UUID.randomUUID().toString());
        return json;
    }
}

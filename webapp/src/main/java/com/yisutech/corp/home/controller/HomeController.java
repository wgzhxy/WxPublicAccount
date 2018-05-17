package com.yisutech.corp.home.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("getToken")
    @ResponseBody
    public Object getToken() {
        JSONObject json = new JSONObject();
        json.put("token", UUID.randomUUID().toString());
        return json;
    }
}

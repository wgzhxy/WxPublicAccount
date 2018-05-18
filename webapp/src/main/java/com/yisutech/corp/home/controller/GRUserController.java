package com.yisutech.corp.home.controller;

import com.yisutech.corp.home.controller.bo.WxUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.controller.GRUserController
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-18 下午5:20
 **/
@Controller
@RequestMapping("/user")
public class GRUserController {

    @RequestMapping("/register")
    public ModelAndView register(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/register");

        return modelAndView;
    }

    @RequestMapping("/userInfo")
    public ModelAndView userInfo(Model model) {

        model.addAttribute("user", "好孩子");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/userInfo");

        return modelAndView;
    }

    @RequestMapping("/saveUser")
    @ResponseBody
    public WxUser saveUser(Model model) {

        WxUser wxUser = new WxUser();
        return wxUser;
    }
}

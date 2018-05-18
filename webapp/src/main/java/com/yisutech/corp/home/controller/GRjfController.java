package com.yisutech.corp.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.controller.GRjfController
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-18 下午5:21
 **/
@Controller
@RequestMapping("/jf")
public class GRjfController {

    @RequestMapping("/jfHome")
    public ModelAndView jfHome(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/jfmall/jfHome");

        return modelAndView;
    }
}
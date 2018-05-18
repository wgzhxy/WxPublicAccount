package com.yisutech.corp.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.controller.GRhomeController
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-18 下午5:23
 **/
@Controller
@RequestMapping("/corp")
public class GRhomeController {

    @RequestMapping("/corpHome")
    public ModelAndView corpHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/corp/corpHome");
        return modelAndView;
    }
}

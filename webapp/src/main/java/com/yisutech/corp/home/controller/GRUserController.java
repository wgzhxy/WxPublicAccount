package com.yisutech.corp.home.controller;

import com.google.common.collect.Maps;
import com.yisutech.corp.domain.repository.pojo.WxUser;
import com.yisutech.corp.home.service.jfmall.JfMallSrv;
import com.yisutech.corp.home.service.jfmall.vo.MyExchangeRecord;
import com.yisutech.corp.home.service.user.UserSrv;
import com.yisutech.corp.home.service.wxcore.WxUserSrv;
import com.yisutech.corp.home.tools.result.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Resource
    private UserSrv userSrv;
    @Resource
    private WxUserSrv wxUserSrv;
    @Resource
    private JfMallSrv jfMallSrv;

    @RequestMapping("/register")
    public ModelAndView register(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/register");

        return modelAndView;
    }

    @RequestMapping("/myProducts")
    public ModelAndView myProducts(Model model,
                                   @RequestParam(required = false) String code,
                                   @RequestParam(required = false) String state) {

        List<MyExchangeRecord> myExchangeRecords = jfMallSrv.queryExchangeRecords(code, state);

        myExchangeRecords.forEach(myExchangeRecord -> {
            if (StringUtils.isBlank(myExchangeRecord.getPicUrl())) {
                myExchangeRecord.setPicUrl("/img/works/6.jpg");
            }
        });
        model.addAttribute("myRecords", myExchangeRecords);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/myProduct");

        return modelAndView;
    }

    @RequestMapping("/userInfo")
    public ModelAndView userInfo(Model model,
                                 @RequestParam(required = false) String code,
                                 @RequestParam(required = false) String state) {

        WxUser wxUser = userSrv.getUserInfo(code);
        if (wxUser == null) {
            wxUser = new WxUser();
        }
        Map<String, Object> respMap = Maps.newHashMap();
        respMap.putIfAbsent("name", wxUser.getName());
        respMap.putIfAbsent("nick", wxUser.getNick());
        respMap.putIfAbsent("mobile", wxUser.getMobile());
        respMap.putIfAbsent("address", wxUser.getAddress());
        respMap.putIfAbsent("score", wxUser.getScore());

        model.addAllAttributes(respMap);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/userInfo");

        return modelAndView;
    }

    @RequestMapping("/saveUser")
    @ResponseBody
    public Result<Boolean> saveUser(Model model,
                                    @RequestParam(required = false) String code,
                                    @RequestParam(required = false) String state,
                                    @RequestParam(required = false) String name,
                                    @RequestParam(required = false) String mobile,
                                    @RequestParam(required = false) String verifyCode,
                                    @RequestParam(required = false) String address) {
        if (StringUtils.isBlank(code)) {
            return new Result<>(false, "code_is_null", "页面没有授权");
        }
        if (!StringUtils.equals("123456", verifyCode)) {
            return new Result<>(false, "verifyCode_is_error", "验证码不正确");
        }
        if (StringUtils.isBlank(mobile)) {
            return new Result<>(false, "mobile_is_null", "手机号为空");
        }
        return userSrv.userRegister(name, mobile, address, verifyCode, code, state);
    }

    @RequestMapping("/verifyCode")
    @ResponseBody
    public Result<Boolean> verifyCode(Model model,
                                      @RequestParam(required = false) String code,
                                      @RequestParam(required = false) String mobile) {
        if (StringUtils.isBlank(code)) {
            return new Result<>(false, "code_is_null", "手户凭证不能为空");
        }
        if (StringUtils.isBlank(mobile)) {
            return new Result<>(false, "mobile_is_null", "手机号不能为空");
        }

        String randCode = String.valueOf(Math.random() * 10000).substring(0, 4);
        boolean status = userSrv.sendVerifyCode(mobile, randCode);
        if (status) {
            return new Result<>(true);
        } else {
            return new Result<>(false, "send_fail", "发送短信失败");
        }
    }
}

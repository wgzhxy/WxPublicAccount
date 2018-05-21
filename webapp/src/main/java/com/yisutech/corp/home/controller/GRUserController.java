package com.yisutech.corp.home.controller;

import com.yisutech.corp.domain.repository.pojo.WxUser;
import com.yisutech.corp.home.service.jfmall.JfMallSrv;
import com.yisutech.corp.home.service.jfmall.vo.MyExchangeRecord;
import com.yisutech.corp.home.service.user.UserSrv;
import com.yisutech.corp.home.service.wxcore.WxUserSrv;
import com.yisutech.corp.home.tools.result.Result;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

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

    private static Logger LOG = LoggerFactory.getLogger(GRUserController.class);

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
        if (wxUser != null) {
            model.addAttribute("wxUser", wxUser);
        }
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
        if (StringUtils.isBlank(verifyCode)) {
            return new Result<>(false, "verifyCode_is_error", "请输入正确的手机验证码");
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

        try {
            String randCode = String.valueOf(Math.random() * 10000).substring(0, 4);
            Result<Boolean> status = userSrv.sendVerifyCode(mobile, randCode);

            if (status != null && status.isSuccess()) {
                return new Result<>(true);

            } else {
                return new Result<>(false, status.getMsgCode(), status.getMsgInfo());
            }
        } catch (Throwable e) {
            LOG.error("verifyCode_error", e);
            return new Result<>(false, "system_error", "系统错误，联调管理员");
        }
    }

    @RequestMapping("/newUserAward")
    public ModelAndView newUserAward(Model model,
                                     @RequestParam(required = false) String code,
                                     @RequestParam(required = false) String state) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/newUserAward");
        return modelAndView;
    }
}

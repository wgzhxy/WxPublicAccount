package com.yisutech.corp.home.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yisutech.corp.domain.repository.pojo.WxUser;
import com.yisutech.corp.home.service.jfmall.JfMallSrv;
import com.yisutech.corp.home.service.jfmall.vo.MyExchangeRecord;
import com.yisutech.corp.home.service.user.UserSrv;
import com.yisutech.corp.home.tools.DateUtil;
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
    private JfMallSrv jfMallSrv;

    private static Logger LOG = LoggerFactory.getLogger(GRUserController.class);

    @RequestMapping("/register")
    public ModelAndView register(@RequestParam(required = false) String code,
                                 @RequestParam(required = false) String state) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/register");

        WxUser wxUser = userSrv.getUserInfo(code);
        modelAndView.addObject("wxUser", wxUser);

        return modelAndView;
    }

    @RequestMapping("/myProducts")
    public ModelAndView myProducts(Model model,
                                   @RequestParam(required = false) String token,
                                   @RequestParam(required = false) String code,
                                   @RequestParam(required = false) String state) {

        List<MyExchangeRecord> myExchangeRecords = jfMallSrv.queryExchangeRecords(code, state);

        myExchangeRecords.forEach(myExchangeRecord -> {
            if (StringUtils.isBlank(myExchangeRecord.getPicUrl())) {
                myExchangeRecord.setPicUrl("/img/works/6.jpg");
            }
            if (DateUtil.getHours(myExchangeRecord.getGmtCreate()) > 11) {
                myExchangeRecord.setExpressTime(DateUtil.getNextDay(myExchangeRecord.getGmtCreate()));
            } else {
                myExchangeRecord.setExpressTime(myExchangeRecord.getGmtCreate());
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
    public ModelAndView saveUser(@RequestParam(required = false) String code,
                                 @RequestParam(required = false) String state) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/registerResult");

        String[] params = state.split("@");
        JSONObject jsonParams = JSONObject.parseObject(params[1]);

        String name = jsonParams.getString("name");
        String mobile = jsonParams.getString("mobile");
        String verifyCode = jsonParams.getString("verifyCode");
        String address = jsonParams.getString("address");
        String usherId = jsonParams.getString("usherId");

        if (StringUtils.isBlank(code)) {
            modelAndView.addObject("messageInfo", "页面没有授权");
            return modelAndView;
        }
        if (StringUtils.isBlank(verifyCode)) {
            modelAndView.addObject("messageInfo", "请输入正确的手机验证码");
            return modelAndView;
        }
        if (StringUtils.isBlank(mobile)) {
            modelAndView.addObject("messageInfo", "手机号为空");
            return modelAndView;
        }
        try {
            LOG.info("userSrv|{}", userSrv);
            LOG.info("info|{}|{}|{}|{}|{}|{}|{}", name, mobile, address, verifyCode, usherId, code, params[0]);
            Result<Boolean> result = userSrv.userRegister(name, mobile, address, verifyCode, usherId, code, params[0]);
            if (result != null && result.isSuccess()) {
                modelAndView.addObject("messageInfo", result.getMsgInfo());
                modelAndView.addObject("result", "0");
                return modelAndView;

            } else {
                modelAndView.addObject("messageInfo", result.getMsgInfo());
                return modelAndView;
            }
        } catch (Throwable e) {
            LOG.error("saveUser|{}|{}|{}", code, state, jsonParams);
            throw new RuntimeException(e);
        }
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

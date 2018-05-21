package com.yisutech.corp.home.controller;

import com.yisutech.corp.domain.repository.pojo.WxExchangeProduct;
import com.yisutech.corp.home.service.jfmall.JfMallSrv;
import com.yisutech.corp.home.tools.result.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private JfMallSrv jfMallSrv;

    @RequestMapping("/jfHome")
    public ModelAndView jfHome(Model model) {

        List<WxExchangeProduct> products = jfMallSrv.queryExchangeProducts();

        if (products == null || products.size() == 0) {
            for (int i = 0; i < 5; i++) {
                WxExchangeProduct wxExchangeProduct = new WxExchangeProduct();
                wxExchangeProduct.setId(i + 1);
                wxExchangeProduct.setTitle("大米, 灵芝，牛奶" + i);
                wxExchangeProduct.setDescription("优质的大米，美丽的灵芝，营养的牛奶，看看显示的儿果是怎么样的" + i);
                wxExchangeProduct.setNeedScore(i * 10);
                products.add(wxExchangeProduct);
            }
        }

        model.addAttribute("productList", products);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/jfmall/jfHome");

        return modelAndView;
    }

    @RequestMapping("/jfExchange")
    public ModelAndView jfExchange(Model model, String code, String state, String prodId) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/jfmall/jfExchange");

        // 参数检查
        if (StringUtils.isBlank(code)) {
            model.addAttribute("message", "用户凭证失效，请重试");
            return modelAndView;
        }
        if (StringUtils.isBlank(state)) {
            model.addAttribute("message", "兑换商品不存在");
            return modelAndView;
        }

        // 积分况换商品
        prodId = state.split("@")[1];
        Result<Boolean> result = jfMallSrv.exchange(code, state, Long.parseLong(prodId));
        if (result.isSuccess()) {
            model.addAttribute("message", "恭喜您，积分兑换商品成功！");

        } else {
            model.addAttribute("message", "抱歉，积分兑换商品失败, " + result.getMsgInfo());
        }

        return modelAndView;
    }
}

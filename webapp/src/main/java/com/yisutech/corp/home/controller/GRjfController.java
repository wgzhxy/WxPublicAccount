package com.yisutech.corp.home.controller;

import com.yisutech.corp.domain.repository.pojo.WxExchangeProduct;
import com.yisutech.corp.home.service.jfmall.JfMallSrv;
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
}

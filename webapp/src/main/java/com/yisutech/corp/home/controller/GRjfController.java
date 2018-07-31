package com.yisutech.corp.home.controller;

import com.alibaba.fastjson.JSONObject;
import com.yisutech.corp.domain.repository.pojo.WxExchangeProduct;
import com.yisutech.corp.home.service.jfmall.JfMallSrv;
import com.yisutech.corp.home.service.user.UserSrv;
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
	@Resource
	private UserSrv userSrv;

	@RequestMapping("/jfHome")
	public ModelAndView jfHome(Model model) {

		List<WxExchangeProduct> products = jfMallSrv.queryExchangeProducts();
		model.addAttribute("productList", products);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/jfmall/jfHome");

		return modelAndView;
	}

	@RequestMapping("/jfDetail")
	public ModelAndView jfDetail(Model model, @RequestParam Integer id) {

		WxExchangeProduct product = jfMallSrv.getExchangeProduct(id);
		model.addAttribute("product", product);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/jfmall/jfProductDetail");

		return modelAndView;
	}

	@RequestMapping("/jfExchange")
	public ModelAndView jfExchange(@RequestParam String state, @RequestParam String code) {

		Integer id = 0;
		if (StringUtils.isBlank(state)) {
			id = Integer.parseInt(state.split("@")[1]);
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("p", jfMallSrv.getExchangeProduct(id));
		modelAndView.addObject("user", userSrv.getUserInfo(code));

		modelAndView.setViewName("/jfmall/jfExchange");
		return modelAndView;
	}

	@RequestMapping("/exchange")
	@ResponseBody
	public Result<Boolean> exchange(@RequestParam String code, @RequestParam String state, @RequestParam String prodId) {

		// 参数检查
		if (StringUtils.isBlank(code)) {
			return new Result<>(false, "code_expire", "用户凭证失效，请重试");
		}
		if (StringUtils.isBlank(state)) {
			return new Result<>(false, "product_not_exists", "兑换商品不存在");
		}

		// 积分况换商品
		prodId = state.split("@")[1];
		Result<Boolean> result = jfMallSrv.exchange(code, state, Long.parseLong(prodId));
		if (result.isSuccess()) {
			return new Result<>(true, "", "恭喜您，积分兑换商品成功！");

		} else {
			return new Result<>(false, "", "抱歉，积分兑换商品失败");
		}
	}
}

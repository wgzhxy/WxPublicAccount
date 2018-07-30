package com.yisutech.corp.home.controller;

import com.yisutech.corp.home.service.resource.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

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

	@Resource
	private ResourceService resourceService;

	private static Logger LOG = LoggerFactory.getLogger(GRhomeController.class);

	@RequestMapping("/corpHome")
	public ModelAndView corpHome() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.addObject("corpInfomation", resourceService.getCorpInfomation());
		} catch (Throwable e) {
			LOG.info("corpHome_error", e);
		}
		modelAndView.setViewName("/corp/corpHome");
		return modelAndView;
	}
}

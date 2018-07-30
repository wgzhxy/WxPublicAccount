package com.yisutech.corp.home.controller;

import com.yisutech.corp.home.service.resource.ResourceService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 版权：Copyright by www.yisutech.com
 * 项目：WxPublicAccount
 * 文件名：com.yisutech.corp.home.controller.InfoController
 * 描述：
 * InfoController
 *
 * @author guangzhong.wgz@yisutech.com
 * @version 1.0
 * @create 2018-07-31 00:30
 **/
@Controller
@RequestMapping("/wx/common")
public class CommonController {

	@Resource
	private ResourceService resourceService;

	private static Logger LOG = LoggerFactory.getLogger(CommonController.class);

	@RequestMapping(value = "/information", method = RequestMethod.GET)
	public ModelAndView information(@RequestParam String appCode, @RequestParam String rsCode) {

		ModelAndView modelAndView = new ModelAndView();
		try {
			if (StringUtils.isNotBlank(appCode) || StringUtils.isNotBlank(rsCode)) {
				modelAndView.addObject("information", resourceService.getCorpInformation());
			}
		} catch (Throwable e) {
			LOG.info("corpHome_error", e);
		}
		modelAndView.setViewName("/comm/infomation");
		return modelAndView;
	}

}

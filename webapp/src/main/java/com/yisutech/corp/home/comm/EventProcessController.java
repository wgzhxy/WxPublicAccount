package com.yisutech.corp.home.comm;

import com.alibaba.fastjson.JSONObject;
import com.yisutech.corp.home.service.common.Constants;
import com.yisutech.corp.home.service.wx_event.MessageProcessor;
import com.yisutech.corp.home.tools.SHA1;
import org.apache.commons.codec.Charsets;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.UUID;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.controller.HomeController
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-17 下午12:25
 **/
@Controller
public class EventProcessController {

	@Resource
	private MessageProcessor messageProcessor;

	private Logger logger = LoggerFactory.getLogger(EventProcessController.class);

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping("/parseToken")
	@ResponseBody
	public String parseToken(HttpServletRequest req, HttpServletResponse resp,
	                         @RequestParam(required = false) String signature,
	                         @RequestParam(required = false) String timestamp,
	                         @RequestParam(required = false) String nonce,
	                         @RequestParam(required = false) String echostr) {

		logger.info("acess parseToken, {}, {}, {}, {}", signature, timestamp, nonce, echostr);
		if (StringUtils.isEmpty(signature) || StringUtils.isEmpty(timestamp) || StringUtils.isEmpty(nonce)) {
			return "params is error";
		}

		try {
			InputStream inputStream = req.getInputStream();
			if (inputStream != null) {
				byte[] data = IOUtils.toByteArray(inputStream);
				String xmlStr = new String(data, Charsets.UTF_8);
				logger.info(xmlStr);
			}

		} catch (Throwable e) {
			logger.error("parseToken_error", e);
		}

		// 字典排序
		String token = "123456";
		String encrypt = "axcTaPHGMGDWLpCd1CldOQWdLDjL33RfXrU55rziAZ1";

		try {
			String sign = SHA1.getSHA1(token, timestamp, nonce, encrypt);
			if (sign.equals(signature)) {
				return echostr;

			} else {
				return echostr;

			}
		} catch (Throwable e) {
			logger.error("parseToken_error", e);
		}
		return "";
	}

	@RequestMapping("/hh/parseToken")
	public void huhuParseToken(HttpServletRequest req, HttpServletResponse resp,
	                           @RequestParam(required = false) String signature,
	                           @RequestParam(required = false) String timestamp,
	                           @RequestParam(required = false) String nonce,
	                           @RequestParam(required = false) String echostr) {

		logger.info("acess hh_parseToken, {}, {}, {}, {}", signature, timestamp, nonce, echostr);
		if (StringUtils.isEmpty(signature) || StringUtils.isEmpty(timestamp) || StringUtils.isEmpty(nonce)) {
			logger.error("params is error");
		}

		try {
			String reply = "";
			InputStream inputStream = req.getInputStream();

			if (StringUtils.isEmpty(echostr) && inputStream != null) {
				byte[] data = IOUtils.toByteArray(inputStream);
				String xmlStr = new String(data, Charsets.UTF_8);

				logger.info("请求xml: {}", xmlStr);

				reply = messageProcessor.process(req, resp, xmlStr);

			} else {
				// 字典排序
				String token = "yisutech_huhu";
				String encrypt = "axcTaPHGMGDWLpCd1CldOQWdLDjL33RfXrU55rziAZ1";

				try {
					String sign = SHA1.getSHA1(token, timestamp, nonce, encrypt);
					if (sign.equals(signature)) {
						reply = echostr;
					}
				} catch (Throwable e) {
					logger.error("parseToken_error", e);
				}
			}
			/*
			reply = "<xml><ToUserName><![CDATA[o4aIM1OAI_cPBcMXPFJe0_H5mdo0]]></ToUserName>\n" +
					"<FromUserName><![CDATA[gh_9cfa7c2f764a]]></FromUserName>\n" +
					"<CreateTime>1534418672</CreateTime>\n" +
					"<MsgType><![CDATA[text]]></MsgType>\n" +
					"<Content><![CDATA[｡◕‿◕｡]]></Content>\n" +
					"<MsgId>6590278015093353430</MsgId>\n" +
					"</xml>";
			*/
			resp.setCharacterEncoding(Constants.CHARSET_UTF_8);
			resp.getOutputStream().write(reply.getBytes(Constants.CHARSET_UTF_8));
			resp.flushBuffer();

		} catch (Throwable e) {
			logger.error("parseToken_error", e);
		}
	}

	@RequestMapping("getToken")
	@ResponseBody
	public Object getToken() {
		JSONObject json = new JSONObject();
		json.put("token", UUID.randomUUID().toString());
		return json;
	}
}

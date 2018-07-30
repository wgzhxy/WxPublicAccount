package com.yisutech.corp.home.service.resource;

/**
 * 版权：Copyright by www.yisutech.com
 * 项目：WxPublicAccount
 * 文件名：com.yisutech.corp.home.service.resource.ResourceService
 * 描述：
 * ResourceService
 *
 * @author guangzhong.wgz@yisutech.com
 * @version 1.0
 * @create 2018-07-31 00:04
 **/
public interface ResourceService {

	/**
	 * 获取公司简介
	 *
	 * @return
	 */
	String getCorpInformation();

	/**
	 * 获取公司简介
	 *
	 * @return
	 */
	String getInformation(String appCode, String rsCode);
}

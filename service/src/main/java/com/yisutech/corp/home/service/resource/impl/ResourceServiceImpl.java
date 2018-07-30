package com.yisutech.corp.home.service.resource.impl;

import com.yisutech.corp.domain.repository.mapper.WxResourceMapper;
import com.yisutech.corp.domain.repository.pojo.WxResource;
import com.yisutech.corp.domain.repository.pojo.WxResourceExample;
import com.yisutech.corp.home.service.resource.ResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 版权：Copyright by www.yisutech.com
 * 项目：WxPublicAccount
 * 文件名：com.yisutech.corp.home.service.resource.impl.ResourceServiceImpl
 * 描述：
 * ResourceServiceImpl
 *
 * @author guangzhong.wgz@yisutech.com
 * @version 1.0
 * @create 2018-07-31 00:05
 **/
@Service
public class ResourceServiceImpl implements ResourceService {

	@Resource
	private WxResourceMapper wxResourceMapper;

	@Override
	public String getCorpInfomation() {

		WxResourceExample example = new WxResourceExample();
		example.createCriteria().andAppCodeEqualTo("guirenquan")
				.andRsCodeEqualTo("CORP_INFO");
		List<WxResource> wxResources = wxResourceMapper.selectByExampleWithBLOBs(example);

		return wxResources != null && wxResources.size() > 0 ? wxResources.get(0).getContent() : "";
	}
}

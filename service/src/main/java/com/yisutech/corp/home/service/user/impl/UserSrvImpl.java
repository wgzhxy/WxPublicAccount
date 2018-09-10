package com.yisutech.corp.home.service.user.impl;

import com.google.common.collect.Maps;
import com.yisutech.corp.domain.repository.mapper.WxUserMapper;
import com.yisutech.corp.domain.repository.mapper.WxVefifyCodeMapper;
import com.yisutech.corp.domain.repository.pojo.WxUser;
import com.yisutech.corp.domain.repository.pojo.WxUserExample;
import com.yisutech.corp.domain.repository.pojo.WxVefifyCode;
import com.yisutech.corp.domain.repository.pojo.WxVefifyCodeExample;
import com.yisutech.corp.home.service.common.Config;
import com.yisutech.corp.home.service.user.UserSrv;
import com.yisutech.corp.home.service.wxcore.WxUserSrv;
import com.yisutech.corp.home.service.wxcore.dto.WxUserInfo;
import com.yisutech.corp.home.third_party.sms.SendMessageSrv;
import com.yisutech.corp.home.tools.DateUtil;
import com.yisutech.corp.home.tools.result.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.service.user.impl.UserSrvImpl
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-19 下午12:14
 **/
@Service
public class UserSrvImpl implements UserSrv {

	@Resource
	private Config config;
	@Resource
	private WxUserSrv wxUserSrv;
	@Resource
	private WxUserMapper wxUserMapper;
	@Resource
	private SendMessageSrv sendMessageSrv;
	@Resource
	private WxVefifyCodeMapper wxVefifyCodeMapper;

	@Override
	public Result<Boolean> userRegister(String name, String mobile, String address, String verifyCode, String usherId,
	                                    String code, String state) {
		// 手机号
		if (!config.WxOpenState.equals(state)) {
			return new Result<>(false, "params_error", "state is error");
		}

		// 验证码是否有效
		Date currentDate = Calendar.getInstance().getTime();

		WxVefifyCodeExample verifExample = new WxVefifyCodeExample();
		verifExample.setOrderByClause(" id desc");
		verifExample.createCriteria().andAppIdEqualTo(config.WxAppId)
				.andMobleEqualTo(mobile)
				.andValidTimeStampLessThanOrEqualTo(currentDate)
				.andExpireTimeStampGreaterThanOrEqualTo(currentDate);

		List<WxVefifyCode> wxVefifyCodes = wxVefifyCodeMapper.selectByExample(verifExample);
		if (wxVefifyCodes == null || wxVefifyCodes.size() == 0) {
			return new Result<>(false, "mobile_code_error", "手机验证码错误");
		}

		if (!wxVefifyCodes.get(0).getVefifyCode().equals(verifyCode)) {
			return new Result<>(false, "mobile_code_error", "手机验证码错误");
		}

		// 获取accessToken, refreshToken
		WxUserInfo wxUserInfo = wxUserSrv.getOauth2Token(code, state);
		if (wxUserInfo == null || StringUtils.isBlank(wxUserInfo.getOpenId())) {
			return new Result<>(false, "getOauth2Token", "凭证失效");
		}

		// 获取微信用户信息
		String lang = "zh_CN";
		WxUserInfo userDetailInfo = wxUserSrv.getUserInfo(wxUserInfo.getAccessToken(), config.WxAppId, lang);

		// 手机号是否已经注册
		WxUserExample example = new WxUserExample();
		example.createCriteria().andOpenIdEqualTo(userDetailInfo.getOpenId());
		List<WxUser> wxUsers = wxUserMapper.selectByExample(example);

		Result result = new Result<>();
		// 保存用户信息
		WxUser wxUser;
		if (wxUsers != null && wxUsers.size() > 0) { // 更新用户信息
			wxUser = wxUsers.get(0);
			wxUser.setAvartorUrl(userDetailInfo.getHeadImgUrl());
			wxUser.setOpenId(userDetailInfo.getOpenId());
			wxUser.setUnionId(userDetailInfo.getUnionId());
			wxUser.setMobile(mobile);
			wxUser.setAddress(address);
			wxUser.setName(name);
			wxUser.setUsherId(usherId);
			wxUser.setNick(userDetailInfo.getNickname());
			wxUser.setGmtModify(DateUtil.getNowTime());

			int update = wxUserMapper.updateByPrimaryKey(wxUser);

			if (update > 0) {
				result.setModel(true);
				result.setMsgInfo("用户信息更新成功");
				return result;

			} else {
				return new Result<>(false, "update_fail", "用户信息更新失败，请再重试");
			}


		} else { // 写入用户信息
			wxUser = new WxUser();
			wxUser.setUnionId(userDetailInfo.getUnionId());
			wxUser.setOpenId(userDetailInfo.getOpenId());
			wxUser.setMobile(mobile);
			wxUser.setAvartorUrl(userDetailInfo.getHeadImgUrl());
			wxUser.setApp(config.WxAppId);
			wxUser.setSecurity(config.WxAppSecret);
			wxUser.setNick(userDetailInfo.getNickname());
			wxUser.setCity(userDetailInfo.getCity());
			wxUser.setAddress(address);
			wxUser.setName(name);
			wxUser.setUsherId(usherId);
			wxUser.setProvince(userDetailInfo.getProvince());
			wxUser.setCountry(userDetailInfo.getCountry());
			wxUser.setSex(userDetailInfo.getSex());
			wxUser.setScore(0);
			wxUser.setGmtModify(DateUtil.getNowTime());
			wxUser.setGmtCreate(DateUtil.getNowTime());

			int update = wxUserMapper.insert(wxUser);

			if (update > 0) {
				result.setModel(true);
				result.setMsgInfo("用户注册成功");
				return result;

			} else {
				return new Result<>(false, "update_fail", "用户注册失败，请再重试");
			}
		}
	}

	@Override
	public WxUser getUserInfo(String code) {

		if (StringUtils.isBlank(code)) {
			return null;
		}
		// 获取accessToken, refreshToken
		WxUserInfo wxUserInfo = wxUserSrv.getOauth2Token(code, config.WxOpenState);
		if (wxUserInfo == null || StringUtils.isBlank(wxUserInfo.getOpenId())) {
			return null;
		}

		// 查询用户信息
		WxUserExample example = new WxUserExample();
		example.createCriteria().andOpenIdEqualTo(wxUserInfo.getOpenId());
		List<WxUser> wxUsers = wxUserMapper.selectByExample(example);

		if (wxUsers == null || wxUsers.size() == 0) {
			return null;
		}

		// 对象转换
		return wxUsers.get(0);
	}

	@Override
	public Result<Boolean> sendVerifyCode(String mobile, String code) {

		String outId = "";
		String mobiles = mobile;
		String corpTag = config.mobile_sign_name;
		String templateCode = config.mobile_tmeplateCode;

		Map<String, Object> params = Maps.newHashMap();

		// 验证码是否已经过期
		Date currentDate = Calendar.getInstance().getTime();

		WxVefifyCodeExample verifExample = new WxVefifyCodeExample();
		verifExample.setOrderByClause(" id desc");

		verifExample.createCriteria().andAppIdEqualTo(config.WxAppId)
				.andMobleEqualTo(mobile)
				.andValidTimeStampLessThanOrEqualTo(currentDate)
				.andExpireTimeStampGreaterThanOrEqualTo(currentDate);
		List<WxVefifyCode> wxVefifyCodes = wxVefifyCodeMapper.selectByExample(verifExample);

		if (wxVefifyCodes != null && wxVefifyCodes.size() > 0) {
			code = wxVefifyCodes.get(0).getVefifyCode();
		}

		params.putIfAbsent("code", code);
		Result<Boolean> send = sendMessageSrv.sendSms(corpTag, mobiles, templateCode, params, outId);

		if (send != null && send.isSuccess()) {

			WxVefifyCode wxVefifyCode = new WxVefifyCode();
			wxVefifyCode.setAppId(config.WxAppId);
			wxVefifyCode.setGmtCreate(DateUtil.getNowTime());
			wxVefifyCode.setGmtModify(DateUtil.getNowTime());
			wxVefifyCode.setMoble(mobile);
			wxVefifyCode.setVefifyCode(code);
			wxVefifyCode.setValidTimeStamp(Calendar.getInstance().getTime());
			wxVefifyCode.setExpireTimeStamp(new Date(System.currentTimeMillis() + 300000));

			int update = wxVefifyCodeMapper.insert(wxVefifyCode);
			if (update > 0) {
				return new Result<>(true);

			}
		}
		String msgInfo = "";
		if(StringUtils.isNotBlank(send.getMsgInfo())) {
			msgInfo = send.getMsgInfo();
		}
		return new Result<>(false, send.getMsgCode(), msgInfo);
	}
}

package com.yisutech.corp.home.third_party.sms;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.yisutech.corp.home.tools.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.third_party.sms.SendMessageSrv
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-19 上午11:06
 **/
@Service
public class SendMessageSrv {

    private static String ACCESS_KEY_ID = "x3iyjYdy0OKvjb8h";
    private static String ACCESS_KEY_SECRET = "gnXtyuxXfYKnlz6fX5A9bFnlSXKNGz";
    private static Logger LOG = LoggerFactory.getLogger("sendMessageLog");

    /**
     * 短信发送
     *
     * @param corpTag      短信中应用所属名
     * @param mobiles      手机号，批量以逗号分隔
     * @param templateCode 短信模板
     * @param params       短信模板中替换变量
     * @param outId        outId为提供给业务方扩展字段，最终在短信回执消息中将此值带回给调用者
     * @return
     */
    public Result<Boolean> sendSms(String corpTag, String mobiles, String templateCode, Map<String, Object> params, String outId) {

        // 参数检查
        if (StringUtils.isEmpty(mobiles)) {
            return new Result<>(false, "mobiles_error", "mobiles is empty");
        }
        if (StringUtils.isEmpty(templateCode)) {
            return new Result<>(false, "templateCode_error", "templateCode is empty");
        }
        if (params == null || params.size() == 0) {
            return new Result<>(false, "params_error", "params is empty");
        }

        //设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化ascClient需要的几个参数
        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）

        //替换成你的AK
        final String accessKeyId = ACCESS_KEY_ID;//你的accessKeyId,参考本文档步骤2
        final String accessKeySecret = ACCESS_KEY_SECRET;//你的accessKeySecret，参考本文档步骤2

        //初始化ascClient,暂时不支持多region（请勿修改）
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
            IAcsClient acsClient = new DefaultAcsClient(profile);

            //组装请求对象
            SendSmsRequest request = new SendSmsRequest();

            //使用post提交
            request.setMethod(MethodType.POST);

            // 必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,
            // 批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；
            // 发送国际/港澳台消息时，接收号码格式为00+国际区号+号码，如“0085200000000”
            request.setPhoneNumbers(mobiles);

            //必填:短信签名-可在短信控制台中找到
            request.setSignName(corpTag);

            //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode(templateCode);

            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
            request.setTemplateParam(JSON.toJSONString(params));

            //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
            //request.setSmsUpExtendCode("90997");

            //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
            request.setOutId(outId);

            //请求失败这里会抛ClientException异常
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            LOG.info("sendMessage : {}", JSON.toJSONString(sendSmsResponse));
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                return new Result<>(true);

            } else {
                return new Result<>(false, sendSmsResponse.getCode(), sendSmsResponse.getMessage());
            }
        } catch (Throwable e) {
            LOG.error("sendSms_error", e);
            return new Result<>(false, "system_error", "系统错误，联调管理员");
        }
    }
}

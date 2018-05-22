package com.yisutech.corp.home.controller;

import com.yisutech.corp.home.service.common.Config;
import com.yisutech.corp.home.service.wxcore.WxUserSrv;
import com.yisutech.corp.home.service.wxcore.dto.WxUserInfo;
import com.yisutech.corp.home.tools.HttpUtils;
import com.yisutech.corp.home.tools.MD5Util;
import com.yisutech.corp.home.tools.XmlParseUtils;
import com.yisutech.corp.home.tools.pay.RequestHandler;
import org.apache.commons.codec.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.controller.WxPayController
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-22 上午11:58
 **/
@Controller
@RequestMapping("/suport/wx")
public class WxPayController {

    @Resource
    private Config config;
    @Resource
    private WxUserSrv wxUserSrv;

    private static Logger LOG = LoggerFactory.getLogger(WxPayController.class);

    /**
     * 用户提交支付，获取微信支付订单接口
     */
    @RequestMapping(value = "/pay")
    public ModelAndView pay(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mv = new ModelAndView();
        String GZHID = "wxc91633dd26821ab6";// 微信公众号id
        String GZHSecret = "a7564a772a9639fdcc6163a6e113c42e";// 微信公众号密钥id

        String SHHID = "1433540502";// 财付通商户号
        String SHHKEY = "mmmmmmmmmmmmmmm";// 商户号对应的密钥

        /*------1.获取参数信息------- */
        //商户订单号
        String out_trade_no = request.getParameter("state");
        //价格
        String finalmoney = "800";
        //获取用户的code
        String code = request.getParameter("code");

        /*------2.根据code获取微信用户的openId和access_token------- */
        //注： 如果后台程序之前已经得到了用户的openId 可以不需要这一步，直接从存放openId的位置或session中获取就可以。
        //toPay.jsp页面中提交的url路径也就不需要再经过微信重定向。写成：http://localhost:8080/项目名/wechat/pay?money=${sumPrice}&state=${orderId}
        WxUserInfo wxUserInfo = wxUserSrv.getOauth2Token(code, "");
        if (wxUserInfo == null || StringUtils.isBlank(wxUserInfo.getOpenId())) {
            mv.addObject("errorMsg", "用户微信凭证失效");
            mv.setViewName("/user/error");
            return mv;
        }
        String openid = wxUserInfo.getOpenId();

        /*------3.生成预支付订单需要的的package数据------- */
        //随机数
        String nonce_str = MD5Util.MD5Encode(String.valueOf(new Random().nextInt(10000)), "utf-8");

        //订单生成的机器 IP
        String spbill_create_ip = request.getRemoteAddr();

        //交易类型 ：jsapi代表微信公众号支付
        String trade_type = "JSAPI";

        //这里notify_url是 微信处理完支付后的回调的应用系统接口url。
        String notify_url = "http://yisutech.s1.natapp.cc/suport/wx/wxNotify.html";

        SortedMap<String, String> packageParams = new TreeMap<String, String>();
        String title = "8元邮寄费，送72元灵芝";
        packageParams.put("appid", GZHID);
        packageParams.put("mch_id", SHHID);
        packageParams.put("nonce_str", nonce_str);
        packageParams.put("body", title);
        packageParams.put("out_trade_no", out_trade_no);
        packageParams.put("total_fee", finalmoney);
        packageParams.put("spbill_create_ip", spbill_create_ip);
        packageParams.put("notify_url", notify_url);
        packageParams.put("trade_type", trade_type);
        packageParams.put("openid", openid);

        /*------4.根据package数据生成预支付订单号的签名sign------- */
        RequestHandler reqHandler = new RequestHandler();
        reqHandler.init(GZHID, GZHSecret, SHHKEY);
        String sign = reqHandler.createSign(packageParams);

        /*------5.生成需要提交给统一支付接口https://api.mch.weixin.qq.com/pay/unifiedorder 的xml数据-------*/
        String xml = "<xml>" +
                "<appid>" + GZHID + "</appid>" +
                "<mch_id>" + SHHID + "</mch_id>" +
                "<nonce_str>" + nonce_str + "</nonce_str>" +
                "<sign>" + sign + "</sign>" +
                "<body><![CDATA[" + title + "]]></body>" +
                "<out_trade_no>" + out_trade_no + "</out_trade_no>" +
                "<total_fee>" + finalmoney + "</total_fee>" +
                "<spbill_create_ip>" + spbill_create_ip + "</spbill_create_ip>" +
                "<notify_url>" + notify_url + "</notify_url>" +
                "<trade_type>" + trade_type + "</trade_type>" +
                "<openid>" + openid + "</openid>" +
                "</xml>";

        /*------6.调用统一支付接口https://api.mch.weixin.qq.com/pay/unifiedorder 生产预支付订单----------*/
        String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        String prepay_id = "";
        try {
            String orderXml = HttpUtils.postReq(createOrderURL, xml, ContentType.APPLICATION_XML, Charsets.UTF_8);
            Map<String, Object> orderObj = XmlParseUtils.parseXmlToMap(orderXml);

            if (orderObj.get("prepay_id") == null || StringUtils.isBlank(orderObj.get("prepay_id").toString())) {
                mv.addObject("errorMsg", "微信预订单失败, " + String.valueOf(orderObj.get("return_msg")));
                mv.setViewName("/user/error");
                return mv;
            }
        } catch (Exception e) {
            LOG.error("统一支付接口获取预支付订单出错", e);
            mv.addObject("errorMsg", e.getMessage());
            mv.setViewName("/user/error");
            return mv;
        }
        /*将prepay_id存到库中*/
        /*PageData p = new PageData();
        p.put("shopId", out_trade_no);
        p.put("prePayId", prepay_id);
        activityService.updatePrePayId(p);*/


        /*------7.将预支付订单的id和其他信息生成签名并一起返回到jsp页面 ------- */
        nonce_str = MD5Util.MD5Encode(String.valueOf(new Random().nextInt(10000)), "utf-8");

        SortedMap<String, String> finalpackage = new TreeMap<>();
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        String packages = "prepay_id=" + prepay_id;
        finalpackage.put("appId", GZHID);
        finalpackage.put("timeStamp", timestamp);
        finalpackage.put("nonceStr", nonce_str);
        finalpackage.put("package", packages);
        finalpackage.put("signType", "MD5");
        String finalsign = reqHandler.createSign(finalpackage);

        mv.addObject("appid", GZHID);
        mv.addObject("timeStamp", timestamp);
        mv.addObject("nonceStr", nonce_str);
        mv.addObject("packageValue", packages);
        mv.addObject("paySign", finalsign);
        mv.addObject("success", "ok");
        mv.setViewName("/user/pay");

        return mv;
    }


    /**
     * 提交支付后的微信异步返回接口
     */
    @RequestMapping(value = "/wxNotify")
    public void weixinNotify(HttpServletRequest request, HttpServletResponse response) {
        String out_trade_no = null;
        String return_code = null;
        try {
            InputStream inStream = request.getInputStream();
            String resultStr = new String(IOUtils.toByteArray(inStream), "utf-8");

            LOG.info("支付成功的回调：" + resultStr);

            Map<String, Object> resultMap = XmlParseUtils.parseXmlToMap(resultStr);
            String result_code = (String) resultMap.get("result_code");
            String is_subscribe = (String) resultMap.get("is_subscribe");
            String transaction_id = (String) resultMap.get("transaction_id");
            String sign = (String) resultMap.get("sign");
            String time_end = (String) resultMap.get("time_end");
            String bank_type = (String) resultMap.get("bank_type");

            out_trade_no = (String) resultMap.get("out_trade_no");
            return_code = (String) resultMap.get("return_code");

            request.setAttribute("out_trade_no", out_trade_no);

            //通知微信.异步确认成功.必写.不然微信会一直通知后台.八次之后就认为交易失败了.
            response.getWriter().write(RequestHandler.setXML("SUCCESS", ""));
        } catch (Exception e) {
            LOG.error("微信回调接口出现错误：", e);
            try {
                response.getWriter().write(RequestHandler.setXML("FAIL", "error"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (return_code.equals("SUCCESS")) {
            //支付成功的业务逻辑, 变更支付定单逻辑

        } else {
            //支付失败的业务逻辑

        }
    }

}

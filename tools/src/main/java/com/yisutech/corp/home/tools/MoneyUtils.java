package com.yisutech.corp.home.tools;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.tools.MoneyUtils
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-22 下午12:48
 **/
public class MoneyUtils {

    /**
     * 元转换成分
     *
     * @return
     */
    public static String getMoney(String amount) {
        if (amount == null) {
            return "";
        }
        // 金额转化为分为单位
        String currency = amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ￥ 或者$的金额
        int index = currency.indexOf(".");
        int length = currency.length();
        Long amLong = 0l;
        if (index == -1) {
            amLong = Long.valueOf(currency + "00");
        } else if (length - index >= 3) {
            amLong = Long.valueOf((currency.substring(0, index + 3)).replace(".", ""));
        } else if (length - index == 2) {
            amLong = Long.valueOf((currency.substring(0, index + 2)).replace(".", "") + 0);
        } else {
            amLong = Long.valueOf((currency.substring(0, index + 1)).replace(".", "") + "00");
        }
        return amLong.toString();
    }
}

package com.yisutech.corp.home.service.pay;

import com.yisutech.corp.domain.repository.pojo.WxOrder;
import com.yisutech.corp.home.service.common.Constants;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.service.pay.OrderSrv
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-22 下午9:20
 **/
public interface OrderSrv {

    /**
     * 保存订定
     *
     * @param wxOrder
     * @return
     */
    WxOrder saveOrder(WxOrder wxOrder);

    /**
     * 完成订定
     *
     * @return
     */
    WxOrder payOrder(String outTradeNo, String bankType, String transactionId, Constants.OrderSts orderSts);
}

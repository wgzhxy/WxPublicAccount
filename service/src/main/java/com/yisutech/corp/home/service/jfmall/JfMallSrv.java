package com.yisutech.corp.home.service.jfmall;

import com.yisutech.corp.domain.repository.pojo.WxExchangeProduct;
import com.yisutech.corp.home.service.jfmall.vo.MyExchangeRecord;
import com.yisutech.corp.home.tools.result.Result;

import java.util.List;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.service.jfmall.JfMallSrv
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-19 下午1:19
 **/
public interface JfMallSrv {

	/**
	 * 积分兑换商品
	 *
	 * @param code 用户凭证
	 * @return
	 */
	Result<Boolean> exchange(String code, String state, Long prodId);

	/**
	 * 查询积分商城兑换商品
	 *
	 * @return List<WxExchangeProduct>
	 */
	List<WxExchangeProduct> queryExchangeProducts();

	/**
	 * 查询积分商城兑换商品
	 *
	 * @return List<WxExchangeProduct>
	 */
	List<MyExchangeRecord> queryExchangeRecords(String code, String state);

	/**
	 * 积分商城产品更新
	 *
	 * @param wxExchangeProduct
	 * @return
	 */
	boolean saveExchangeProduct(WxExchangeProduct wxExchangeProduct);

	/**
	 * 积分商城商品详情
	 *
	 * @param productId 商品ID
	 * @return
	 */
	WxExchangeProduct getExchangeProduct(Integer productId);
}

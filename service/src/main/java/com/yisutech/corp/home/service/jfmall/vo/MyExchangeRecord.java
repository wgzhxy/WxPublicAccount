package com.yisutech.corp.home.service.jfmall.vo;

import com.yisutech.corp.domain.repository.pojo.WxExchangeRecord;
import lombok.Data;

import java.io.Serializable;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.service.jfmall.vo.MyExchangeRecord
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-21 上午11:29
 **/
@Data
public class MyExchangeRecord extends WxExchangeRecord implements Serializable {
    String title;
    String description;
}

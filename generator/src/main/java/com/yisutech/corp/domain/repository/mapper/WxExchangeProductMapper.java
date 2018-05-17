package com.yisutech.corp.domain.repository.mapper;

import com.yisutech.corp.domain.repository.pojo.WxExchangeProduct;
import com.yisutech.corp.domain.repository.pojo.WxExchangeProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxExchangeProductMapper {
    long countByExample(WxExchangeProductExample example);

    int deleteByExample(WxExchangeProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxExchangeProduct record);

    int insertSelective(WxExchangeProduct record);

    List<WxExchangeProduct> selectByExample(WxExchangeProductExample example);

    WxExchangeProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxExchangeProduct record, @Param("example") WxExchangeProductExample example);

    int updateByExample(@Param("record") WxExchangeProduct record, @Param("example") WxExchangeProductExample example);

    int updateByPrimaryKeySelective(WxExchangeProduct record);

    int updateByPrimaryKey(WxExchangeProduct record);
}
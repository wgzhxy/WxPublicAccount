package com.yisutech.corp.domain.repository.mapper;

import com.yisutech.corp.domain.repository.pojo.WxOrder;
import com.yisutech.corp.domain.repository.pojo.WxOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxOrderMapper {
    long countByExample(WxOrderExample example);

    int deleteByExample(WxOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxOrder record);

    int insertSelective(WxOrder record);

    List<WxOrder> selectByExample(WxOrderExample example);

    WxOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxOrder record, @Param("example") WxOrderExample example);

    int updateByExample(@Param("record") WxOrder record, @Param("example") WxOrderExample example);

    int updateByPrimaryKeySelective(WxOrder record);

    int updateByPrimaryKey(WxOrder record);
}
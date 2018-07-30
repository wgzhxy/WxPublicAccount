package com.yisutech.corp.domain.repository.mapper;

import com.yisutech.corp.domain.repository.pojo.WxResource;
import com.yisutech.corp.domain.repository.pojo.WxResourceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxResourceMapper {
    long countByExample(WxResourceExample example);

    int deleteByExample(WxResourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxResource record);

    int insertSelective(WxResource record);

    List<WxResource> selectByExampleWithBLOBs(WxResourceExample example);

    List<WxResource> selectByExample(WxResourceExample example);

    WxResource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxResource record, @Param("example") WxResourceExample example);

    int updateByExampleWithBLOBs(@Param("record") WxResource record, @Param("example") WxResourceExample example);

    int updateByExample(@Param("record") WxResource record, @Param("example") WxResourceExample example);

    int updateByPrimaryKeySelective(WxResource record);

    int updateByPrimaryKeyWithBLOBs(WxResource record);

    int updateByPrimaryKey(WxResource record);
}
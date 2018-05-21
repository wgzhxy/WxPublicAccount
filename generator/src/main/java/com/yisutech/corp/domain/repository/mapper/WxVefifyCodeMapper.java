package com.yisutech.corp.domain.repository.mapper;

import com.yisutech.corp.domain.repository.pojo.WxVefifyCode;
import com.yisutech.corp.domain.repository.pojo.WxVefifyCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxVefifyCodeMapper {
    long countByExample(WxVefifyCodeExample example);

    int deleteByExample(WxVefifyCodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxVefifyCode record);

    int insertSelective(WxVefifyCode record);

    List<WxVefifyCode> selectByExample(WxVefifyCodeExample example);

    WxVefifyCode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxVefifyCode record, @Param("example") WxVefifyCodeExample example);

    int updateByExample(@Param("record") WxVefifyCode record, @Param("example") WxVefifyCodeExample example);

    int updateByPrimaryKeySelective(WxVefifyCode record);

    int updateByPrimaryKey(WxVefifyCode record);
}
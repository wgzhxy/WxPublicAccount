package com.yisutech.corp.domain.repository.mapper;

import com.yisutech.corp.domain.repository.pojo.WxBuyRecord;
import com.yisutech.corp.domain.repository.pojo.WxBuyRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxBuyRecordMapper {
    long countByExample(WxBuyRecordExample example);

    int deleteByExample(WxBuyRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxBuyRecord record);

    int insertSelective(WxBuyRecord record);

    List<WxBuyRecord> selectByExample(WxBuyRecordExample example);

    WxBuyRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxBuyRecord record, @Param("example") WxBuyRecordExample example);

    int updateByExample(@Param("record") WxBuyRecord record, @Param("example") WxBuyRecordExample example);

    int updateByPrimaryKeySelective(WxBuyRecord record);

    int updateByPrimaryKey(WxBuyRecord record);
}
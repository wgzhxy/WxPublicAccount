package com.yisutech.corp.domain.repository.mapper;

import com.yisutech.corp.domain.repository.pojo.WxExchangeRecord;
import com.yisutech.corp.domain.repository.pojo.WxExchangeRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxExchangeRecordMapper {
    long countByExample(WxExchangeRecordExample example);

    int deleteByExample(WxExchangeRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxExchangeRecord record);

    int insertSelective(WxExchangeRecord record);

    List<WxExchangeRecord> selectByExample(WxExchangeRecordExample example);

    WxExchangeRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxExchangeRecord record, @Param("example") WxExchangeRecordExample example);

    int updateByExample(@Param("record") WxExchangeRecord record, @Param("example") WxExchangeRecordExample example);

    int updateByPrimaryKeySelective(WxExchangeRecord record);

    int updateByPrimaryKey(WxExchangeRecord record);
}
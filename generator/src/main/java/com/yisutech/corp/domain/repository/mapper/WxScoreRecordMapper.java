package com.yisutech.corp.domain.repository.mapper;

import com.yisutech.corp.domain.repository.pojo.WxScoreRecord;
import com.yisutech.corp.domain.repository.pojo.WxScoreRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxScoreRecordMapper {
    long countByExample(WxScoreRecordExample example);

    int deleteByExample(WxScoreRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxScoreRecord record);

    int insertSelective(WxScoreRecord record);

    List<WxScoreRecord> selectByExample(WxScoreRecordExample example);

    WxScoreRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxScoreRecord record, @Param("example") WxScoreRecordExample example);

    int updateByExample(@Param("record") WxScoreRecord record, @Param("example") WxScoreRecordExample example);

    int updateByPrimaryKeySelective(WxScoreRecord record);

    int updateByPrimaryKey(WxScoreRecord record);
}
package com.schoolTao.mapper;

import com.schoolTao.model.TReply;
import com.schoolTao.model.TReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TReplyMapper {
    int countByExample(TReplyExample example);

    int deleteByExample(TReplyExample example);

    int insert(TReply record);

    int insertSelective(TReply record);

    List<TReply> selectByExample(TReplyExample example);

    int updateByExampleSelective(@Param("record") TReply record, @Param("example") TReplyExample example);

    int updateByExample(@Param("record") TReply record, @Param("example") TReplyExample example);
}
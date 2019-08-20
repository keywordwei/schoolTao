package com.schoolTao.mapper;

import com.schoolTao.model.TStu;
import com.schoolTao.model.TStuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TStuMapper {
    int countByExample(TStuExample example);

    int deleteByExample(TStuExample example);

    int deleteByPrimaryKey(Integer stuId);

    int insert(TStu record);

    int insertSelective(TStu record);

    List<TStu> selectByExample(TStuExample example);

    TStu selectByPrimaryKey(Integer stuId);

    int updateByExampleSelective(@Param("record") TStu record, @Param("example") TStuExample example);

    int updateByExample(@Param("record") TStu record, @Param("example") TStuExample example);

    int updateByPrimaryKeySelective(TStu record);

    int updateByPrimaryKey(TStu record);
}
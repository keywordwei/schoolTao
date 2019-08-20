package com.schoolTao.mapper;

import com.schoolTao.model.TSaleGoods;
import com.schoolTao.model.TSaleGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSaleGoodsMapper {
    int countByExample(TSaleGoodsExample example);

    int deleteByExample(TSaleGoodsExample example);

    int deleteByPrimaryKey(Integer goodsId);

    int insert(TSaleGoods record);

    int insertSelective(TSaleGoods record);

    List<TSaleGoods> selectByExample(TSaleGoodsExample example);

    TSaleGoods selectByPrimaryKey(Integer goodsId);

    int updateByExampleSelective(@Param("record") TSaleGoods record, @Param("example") TSaleGoodsExample example);

    int updateByExample(@Param("record") TSaleGoods record, @Param("example") TSaleGoodsExample example);

    int updateByPrimaryKeySelective(TSaleGoods record);

    int updateByPrimaryKey(TSaleGoods record);
}
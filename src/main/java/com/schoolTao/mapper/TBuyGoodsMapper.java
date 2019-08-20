package com.schoolTao.mapper;

import com.schoolTao.model.TBuyGoods;
import com.schoolTao.model.TBuyGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBuyGoodsMapper {
    int countByExample(TBuyGoodsExample example);

    int deleteByExample(TBuyGoodsExample example);

    int deleteByPrimaryKey(Integer productId);

    int insert(TBuyGoods record);

    int insertSelective(TBuyGoods record);

    List<TBuyGoods> selectByExample(TBuyGoodsExample example);

    TBuyGoods selectByPrimaryKey(Integer productId);

    int updateByExampleSelective(@Param("record") TBuyGoods record, @Param("example") TBuyGoodsExample example);

    int updateByExample(@Param("record") TBuyGoods record, @Param("example") TBuyGoodsExample example);

    int updateByPrimaryKeySelective(TBuyGoods record);

    int updateByPrimaryKey(TBuyGoods record);
}
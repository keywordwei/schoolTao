package com.schoolTao.mapper;

import com.schoolTao.model.TCollection;
import com.schoolTao.model.TCollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCollectionMapper {
    int countByExample(TCollectionExample example);

    int deleteByExample(TCollectionExample example);

    int deleteByPrimaryKey(Integer collectionId);

    int insert(TCollection record);

    int insertSelective(TCollection record);

    List<TCollection> selectByExample(TCollectionExample example);

    TCollection selectByPrimaryKey(Integer collectionId);

    int updateByExampleSelective(@Param("record") TCollection record, @Param("example") TCollectionExample example);

    int updateByExample(@Param("record") TCollection record, @Param("example") TCollectionExample example);

    int updateByPrimaryKeySelective(TCollection record);

    int updateByPrimaryKey(TCollection record);
}
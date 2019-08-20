package com.schoolTao.service.impl;

import com.schoolTao.mapper.MyMapperSty;
import com.schoolTao.mapper.TSaleGoodsMapper;
import com.schoolTao.model.TSaleGoods;
import com.schoolTao.service.StySaleGoodService;
import com.schoolTao.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class StySaleGoodServiceImpl implements StySaleGoodService {
    @Override
    public List<Map<String, Object>> findAllSaleGoods(String likeStr) {
        SqlSession session = MybatisUtil.getSqlSession();
        MyMapperSty goodsMapper = session.getMapper(MyMapperSty.class);
        List<Map<String,Object>> goods = goodsMapper.findAllSaleGoods(likeStr);
        session.close();
        return goods;
    }

    //保存发布的二手商品
    @Override
    public void save(TSaleGoods tSaleGoods) {
        SqlSession  sqlSession = MybatisUtil.getSqlSession();
        TSaleGoodsMapper mapper = sqlSession.getMapper(TSaleGoodsMapper.class);
        mapper.insert(tSaleGoods);
        sqlSession.commit();
        sqlSession.close();
    }
}

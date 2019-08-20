package com.schoolTao.service.impl;

import com.schoolTao.mapper.MyMapperSty;
import com.schoolTao.service.SGoodsService;
import com.schoolTao.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class SGoodsServiceImpl implements SGoodsService {

    /***
     * 多表查询,查Buygoods
     * @param likeStr
     * @return
     */
    @Override
    public List<Map<String, Object>> findAllBuyGoods(String likeStr) {
        SqlSession session = MybatisUtil.getSqlSession();

        System.out.println("service into");
        List<Map<String,Object>> goods = null;
        try {
            MyMapperSty goodsMapper = session.getMapper(MyMapperSty.class);
            goods = goodsMapper.findAllBuyGoods(likeStr);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return goods;
    }
}

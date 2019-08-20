package com.schoolTao.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.schoolTao.mapper.GoodsMapper;
import com.schoolTao.mapper.TBuyGoodsMapper;
import com.schoolTao.mapper.TSaleGoodsMapper;
import com.schoolTao.model.TBuyGoods;
import com.schoolTao.model.TSaleGoods;
import com.schoolTao.model.TSaleGoodsExample;
import com.schoolTao.service.IGoodsService;
import com.schoolTao.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class GoodsServiceImpl implements IGoodsService {
    private SqlSession sqlSession;
    private Integer pageSize = 10;
    private String imgs;

    @Override
    public PageInfo<Map<String,Object>> findSaleGoodsByCategoryId(Integer category_id, String order,Integer pageNum) {
        sqlSession = MybatisUtil.getSqlSession();
        PageInfo<Map<String,Object>> pageInfo = null;
        try{
            GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
            PageHelper.startPage(pageNum,pageSize);
            List<Map<String,Object>> mapList = mapper.selectSaleGoodsAndUserByCategoryId(category_id,order);
            System.out.println(mapList.toString());
            for(int i=0; i<mapList.size();i++){
                //imgs = mapList.get(i).get("goods_img").toString().split("#");
                imgs = (String) mapList.get(i).get("goods_img");
                mapList.get(i).put("goods_img",imgs.split("#"));
            }
            pageInfo = new PageInfo<>(mapList);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return pageInfo;
    }

    @Override
    public Map<String,Object> findSaleAndUserGoodsById(Integer goods_id) {
        sqlSession = MybatisUtil.getSqlSession();
        Map<String,Object> salegoodsMap = null;
        try{
            GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
            salegoodsMap = mapper.selectSaleGoodsAndUserByGoodsId(goods_id);
            //imgs = mapList.get(i).get("goods_img").toString().split("#");
            imgs = (String) salegoodsMap.get("goods_img");
            salegoodsMap.put("goods_img",imgs.split("#"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return salegoodsMap;
    }

    @Override
    public TSaleGoods findSaleGoodsById(Integer goods_id) {
        sqlSession = MybatisUtil.getSqlSession();
        TSaleGoods tSaleGoods = null;
        try{
            TSaleGoodsMapper mapper = sqlSession.getMapper(TSaleGoodsMapper.class);
            tSaleGoods = mapper.selectByPrimaryKey(goods_id);//按主键查询
            tSaleGoods.setGoodsImg(tSaleGoods.getGoodsImg().split("#")[0]);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return tSaleGoods;
    }


    @Override
    public int updateSaleGoods(TSaleGoods tSaleGoods) {
        sqlSession = MybatisUtil.getSqlSession();
        int res = 0;
        try{
            TSaleGoodsMapper mapper = sqlSession.getMapper(TSaleGoodsMapper.class);
            res = mapper.updateByPrimaryKeySelective(tSaleGoods);//按主键更新
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return res;
    }

    @Override
    public List<Map<String, Object>> findSaleGoodsByUserId(Integer user_id) {
        sqlSession = MybatisUtil.getSqlSession();
        List<Map<String,Object>> mapList = null;
        try{
            GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
            mapList = mapper.selectSaleGoodsByUserId(user_id);
            for(int i=0; i<mapList.size();i++){
                //imgs = mapList.get(i).get("goods_img").toString().split("#");
                imgs = (String) mapList.get(i).get("goods_img");
                mapList.get(i).put("goods_img",imgs.split("#"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return mapList;
    }

    @Override
    public List<TSaleGoods> findRecommend() {
        sqlSession = MybatisUtil.getSqlSession();
        List<TSaleGoods> tSaleGoods = null;
        try{
            TSaleGoodsMapper mapper = sqlSession.getMapper(TSaleGoodsMapper.class);
            TSaleGoodsExample example = new TSaleGoodsExample();
            example.setOrderByClause("goods_hot DESC");//按热度排序
            PageHelper.startPage(1,5);
            tSaleGoods = mapper.selectByExample(example);
            for(int i=0; i<tSaleGoods.size();i++){
                tSaleGoods.get(i).setGoodsImg(tSaleGoods.get(i).getGoodsImg().split("#")[0]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return tSaleGoods;
    }




    @Override
    public PageInfo<Map<String,Object>> findBuyGoodsByCategoryId(Integer category_id, String order, Integer pageNum) {
        sqlSession = MybatisUtil.getSqlSession();
        PageInfo<Map<String,Object>> pageInfo= null;
        try{
            GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
            PageHelper.startPage(pageNum,pageSize);
            List<Map<String,Object>> mapList = mapper.selectBuyGoodsAndUserByCategoruId(category_id,order);
            pageInfo = new PageInfo<>(mapList);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return pageInfo;
    }

//    @Override
//    public Map<String,Object> findBuyGoodsAndUserById(Integer product_id) {
//        sqlSession = MybatisUtil.getSqlSession();
//        Map<String,Object> buygoodsMap = null;
//        try{
//            GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
//            buygoodsMap = mapper.selectBuyGoodsAndUserByProductId(product_id);
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            sqlSession.close();
//        }
//        return buygoodsMap;
//    }

    @Override
    public TBuyGoods findBuyGoodsById(Integer product_id) {
        sqlSession = MybatisUtil.getSqlSession();
        TBuyGoods tBuyGoods = null;
        try{
            TBuyGoodsMapper mapper = sqlSession.getMapper(TBuyGoodsMapper.class);
            tBuyGoods = mapper.selectByPrimaryKey(product_id);//按主键查询
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return tBuyGoods;
    }



    @Override
    public int updateBuyGoods(TBuyGoods tBuyGoods) {
        sqlSession = MybatisUtil.getSqlSession();
        int res = 0;
        try{
            TBuyGoodsMapper mapper = sqlSession.getMapper(TBuyGoodsMapper.class);
            res = mapper.updateByPrimaryKeySelective(tBuyGoods);//按主键更新
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return res;
    }

    @Override
    public List<Map<String, Object>> findBuyGoodsByUserId(Integer user_id) {
        sqlSession = MybatisUtil.getSqlSession();
        List<Map<String,Object>> mapList= null;
        try{
            GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
            mapList = mapper.selectBuyGoodsByUserId(user_id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return mapList;
    }

    @Override
    //保存求购商品
    public void save(TBuyGoods tBuyGoods) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TBuyGoodsMapper mapper = sqlSession.getMapper(TBuyGoodsMapper.class);
        mapper.insert(tBuyGoods);
        sqlSession.commit();
        sqlSession.close();
    }
}

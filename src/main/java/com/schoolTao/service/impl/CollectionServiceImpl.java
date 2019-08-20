package com.schoolTao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.schoolTao.mapper.GoodsMapper;
import com.schoolTao.mapper.TCollectionMapper;
import com.schoolTao.model.TCollection;
import com.schoolTao.model.TCollectionExample;
import com.schoolTao.service.ICollectionService;
import com.schoolTao.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class CollectionServiceImpl implements ICollectionService {
    private SqlSession sqlSession;
    private Integer pageSize = 10;
    private String imgs;
    @Override
    public int addSaleGoodsToCollection(TCollection tCollection) {
        int res = 0;
        try{
            if(!isCollectionExist(tCollection)) {
                sqlSession = MybatisUtil.getSqlSession();
                TCollectionMapper mapper = sqlSession.getMapper(TCollectionMapper.class);
                res = mapper.insertSelective(tCollection);//加入收藏
                sqlSession.commit();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return res;
    }

    @Override
    public Boolean isCollectionExist(TCollection tCollection) {
        sqlSession = MybatisUtil.getSqlSession();
        int res = 0;
        try{
            TCollectionMapper mapper = sqlSession.getMapper(TCollectionMapper.class);
            TCollectionExample example = new TCollectionExample();
            TCollectionExample.Criteria criteria = example.createCriteria();
            criteria.andCollectionUserIdEqualTo(tCollection.getCollectionUserId());
            criteria.andCollectionGoodsIdEqualTo(tCollection.getCollectionGoodsId());
            res = mapper.countByExample(example);
            if(res!=0){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return false;
    }

    @Override
    public List<Map<String,Object>> findSaleGoodsCollection(Integer user_id) {
        sqlSession = MybatisUtil.getSqlSession();
        List<Map<String,Object>> collectios = null;
        try{
            GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
            collectios = mapper.selectSaleGoodsCollection(user_id);
            for(int i=0; i<collectios.size();i++){
                //imgs = mapList.get(i).get("goods_img").toString().split("#");
                imgs = (String) collectios.get(i).get("goods_img");
                collectios.get(i).put("goods_img",imgs.split("#"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return collectios;
    }

    @Override
    public int deleteCollection(Integer collection_id) {
        int res = 0;
        try{
            sqlSession = MybatisUtil.getSqlSession();
            TCollectionMapper mapper = sqlSession.getMapper(TCollectionMapper.class);
            TCollection tCollection = mapper.selectByPrimaryKey(collection_id);
            if(tCollection!=null){
                tCollection.setCollectionStatus(0);
                res = mapper.updateByPrimaryKeySelective(tCollection);//删除收藏
            }
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return res;
    }
}

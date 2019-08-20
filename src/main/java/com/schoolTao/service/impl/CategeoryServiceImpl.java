package com.schoolTao.service.impl;

import com.schoolTao.mapper.TCategoryMapper;
import com.schoolTao.model.TCategory;
import com.schoolTao.model.TCategoryExample;
import com.schoolTao.service.ICategeoryService;
import com.schoolTao.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CategeoryServiceImpl implements ICategeoryService {
    private SqlSession sqlSession;
    @Override
    public List<TCategory> findAllCategory() {
        sqlSession = MybatisUtil.getSqlSession();
        List<TCategory> categeories = null;
        try {
            TCategoryMapper mapper = sqlSession.getMapper(TCategoryMapper.class);
            categeories = mapper.selectByExample(null);
            //   System.out.println(categeories);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return categeories;

    }
    @Override
    public TCategory findCategoryByname(String goods_categeory_name) {
        sqlSession = MybatisUtil.getSqlSession();
        TCategoryMapper mapper = sqlSession.getMapper(TCategoryMapper.class);
        TCategoryExample tCategoryExample = new TCategoryExample();
        TCategoryExample.Criteria criteria = tCategoryExample.createCriteria();
        criteria.andCategoryNameEqualTo(goods_categeory_name);
        List<TCategory> list =  mapper.selectByExample(tCategoryExample);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }
}

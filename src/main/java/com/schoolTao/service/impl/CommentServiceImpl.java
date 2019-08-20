package com.schoolTao.service.impl;


import com.schoolTao.mapper.TCommentMapper;
import com.schoolTao.model.TComment;
import com.schoolTao.model.TCommentExample;
import com.schoolTao.service.CommentService;
import com.schoolTao.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    private SqlSession session = MybatisUtil.getSqlSession();


    /***
     * 插入评论
     * @param comment
     * @return
     */
    @Override
    public int insertComment(TComment comment) {
        TCommentMapper tCommentMapper = session.getMapper(TCommentMapper.class);
        int rows = tCommentMapper.insert(comment);
        session.commit();
        session.close();
        return rows;
    }



    /****
     * 查找所有评论
     * @param goodsId
     * @return
     */
    @Override
    public List<TComment> findAllComment(String goodsId) {
        /*需要商品id*/
        TCommentMapper tCommentMapper = session.getMapper(TCommentMapper.class);
        TCommentExample tCommentExample = new TCommentExample();
        TCommentExample.Criteria criteria = tCommentExample.createCriteria();
        criteria.andProductIdEqualTo(Integer.valueOf(goodsId));
        List<TComment> commentList = tCommentMapper.selectByExample(tCommentExample);

        System.out.println("commentList:"+commentList);

        return commentList;
    }
}

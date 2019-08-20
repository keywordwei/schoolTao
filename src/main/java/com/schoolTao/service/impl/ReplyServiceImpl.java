package com.schoolTao.service.impl;

import com.schoolTao.mapper.TReplyMapper;
import com.schoolTao.model.TReply;
import com.schoolTao.model.TReplyExample;
import com.schoolTao.service.ReplyService;
import com.schoolTao.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ReplyServiceImpl implements ReplyService {


    @Override
    public int insertReply(TReply tReply) {
        SqlSession session = MybatisUtil.getSqlSession();
        TReplyMapper replyMapper = session.getMapper(TReplyMapper.class);
        int rows = replyMapper.insert(tReply);
        session.commit();
        session.close();
        return rows;
    }


    /****
     * 查找所有评论的回复
     * @param commentID
     * @return
     */
    @Override
    public List<TReply> findAllReply(Integer commentID) {
        /**
         * 需要获取评论的id*/
        SqlSession session = MybatisUtil.getSqlSession();
        TReplyMapper tReplyMapper = session.getMapper(TReplyMapper.class);
        TReplyExample tReplyExample = new TReplyExample();
        TReplyExample.Criteria criteria = tReplyExample.createCriteria();
        criteria.andReplyIdEqualTo(Integer.valueOf(Integer.valueOf(commentID)));
        List<TReply> replies = tReplyMapper.selectByExample(tReplyExample);

        System.out.println(replies);
        return null;
    }
}

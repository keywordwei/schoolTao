package com.schoolTao.service;


import com.schoolTao.model.TReply;

import java.util.List;

public interface ReplyService {

    /**
     * 插入回复信息（id与评论的id相同，可以根据id找到所有评论）
     * @param tReply
     * @return
     */
    public int insertReply( TReply tReply);



    /****
     * 查找所有评论的回复
     * @param commentID
     * @return
     */
    public List<TReply> findAllReply(Integer commentID);
}

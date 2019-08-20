package com.schoolTao.service;


import com.schoolTao.model.TComment;

import java.util.List;

public interface CommentService {

    /***
     * 插入评论
     * @param comment
     * @return
     */
    public int insertComment(TComment comment);


    /****
     * 查找所有评论
     * @param goodsId
     * @return
     */
    public List<TComment> findAllComment(String goodsId);


}

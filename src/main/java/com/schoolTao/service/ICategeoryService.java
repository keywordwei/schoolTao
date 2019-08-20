package com.schoolTao.service;

import com.schoolTao.model.TCategory;

import java.util.List;

public interface ICategeoryService {

    /**
     * 查找所有分类信息
     * @return
     */
    List<TCategory> findAllCategory();


    TCategory findCategoryByname(String goods_categeory_name);
}

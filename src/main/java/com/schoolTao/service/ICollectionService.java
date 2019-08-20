package com.schoolTao.service;

import com.github.pagehelper.PageInfo;
import com.schoolTao.model.TCollection;

import java.util.List;
import java.util.Map;

public interface ICollectionService {

    /**
     * 加入收藏
     * @param tCollection
     * @return
     */
    int addSaleGoodsToCollection(TCollection tCollection);


    /**
     * 查询数据库是否存在此收藏
     * @param tCollection
     * @return
     */
    Boolean isCollectionExist(TCollection tCollection);



    /**
     * 查询收藏
     * @param user_id
     * @return
     */
    List<Map<String,Object>> findSaleGoodsCollection(Integer user_id);


    /**
     * 取消收藏
     * @param collection_id
     * @return
     */
    int deleteCollection(Integer collection_id);

}

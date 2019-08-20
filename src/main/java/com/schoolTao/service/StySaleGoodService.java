package com.schoolTao.service;

import com.schoolTao.model.TSaleGoods;

import java.util.List;
import java.util.Map;

public interface StySaleGoodService {
    /***
     * 多表查询,查Salegoods
     * @return
     */
     public List<Map<String,Object>> findAllSaleGoods(String likestr);


     void save(TSaleGoods tSaleGoods);

}

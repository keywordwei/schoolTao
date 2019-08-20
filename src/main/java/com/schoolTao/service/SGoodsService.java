package com.schoolTao.service;

import java.util.List;
import java.util.Map;

public interface SGoodsService {

    /***
     * 多表查询,查Buygoods
     * @param likeStr
     * @return
     */
    public List<Map<String,Object>> findAllBuyGoods(String likeStr);
}

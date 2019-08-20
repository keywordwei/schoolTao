package com.schoolTao.service;

import com.github.pagehelper.PageInfo;
import com.schoolTao.model.TBuyGoods;
import com.schoolTao.model.TSaleGoods;

import java.util.List;
import java.util.Map;

public interface IGoodsService {

    /*************求购信息的接口*******/
    /**
     *按分类查询求购
     * @param category_id
     * @return
     */
    PageInfo<Map<String,Object>> findBuyGoodsByCategoryId(Integer category_id, String order, Integer pageNum);



    /**
     * 根据id查询求购信息
     * @param product_id
     * @return
     */
//    Map<String,Object> findBuyGoodsAndUserById(Integer product_id);

    /**
     * 根据id查询求购
     * @param product_id
     * @return
     */
    TBuyGoods findBuyGoodsById(Integer product_id);

    /**
     * 修改求购信息
     * @param tBuyGoods
     * @return
     */
    int updateBuyGoods(TBuyGoods tBuyGoods);

    /**
     * 根据用户id查询所有的求购并降序排列
     * @param user_id
     * @return
     */
    List<Map<String,Object>> findBuyGoodsByUserId(Integer user_id);



    /*************二手商品的接口*******/

    /**
     *按分类查询二手
     * @param category_id
     * @return
     */
    PageInfo<Map<String,Object>> findSaleGoodsByCategoryId(Integer category_id, String order, Integer pageNum);


    /**
     * 根据id查询二手商品和用户信息
     * @param goods_id
     * @return
     */
    Map<String,Object> findSaleAndUserGoodsById(Integer goods_id);

    /**
     * 根据id查询二手商品
     * @param goods_id
     * @return
     */
    TSaleGoods findSaleGoodsById(Integer goods_id);

    /**
     * 修改二手商品
     * @param tSaleGoods
     * @return
     */
    int updateSaleGoods(TSaleGoods tSaleGoods);

    /**
     * 根据用户id查询所有的二手商品并降序排列
     * @param user_id
     * @return
     */
    List<Map<String,Object>> findSaleGoodsByUserId(Integer user_id);

    /**
     * 详情页的推荐
     * @return
     */
    List<TSaleGoods> findRecommend();


    /**
     * 添加求购上商品
     * @param tBuyGoods
     */
    void save(TBuyGoods tBuyGoods);

}

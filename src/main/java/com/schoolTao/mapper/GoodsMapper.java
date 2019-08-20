package com.schoolTao.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {


    /**
     * 根据分类查询二手和对应用户信息
     * @param category_id
     * @param order
     * @return
     */
    @Select("select t_sale_goods.*, user_img,user_id,user_name,user_status from t_user,t_sale_goods where goods_by_user_id=user_id and goods_category_id=${param1} and goods_status=1 order by goods_${param2} DESC")
    List<Map<String,Object>> selectSaleGoodsAndUserByCategoryId(Integer category_id, String order);

    /**
     * 根据用户id查询所有的二手商品并降序排列
     * @param user_id
     * @return
     */
    @Select("select t_sale_goods.*, user_img,user_id,user_name,user_status from t_user,t_sale_goods where goods_by_user_id=user_id and user_id=#{user_id} order by goods_id DESC")
    List<Map<String, Object>> selectSaleGoodsByUserId(Integer user_id);

    /**
     * 根据二手商品id查询详细内容和对应用户信息
     * @param goods_id
     * @return
     */
    @Select("select t_sale_goods.*,user_img,user_id,user_name,user_status from t_user,t_sale_goods where goods_by_user_id=user_id and goods_id=#{goods_id}")
    Map<String,Object> selectSaleGoodsAndUserByGoodsId(Integer goods_id);


    /**
     * 查询收藏列表
     * @param user_id
     * @return
     */
    @Select("select t_sale_goods.*,user_img,user_id,user_name,user_status,collection_id from t_collection ,t_sale_goods,t_user where collection_goods_id=goods_id  and user_id=goods_by_user_id and collection_status=1 and collection_user_id=#{user_id} order by goods_id desc")
    List<Map<String,Object>> selectSaleGoodsCollection(Integer user_id);


    /**
     * 根据分类查询求购和对应用户信息
     * @param category_id
     * @param order
     * @return
     */
    @Select("select t_buy_goods.*,user_img,user_id,user_name,user_status from t_user,t_buy_goods where product_by_user_id=user_id and product_category_id=${param1} and product_status=1 order by product_${param2} DESC")
    List<Map<String,Object>> selectBuyGoodsAndUserByCategoruId(Integer category_id, String order);


    /**
     * 根据用户id查询所有的求购并降序排列
     * @param user_id
     * @return
     */
    @Select("select t_buy_goods.*, user_img,user_id,user_name,user_status from t_user,t_buy_goods where product_by_user_id=user_id and user_id=#{user_id} order by product_id DESC")
    List<Map<String, Object>> selectBuyGoodsByUserId(Integer user_id);


    /**
     * 根据求购信息id查询求购相信信息及用户信息
     * @param product_id
     * @return
     */
//    @Select("select t_buy_goods.*,user_img,user_id,user_name,user_status from t_user,t_buy_goods where product_by_user_id=user_id and product_id=${param1}")
//    Map<String,Object> selectBuyGoodsAndUserByProductId(Integer product_id);



}


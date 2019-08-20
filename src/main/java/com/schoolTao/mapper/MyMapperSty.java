package com.schoolTao.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface MyMapperSty {


    /***
     * 根据用户输入的信息搜索所有的发布的商品
     * @param likestr
     * @return
     */
    /*@Select(value = {"select product_id as productId,product_img as productImg,product_title as productTitle,product_details as productDetails,product_price as productPrice,product_contact_phone as productContactPhone,product_categeory_id as productCategeoryId,product_contact_qq as productContactQq,product_publish_time as productPublishTime,product_valid_time as productValidTime,product_by_user_id as productByUserId,product_hot as productHot,product_categeory_name as productCategeoryName from t_buy_goods where product_title like CONCAT('%',#{0},'%') or product_details like CONCAT('%',#{0},'%') or product_categeory_name like CONCAT('%',#{0},'%')"})
    public List<TBuyGoods> listAllBuyGoods(String likestr);*/

    /***
     * 根据用户输入的信息搜索所有的求购的商品
     * @param likestr
     * @return
     */
    /*@Select(value = {"select goods_id as goodsId,goods_img as goodsImg,goods_title as goodsTitle,goods_details as goodsDetails,goods_price as goodsPrice,goods_contact_phone as goodsContactPhone,goods_categeory_id as goodsCategeoryId,goods_contact_qq as goodsContactQq,goods_publish_time as goodsPublishTime,goods_valid_time as goodsValidTime,goods_by_user_id as goodsByUserId,goods_hot as goodsHot,goods_categeory_name as goodsCategeoryName from t_sale_goods where goods_title like CONCAT('%',#{0},'%') or goods_details like CONCAT('%',#{0},'%') or goods_categeory_name like CONCAT('%',#{0},'%')"})
    public List<TSaleGoods> listAllSaleGoods(String likestr);*/


    /****
     * 直接找所有的回复以及用户信息，在前台判断遍历
     * @return
     */
    @Select(value = {"select t_reply.*,t_user.* from t_reply,t_user where t_reply.user_id=t_user.user_id"})
    public List<Map<String,Object>> findAllReplyWithUserInfo();


    /***
     * 多表查询,查Buygoods
     * @return
    */
    @Select(value = {"select product_id as productId,product_img as productImg,product_title as productTitle,product_details as productDetails,product_price as productPrice,product_contact_phone as productContactPhone,product_category_id as productCategoryId,product_contact_qq as productContactQq,product_publish_time as productPublishTime,product_status as productStatus,product_by_user_id as productByUserId,product_hot as productHot,product_category_name as productCategoryName,user_id as userId,user_name as userName,user_status as userStatus,user_img as userImg from t_buy_goods,t_user where t_buy_goods.product_by_user_id=t_user.user_id and (product_title like CONCAT('%',#{0},'%') or product_details like CONCAT('%',#{0},'%') or product_category_name like CONCAT('%',#{0},'%'))" })

    public List<Map<String,Object>> findAllBuyGoods(String likestr);



    /***
     * 多表查询,查Salegoods
     * @return
     */

    @Select(value = {"select goods_id as goodsId,goods_img as goodsImg,goods_title as goodsTitle,goods_details as goodsDetails,goods_price as goodsPrice,goods_contact_phone as goodsContactPhone,goods_category_id as goodsCategoryId,goods_contact_qq as goodsContactQq,goods_publish_time as goodsPublishTime,goods_status as goodsStatus,goods_by_user_id as goodsByUserId,goods_hot as goodsHot,goods_category_name as goodsCategoryName,user_id as userId,user_name as userName,user_status as userStatus,user_img as userImg from t_sale_goods,t_user where t_sale_goods.goods_by_user_id=t_user.user_id and (goods_title like CONCAT('%',#{0},'%') or goods_details like CONCAT('%',#{0},'%') or goods_category_name like CONCAT('%',#{0},'%'))" })

    public List<Map<String,Object>> findAllSaleGoods(String likestr);


    /****
     * 通过评论的id去把这条评论找出来
     * @return
     */
    @Select(value = {"select t_comment.*,t_user.user_id,user_name,user_img from t_comment,t_user where t_comment.user_id=t_user.user_id and comment_id=#{param1}"})
    public List<Map<String,Object>> findThatComment(Integer commentId);

    /****
     * 根据刚刚插入的时间来找这条回复并带上用户信息
     * @return
     */
    @Select(value = {"select t_reply.*,user_img from t_reply,t_user where t_reply.user_id=t_user.user_id and reply_time=#{param1}"})
    public List<Map<String,Object>> findThatReplyWithInsertTime(Integer reply_time);



    /***
     * 多表查询，找商品下所有的评论
     * @param goodId
     * @return
     */
    @Select(value = {"select t_comment.*,t_user.user_id,user_name,user_email,user_img,user_status from t_comment,t_user where t_comment.user_id=t_user.user_id and product_id=#{param1}"})
    public List<Map<String,Object>> findAllCommentAndUserInfo(Integer goodId);



    /***
     * 多表查询，找商品下某一条评论的所有的回复
     * @param commentId
     * @return
     */
    @Select(value = {"select t_reply.*,t_user.* from t_reply,t_user where t_reply.user_id=t_user.user_id and reply_id=#{param1}"})
    public List<Map<String,Object>> findAllReplyAndUserInfo(Integer commentId);


}

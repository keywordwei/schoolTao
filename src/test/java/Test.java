import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.schoolTao.mapper.MyMapperSty;
import com.schoolTao.mapper.TBuyGoodsMapper;
import com.schoolTao.mapper.TUserMapper;
import com.schoolTao.model.*;
import com.schoolTao.service.SGoodsService;
import com.schoolTao.service.impl.SGoodsServiceImpl;
import com.schoolTao.utils.MybatisUtil;
import com.schoolTao.utils.TimeUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class Test {

    @org.junit.Test
    public void test01(){
//        ICategeoryService ics = new CategeoryServiceImpl();
//        List<TCategory> categeories = ics.findAllCategory();

//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        TBuyGoodsMapper mapper = sqlSession.getMapper(TBuyGoodsMapper.class);
//        TCategoryMapper mapper = sqlSession.getMapper(TCategoryMapper.class);
//        List<TBuyGoods> categeories = mapper.selectByExample(null);
//        List<TCategory> categeories = mapper.selectByExample(null);
       // IGoodsService ibs = new GoodsServiceImpl();
        //List<TBuyGoods> tBuyGoods = ibs.findBuyGoodsByCategoryId(1,"product_hot");
       // System.out.println(tBuyGoods);
//        int i=0;
//      /  for(TBuyGoods categeory:tBuyGoods){
//            System.out.println(i+++"hh :"+categeory);
////            System.out.println(mapper.countByExample(null));
//        }
    }


    @org.junit.Test
    public void test02(){
        SqlSession session = MybatisUtil.getSqlSession();
        TUserMapper userMapper = session.getMapper(TUserMapper.class);
        TUserExample userExample = new TUserExample();
        TUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo("stystysty");
        criteria.andUserPwdEqualTo("11111111");
        List<TUser> users = userMapper.selectByExample(userExample);
        System.out.println(users);
    }


    @org.junit.Test
    public void testTime(){
        //long time = TimeUtil.getTimeStamp();
        long time = 1561607282;
        String format = "yyyy-MM-dd HH:mm:ss";
        String timeStamp =  time+"";
        String date = TimeUtil.timeStampToDate(timeStamp,format);
        String times = TimeUtil.dateTotimeStamp(date,format);
        System.out.println(date);
        System.out.println(1561607282);
    }


    @org.junit.Test
    public void testInsertUser(){
        SqlSession session = MybatisUtil.getSqlSession();
        TUserMapper userMapper = session.getMapper(TUserMapper.class);
        System.out.println("ss");
        TUser user = new TUser();
        user.setUserPwd("1111");
        user.setUserName("wwww");
        user.setUserStatus(0);
        user.setUserEmail("11@qq.com");
        int rows = userMapper.insert(user);
        System.out.println("s1"+rows);
        session.commit();
        System.out.println("s2");
        session.close();
    }


    /****
     * 分割字符串
     */
    @org.junit.Test
    public void testSplit(){

        String str = "貂皮,衣";
        String[] strs=str.split("[\\s+]|，");
        for(String s : strs){
            SqlSession session = MybatisUtil.getSqlSession();

            String likeStr = "%"+ s +"%";

            TBuyGoodsMapper goodsMapper = session.getMapper(TBuyGoodsMapper.class);
            TBuyGoodsExample goodsExample = new TBuyGoodsExample();
            TBuyGoodsExample.Criteria criteria = goodsExample.createCriteria();
            criteria.andProductTitleLike(likeStr);
            criteria.andProductDetailsLike(likeStr);
            criteria.andProductCategoryNameLike(likeStr);
            List<TBuyGoods> goods = goodsMapper.selectByExample(goodsExample);
            System.out.println(goods);
        }
    }



    /****
     * 查询所有商品
     */
    @org.junit.Test
    public void testSearchGoods(){
        SqlSession session = MybatisUtil.getSqlSession();
        MyMapperSty myMapperSty = session.getMapper(MyMapperSty.class);
//        List<TBuyGoods> goods = myMapperSty.searchAllGoods();
//        System.out.println(goods);
        session.close();
    }


    @org.junit.Test
    public void test(){
        SqlSession session = MybatisUtil.getSqlSession();
        TBuyGoodsMapper goodsMapper = session.getMapper(TBuyGoodsMapper.class);
        List<TBuyGoods> goods = goodsMapper.selectByExample(null);
        System.out.println(goods);
        session.close();
    }
    /***
     * 测试BuyGoods*/
    /*@org.junit.Test
    public void testMyMapper(){
        SqlSession session = MybatisUtil.getSqlSession();
        try{
            MyMapperSty goodsMapper = session.getMapper(MyMapperSty.class);
            List<TBuyGoods> goods = goodsMapper.listAllBuyGoods("貂皮");
            System.out.println(goods);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }*/
    /***
     * 测试SaleGoods*/
    /*@org.junit.Test
    public void testMyMapperSale2(){
        SqlSession session = MybatisUtil.getSqlSession();
        try{
            MyMapperSty goodsMapper = session.getMapper(MyMapperSty.class);
            List<TSaleGoods> goods = goodsMapper.listAllSaleGoods("貂皮");
            System.out.println(goods);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }*/

    /***
     * 多表查询*/
    @org.junit.Test
    public void testMoreTable(){
        SGoodsService sGoodsService = new SGoodsServiceImpl();
        PageHelper.startPage(1,3);
        List<Map<String,Object>> goods = sGoodsService.findAllBuyGoods("貂皮");
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(goods);
        System.out.println(pageInfo.getNavigateFirstPage());
        System.out.println("pageInfo:"+pageInfo.getNavigateFirstPage());
    }



    /***
     * sty
     * 查找评论
     * */
    @org.junit.Test
    public void findAllComment(){
        SqlSession session = MybatisUtil.getSqlSession();
        MyMapperSty myMapperSty = session.getMapper(MyMapperSty.class);
        List<Map<String,Object>> maps = myMapperSty.findAllCommentAndUserInfo(9);
        System.out.println(maps.size());
        System.out.println(maps);
    }

    /***
     * sty
     * 查找回复
     * */
    @org.junit.Test
    public void findAllReplyByComments(){
        SqlSession session = MybatisUtil.getSqlSession();
        MyMapperSty myMapperSty = session.getMapper(MyMapperSty.class);
        List<Map<String,Object>> map = myMapperSty.findAllReplyAndUserInfo(12);
        System.out.println(map);
        System.out.println(map.size());
    }


    /***
     * sty
     * 查找回复
     * */
    @org.junit.Test
    public void findThatComment(){
        SqlSession session = MybatisUtil.getSqlSession();
        MyMapperSty myMapperSty = session.getMapper(MyMapperSty.class);
        List<Map<String,Object>> maps = myMapperSty.findThatComment(21);
        System.out.println(maps.get(0));
       System.out.println(maps);
        System.out.println(maps.size());
    }




    /***
     * sty
     * 查找回复
     * */
    @org.junit.Test
    public void findThatReply(){
        SqlSession session = MybatisUtil.getSqlSession();
        MyMapperSty mapper = session.getMapper(MyMapperSty.class);
        List<Map<String,Object>> maps = mapper.findThatReplyWithInsertTime(1560934092);
        System.out.println(maps.get(0));
        System.out.println(maps);
        System.out.println(maps.size());
    }

    /***
     * 找所有回复信息
     */
    @org.junit.Test
    public void findAllRelpy(){
        SqlSession session = MybatisUtil.getSqlSession();
        MyMapperSty mapper = session.getMapper(MyMapperSty.class);
        List<Map<String,Object>> mapList = mapper.findAllReplyWithUserInfo();
        System.out.println("mapList:"+mapList);
        System.out.println(mapList.size());
    }
}

package com.schoolTao.controller.sy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.schoolTao.model.TCategory;
import com.schoolTao.model.TSaleGoods;
import com.schoolTao.model.TUser;
import com.schoolTao.service.ICategeoryService;
import com.schoolTao.service.StySaleGoodService;
import com.schoolTao.service.TUserService;
import com.schoolTao.service.impl.CategeoryServiceImpl;
import com.schoolTao.service.impl.StySaleGoodServiceImpl;
import com.schoolTao.service.impl.TUserServiceImpl;
import com.schoolTao.utils.UploadUtils;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.disk.*;

@WebServlet(name = "ReleaseServlet",urlPatterns = {"/release.action"})
public class ReleaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //保存文件到磁盘uploadFile目录下
        String savepath = ("D://uploadFile");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2、创建一个文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        String image= "";
        //用于保存非文件数据的集合
        List<String> pList = new ArrayList<>();
        TSaleGoods tSaleGoods = new TSaleGoods();
        //form表单数据的集合
        List<FileItem> list = null;
        String filename;
        try {
            //获取form表单提交的数据
            list = upload.parseRequest(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(list!=null) {
            for (FileItem item : list) {
                //如果fileitem中封装的是普通输入项的数据
                if (item.isFormField()) {
                    //String name = item.getFieldName();
                    String value = item.getString("UTF-8");
                    pList.add(value);//将非文件的其他参数放到一个list中，后面可以顺序的去取到
                    continue;
                } else {//如果fileitem中封装的是上传文件
                    InputStream stream = item.getInputStream();//上传文件需要的文件流参数
                    filename = item.getName();   //上传文件需要的参数
                    if (filename == null || filename.trim().equals("")) {
                        //判空处理}
                        continue;
                    }
                    //获得随机的文件名
                    String randomfilename =  UploadUtils.getrandomFilename(filename);
                    //获得分离目录
                    String realpath = UploadUtils.getpath(randomfilename);
                    String url = savepath + realpath;
                    File file = new File(url);  //这个要自己写具体的路径，是需要上传文件需要的参数
                    if(!file.exists()){
                        file.mkdirs();
                    }
                    UploadUtils.uploadFile(stream, file, randomfilename);   //调用工具类方法
                    //设置发布单图片,使用#分割每张图片
                    String imgpath = (realpath+'/'+randomfilename).replace("\\","//");
                    image += imgpath+"#";
                }
            }
        }
        //查找用户id
            /*tSaleGoods.setGoodsByUserId(1);*/
            String username =  request.getSession().getAttribute("username").toString();
            TUserService tUserService = new TUserServiceImpl();
            List<TUser> userList = tUserService.findLoginUser(username);
            System.out.println("userList"+userList);
            if(userList.size()>0) {
                TUser user = userList.get(0);
                //设置发布订单的用户id
                tSaleGoods.setGoodsByUserId(user.getUserId());
            }

        image = image.substring(0,image.length()-1);
        //设置图片路径
        tSaleGoods.setGoodsImg(image);
        //处理表单数据
        processFormdata(pList, tSaleGoods);
        /*tSaleGoods.setGoodsByUserId(1);*/
        StySaleGoodService releseService = new StySaleGoodServiceImpl();
        //保存发布的订单
        releseService.save(tSaleGoods);
        request.getRequestDispatcher("/saleGoods.action").forward(request,response);
}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
    //处理表单提交的其他数据
    public void processFormdata( List<String> list ,TSaleGoods tSaleGoods) {
        //发布单title
        String goods_title = list.get(0);
        System.out.println(goods_title);
        //发布单详情
        String goods_detail = list.get(1);
        //价格
        String goods_price = list.get(2);
        //类别
        String goods_categeory_name = list.get(3);
        System.out.println(goods_categeory_name);
        //电话
        String goods_contact_phone = list.get(4);
        //qq
        String goods_contact_qq = list.get(5);
        tSaleGoods.setGoodsTitle(goods_title);
        tSaleGoods.setGoodsDetails(goods_detail);
        tSaleGoods.setGoodsPrice(Double.parseDouble(goods_price));
        tSaleGoods.setGoodsContactPhone(goods_contact_phone);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String publishDate = df.format(new Date());
        //将日期横杠去掉
        String publishtime = publishDate.replace("-", "");
        //转换为int,设置发布日期
        tSaleGoods.setGoodsPublishTime(Integer.parseInt(publishtime));
        //设置联系人qq
        tSaleGoods.setGoodsContactQq(goods_contact_qq);
        //设置商品名称
        tSaleGoods.setGoodsCategoryName(goods_categeory_name);
        //通过名字查找id
        ICategeoryService iCategeoryService = new CategeoryServiceImpl();
        TCategory tCategory = iCategeoryService.findCategoryByname(goods_categeory_name);
        System.out.println(tCategory.getCategoryId());
        //设置商品id
        tSaleGoods.setGoodsCategoryId(tCategory.getCategoryId());
        //默认热度为0
        tSaleGoods.setGoodsHot(0);
        //默认有有效期
        tSaleGoods.setGoodsStatus(1);
    }
}

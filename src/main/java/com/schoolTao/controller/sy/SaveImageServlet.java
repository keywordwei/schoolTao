package com.schoolTao.controller.sy;

import com.schoolTao.model.TUser;
import com.schoolTao.service.TUserService;
import com.schoolTao.service.impl.TUserServiceImpl;
import com.schoolTao.utils.UploadUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "SaveImageServlet",urlPatterns = {"/saveimage.action"})
public class SaveImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 获取客户端传过来图片的二进制流
            String savepath =  "D://uploadFile/";
            InputStream stream = request.getInputStream();
            // 以当前时间戳为图片命名
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String strCurrentTime = df.format(new Date());
            //获得分离目录
            String realpath = UploadUtils.getpath(strCurrentTime);
            //创建目录
            File file = new File((savepath+realpath));
            if(!file.exists()){
                file.mkdirs();
            }
            //图片的绝对路径
            String imagePath =savepath+realpath + "/"+strCurrentTime + ".png";
            //数据库存放的的图片路径
            String image = realpath + "/" +strCurrentTime+".png";
            String username = (String) request.getSession().getAttribute("username");
            TUser user = new TUser();
            TUserService tUserService = new TUserServiceImpl();
            List<TUser> list =tUserService.findLoginUser(username);
            if(list.size()>0){
                user = list.get(0);
                user.setUserImg(image);
            }
            HttpSession session = request.getSession();
            session.setAttribute("userimage",image);
            tUserService.update(user);
            //写入流
            FileOutputStream fos = new FileOutputStream(imagePath);
            byte[] bbuf = new byte[32];
            int hasRead = 0;
            while ((hasRead = stream.read(bbuf)) > 0) {
                fos.write(bbuf, 0, hasRead);
            }
            fos.close();
            stream.close();
            /**
             * 流的前四行包含了文件上传的描述信息，应该从第四行后开始写入
             *先将文件存成临时文件，在重新读取后覆盖，临时文件与最终存的是同一个
             */
            Byte n;
            // 读取临时文件
            RandomAccessFile random = new RandomAccessFile(imagePath, "r");
            int second = 1;
            String secondLine = null;
            while (second <= 2) {
                secondLine = random.readLine();
                second++;
            }
            int position = secondLine.lastIndexOf('\\');
            // 获取上传文件的名称
            String fileName = secondLine.substring(position + 1, secondLine.length() - 1);
            System.out.println("filename:"+fileName);
            random.seek(0);
            long forthEndPosition = 0;
            int forth = 1;
            //读取前四行
            while ((n = random.readByte()) != -1 && (forth <= 4)) {
                if (n == '\n') {
                    forthEndPosition = random.getFilePointer();
                    forth++;
                }
            }
            //文件的的真正内容
            RandomAccessFile random2 = new RandomAccessFile(imagePath, "rw");
            random.seek(random.length());
            long endPosition = random.getFilePointer();
            long mark = endPosition;
            int j = 1;
            while ((mark >= 0) && (j <= 6)) {
                mark--;
                random.seek(mark);
                n = random.readByte();
                if (n == '\n') {
                    endPosition = random.getFilePointer();
                    j++;
                }
            }
            random.seek(forthEndPosition);
            long startPoint = random.getFilePointer();
            while (startPoint < endPosition - 1) {
                n = random.readByte();
                random2.write(n);
                startPoint = random.getFilePointer();
            }
            random.close();
            random2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {

        }
    }


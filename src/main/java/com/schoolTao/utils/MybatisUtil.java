package com.schoolTao.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtil {
    private static Reader reader;
    private static SqlSessionFactory sessionFactory;
    public static SqlSessionFactory getSessionFactory() {
        //加载mybatis配置文件
        try {
            reader = Resources.getResourceAsReader("conf.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sessionFactory;
    }
    public static SqlSession getSqlSession() {
        return getSessionFactory().openSession();
    }
}

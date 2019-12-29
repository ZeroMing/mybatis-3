package org.mybatis.leolee;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.leolee.dao.UserDao;
import org.mybatis.leolee.entity.User;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: zeroming@163.com
 * @version:
 * @date: 2019年12月29 13时21分
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String resouce = "mybatis-conf.xml";
        InputStream is = Resources.getResourceAsStream(resouce);

        // 构建sqlSession工厂。它的作用域应该是应用作用域。应该只创建一次，不需要重复创建，应该是单例模式创建。
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        SqlSession session = sqlSessionFactory.openSession();

        User user = null;
        UserDao userDao = null;
        try{
            // 第二种方式: 执行更清晰和类型安全的代码
            userDao = session.getMapper(UserDao.class);
//                user = userDao.getById(1);
//                System.out.println(user);
//                user = userDao.getById(1);
//                System.out.println(user);
            user = userDao.getById(1);
            System.out.println(user);
        }finally {
            // 确保 SqlSession 关闭的标准模式
            session.close();
        }

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        userDao = sqlSession2.getMapper(UserDao.class);
        user = userDao.getById(1);
        System.out.println(user);
        /*try {
         *//**
         * 第一种方式: 直接执行已映射的 SQL 语句
         *//*
            String statement = "com.lee.dao.UserDao.getById";
            user = session.selectOne(statement, 1);
            System.out.println(user);
        }
        finally {
            session.close();
        }*/
    }

}

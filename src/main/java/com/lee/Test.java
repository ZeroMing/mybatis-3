package com.lee;

import com.lee.dao.UserDao;
import com.lee.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description: 测试文件代码
 * @author: Eden.Lee/李明
 * @company: 朴新教育
 * @date: 2019/5/8 19:23
 */
public class Test {


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

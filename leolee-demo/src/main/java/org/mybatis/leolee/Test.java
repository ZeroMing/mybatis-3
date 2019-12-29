package org.mybatis.leolee;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.mybatis.leolee.dao.UserDao;
import org.mybatis.leolee.entity.Job;
import org.mybatis.leolee.entity.User;
import org.mybatis.leolee.entity.UserInfoMap;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @description: 测试文件代码
 * @author: Eden.Lee/李明
 * @company: 朴新教育
 * @date: 2019/5/8 19:23
 */
public class Test {

    public static  SqlSessionFactory sqlSessionFactory = null;

    @BeforeClass
    public static  void berfore() throws IOException {
        String resouce = "mybatis-conf.xml";
        InputStream is = Resources.getResourceAsStream(resouce);
        // 构建sqlSession工厂。它的作用域应该是应用作用域。应该只创建一次，不需要重复创建，应该是单例模式创建。
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @AfterClass
    public static  void after(){
        sqlSessionFactory = null;
    }


    @org.junit.Test
    public void testCollection_N_1_Query() throws InterruptedException {
        SqlSession session1 = sqlSessionFactory.openSession();
        UserDao mapper = session1.getMapper(UserDao.class);
        List<UserInfoMap> userInfoById = mapper.getUserInfoByAge(11);
        session1.close();
        Thread.sleep(5000);
        System.out.println("----------------------");
        List<Job> jobs = userInfoById.get(0).getJobs();
        System.out.println(jobs);

    }


    @org.junit.Test
    public void testCollectionQuery() throws InterruptedException {
        SqlSession session1 = sqlSessionFactory.openSession();
        UserDao mapper = session1.getMapper(UserDao.class);
        UserInfoMap userInfoById = mapper.getUserInfoById(1);
        session1.close();
        Thread.sleep(5000);
        System.out.println("----------------------");
        List<Job> jobs = userInfoById.getJobs();
        System.out.println(jobs);

    }

    @org.junit.Test
    public void testAssociationQuery(){
        SqlSession session1 = sqlSessionFactory.openSession();
        UserDao mapper = session1.getMapper(UserDao.class);
        UserInfoMap userInfoById = mapper.getUserInfoById(1);
        System.out.println(userInfoById);
        session1.close();
    }

    @org.junit.Test
    public void testSecondCache(){
        // 获取sqlSession
        SqlSession session1 = sqlSessionFactory.openSession();
        SqlSession session2 = sqlSessionFactory.openSession();
        SqlSession session3 = sqlSessionFactory.openSession();
        SqlSession session4 = sqlSessionFactory.openSession();

        // 查询id=1
        UserDao mapper1 = session1.getMapper(UserDao.class);
        User byId = mapper1.getById(1);
        System.out.println(byId);
        session1.close();
        System.out.println("----------session1--------------");

        // 查询name=李四
//        UserDao mapper2 = session2.getMapper(UserDao.class);
//        User userName = mapper2.getByName("李四");
//        System.out.println(userName);
//        session2.close();
//        System.out.println("----------session2--------------");
        // 更新数据
        UserDao mapper3 = session3.getMapper(UserDao.class);
        Integer leoLee = mapper3.updateNameById(3, "LeoLee");
        System.out.println(leoLee);
        session3.commit();
        session3.close();
        System.out.println("-----------session3-------------");

        // 继续查询.一个nameSpace下某个更新操作会导致整个nameSpace的缓存全部失效
        UserDao mapper4 = session4.getMapper(UserDao.class);
        User byId1 = mapper4.getById(1);
        System.out.println(byId1);
        session4.close();
    }

}

package org.mybatis.leolee.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.leolee.entity.User;
import org.mybatis.leolee.entity.UserInfoMap;
import org.omg.CORBA.INTERNAL;

import java.util.List;

/**
 * @description: 用户Mapper
 * @author: Eden.Lee/李明
 * @company: 朴新教育
 * @date: 2019/5/8 16:22
 */
public interface UserDao {

    User getById(Integer id);

    List<UserInfoMap> getUserInfoByAge(@Param("userAge") Integer userAge);

    UserInfoMap getUserInfoById(Integer id);

    User getByName(String userName);

    Integer updateNameById(@Param("id") Integer id, @Param("userName")String userName);

}

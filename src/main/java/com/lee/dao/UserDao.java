package com.lee.dao;

import com.lee.entity.User;

/**
 * @description: 用户Mapper
 * @author: Eden.Lee/李明
 * @company: 朴新教育
 * @date: 2019/5/8 16:22
 */
public interface UserDao {

    User getById(Integer id);

}

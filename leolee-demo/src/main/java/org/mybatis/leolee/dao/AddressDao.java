package org.mybatis.leolee.dao;

import org.mybatis.leolee.entity.Address;

/**
 * @author: zeroming@163.com
 * @version:
 * @date: 2019年12月29 14时16分
 */
public interface AddressDao {
    Address getById(Integer id);
}

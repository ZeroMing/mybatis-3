package org.mybatis.leolee.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.leolee.entity.Job;

import java.util.List;

/**
 * @author: zeroming@163.com
 * @version:
 * @date: 2019年12月29 15时01分
 */
public interface JobDao {
    List<Job> listByUserId(@Param("userId") Integer userId);
}

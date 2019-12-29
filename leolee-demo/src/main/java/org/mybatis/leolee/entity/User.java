package org.mybatis.leolee.entity;

import lombok.Data;

/**
 * @description: TODO-Eden.Lee
 * @author: Eden.Lee/李明
 * @company: 朴新教育
 * @date: 2019/5/8 16:05
 */
@Data
public class User {
    private int id;             // 用户id
    private String userName;    // 用户名
    private Integer userAge;    // 用户年龄
    private Integer addressId;  // 用户所属地区ID
}
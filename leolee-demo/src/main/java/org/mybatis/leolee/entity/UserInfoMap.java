package org.mybatis.leolee.entity;

import lombok.Data;

import java.sql.Blob;
import java.util.List;

/**
 * @author: zeroming@163.com
 * @version:
 * @date: 2019年12月29 14时13分
 */
public class UserInfoMap {
    private Integer id;
    private String userName;
    private Address address;
    private List<Job> jobs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}

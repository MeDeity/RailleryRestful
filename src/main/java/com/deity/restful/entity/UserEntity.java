package com.deity.restful.entity;

import javax.persistence.Table;

/**
 * 用户实体类
 * 自定义user表的名称
 * Created by Deity on 2017/7/17.
 */
@Table(name = "t_user")
public class UserEntity {
    /**编号*/
    private int id;
    /**用户名*/
    private String userName;
    /**用户描述*/
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

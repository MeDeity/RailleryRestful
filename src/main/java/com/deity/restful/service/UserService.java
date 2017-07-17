package com.deity.restful.service;

import com.deity.restful.entity.UserEntity;

/**
 * 用户操作逻辑接口
 * Created by Deity on 2017/7/17.
 */
public interface UserService {

    UserEntity obtainUser(String userName);
}

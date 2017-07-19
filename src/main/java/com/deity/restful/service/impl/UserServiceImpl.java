package com.deity.restful.service.impl;

import com.deity.restful.dao.UserDao;
import com.deity.restful.entity.UserEntity;
import com.deity.restful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户操作逻辑实现类
 * Created by Deity on 2017/7/17.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public UserEntity obtainUser(String userName) {
        return userDao.obtainUser(userName);
    }
}

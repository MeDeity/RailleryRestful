package com.deity.restful.controller;

import com.deity.restful.entity.UserEntity;
import com.deity.restful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Deity on 2017/7/17.
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/api/user",method = RequestMethod.GET)
    public UserEntity obtainUser(@RequestParam(value = "userName")String userName){
        return userService.obtainUser(userName);
    }
}

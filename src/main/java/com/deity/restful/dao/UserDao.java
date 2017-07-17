package com.deity.restful.dao;

import com.deity.restful.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

/**
 * 用户Dao操作类
 * Created by Deity on 2017/7/17.
 */
@Mapper
public interface UserDao {

    @Select("Select * from userEntity")
    @Results({
        @Result(property = "id",column = "id'"),
        @Result(property = "userName",column = "userName"),
        @Result(property = "description",column = "description")
    })
    UserEntity obtainUser(@Param("userName") String userName);
}

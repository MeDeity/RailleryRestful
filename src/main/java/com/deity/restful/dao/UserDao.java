package com.deity.restful.dao;

import com.deity.restful.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户Dao操作类
 * Created by Deity on 2017/7/17.
 */
@Mapper
@Repository //该注释可以有效的防止UserServiceImpl中@AutoWire报错
public interface UserDao {

    @Select("Select * from userEntity")
    @Results({
        @Result(property = "id",column = "id'"),
        @Result(property = "userName",column = "userName"),
        @Result(property = "description",column = "description")
    })
    UserEntity obtainUser(@Param("userName") String userName);
}

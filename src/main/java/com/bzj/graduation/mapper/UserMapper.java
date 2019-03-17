package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author:bai
 * @data:2019/3/7
 **/
@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> getAll();

    @Select("select password from user where username=#{username}")
    String getPassword(@PathVariable String username);

    @Select("select id from user where username=#{username}")
    Integer getUserId(@PathVariable String username);
}

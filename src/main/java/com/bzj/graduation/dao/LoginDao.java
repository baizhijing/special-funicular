package com.bzj.graduation.dao;

import com.bzj.graduation.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author:bai
 * @data:2019/3/7
 **/

@Repository
public class LoginDao {
    @Autowired
    private UserMapper userMapper;

    public String getPassword(String username){
        return userMapper.getPassword(username);
    }
}

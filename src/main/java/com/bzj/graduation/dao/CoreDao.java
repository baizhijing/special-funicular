package com.bzj.graduation.dao;

import com.bzj.graduation.bean.ConfigList;
import com.bzj.graduation.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author:bai
 * @data:2019/3/15
 **/
@Repository
public class CoreDao {
    @Autowired
    private UserMapper userMapper;

    public boolean insertList(ConfigList configList){

        return true;
    }
}

package com.bzj.graduation.dao;

import com.bzj.graduation.bean.User;
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

    public Integer getUserId(String username){
        return userMapper.getUserId(username);
    }

    public String getPassword(String username){
        return userMapper.getPassword(username);
    }

    public boolean ifExitUsername(String username){
        if ((userMapper.getUserId(username))!=null)
            return true;
        else
            return false;
    }

    public void addInteg(Integer integNum,String username){
        userMapper.addInteg(integNum,username);
    }

    public User getUser(String userName){return userMapper.selectUserByName(userName); }

    public void addUser(String username,String password){
        userMapper.insertUser(username,password);
    }

    public void updatelastSignInTime(String time,String username){
        userMapper.updateLastSignTime(time,username);
    }

    public String getlastSignInTime(String username){
        return userMapper.getSignInTime(username);
    }
}

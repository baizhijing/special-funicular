package com.bzj.graduation.service;

import com.bzj.graduation.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author:bai
 * @data:2019/3/7
 **/

@Service
public class LoginService {
    @Autowired
    private LoginDao loginDao;

    public boolean LoginIsTrue(String username,String password){
        if (!StringUtils.isEmpty(loginDao.getPassword(username)) &&loginDao.getPassword(username).equals(password))
            return true;
        else
            return false;
    }
    public int getUserId(String username){
        int userid=loginDao.getUserId(username);
        return userid;
    }
}

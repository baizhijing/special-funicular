package com.bzj.graduation.bean;

/**
 * @Author:bai
 * @data:2019/3/7
 **/
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer integ;//积分

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getInteg() {
        return integ;
    }

    public void setInteg(Integer integ) {
        this.integ = integ;
    }
}

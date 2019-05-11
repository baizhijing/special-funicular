package com.bzj.graduation.bean;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author:bai
 * @data:2019/3/7
 **/
@Component
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer integ;//积分
    private String lastSignTime;
    private Integer type;//用户类型，1代表管理员，2代表客户
}

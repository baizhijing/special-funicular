package com.bzj.graduation.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author:bai
 * @data:2019/3/13
 * 帖子详情表
 **/
@Component
@Data
public class RecordDetail {
    private Integer id;
    private Integer recordId;//帖子ID
    private Date createTime;
    private String img;
    private String comment;
    private Integer userId;
    private String username;
}

package com.bzj.graduation.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author:bai
 * @data:2019/3/13
 * 帖子表
 **/
@Component
@Data
public class Record {
    private Integer id;
    private String userName;
    private String title;
    private String createTime;
    private String content;
}

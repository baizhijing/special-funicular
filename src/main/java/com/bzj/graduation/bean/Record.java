package com.bzj.graduation.bean;

import java.util.Date;

/**
 * @Author:bai
 * @data:2019/3/13
 * 帖子表
 **/
public class Record {
    private Integer id;
    private Integer createId;
    private String title;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

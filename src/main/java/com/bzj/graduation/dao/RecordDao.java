package com.bzj.graduation.dao;

import com.bzj.graduation.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class RecordDao {
    @Autowired
    private RecordMapper recordMapper;

    public void insertRecord(Integer userId,String title,String content){
        recordMapper.InsertRecord(userId,title,content);
    }
}

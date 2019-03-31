package com.bzj.graduation.service;

import com.bzj.graduation.dao.RecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {
    @Autowired
    private RecordDao recordDao;

    public void Insert(Integer userId,String title,String content){
        recordDao.insertRecord(userId,title,content);
    }
}

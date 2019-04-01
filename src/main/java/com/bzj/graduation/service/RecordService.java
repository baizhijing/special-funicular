package com.bzj.graduation.service;

import com.bzj.graduation.bean.Record;
import com.bzj.graduation.dao.RecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
    @Autowired
    private RecordDao recordDao;

    public void Insert(Integer userId,String title,String content){
        recordDao.insertRecord(userId,title,content);
    }

    public void delete(Integer id){
        recordDao.delRecord(id);
    }

    public List<Record> getAll(int currentPage, int pageSize){
        return recordDao.selectRecordByPage(currentPage,pageSize);
    }

    public Integer getRecordNum(Integer pageSize){
        int countNums= recordDao.getRecordNum();
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

    public List<Record> getPersonRecord(int currentPage, int pageSize,int userId){
        return recordDao.selectPersonRecordByPage(currentPage,pageSize,userId);
    }

    public Integer getPersonRecordCount(int userId,int pageSize){
        int countNums= recordDao.getPersonRecordCount(userId);
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }
}

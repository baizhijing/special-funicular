package com.bzj.graduation.service;

import com.bzj.graduation.bean.Record;
import com.bzj.graduation.dao.LoginDao;
import com.bzj.graduation.dao.RecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
    @Autowired
    private RecordDao recordDao;

    @Autowired
    private LoginDao loginDao;

    public void Insert(String userName,String title,String content){
        recordDao.insertRecord(userName,title,content);
        loginDao.addInteg(1,userName);
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

    public List<Record> getPersonRecord(int currentPage, int pageSize,String userName){
        return recordDao.selectPersonRecordByPage(currentPage,pageSize,userName);
    }

    public Integer getPersonRecordCount(String userName,int pageSize){
        int countNums= recordDao.getPersonRecordCount(userName);
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }
}

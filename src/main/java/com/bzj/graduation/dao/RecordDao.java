package com.bzj.graduation.dao;

import com.bzj.graduation.bean.PageBean;
import com.bzj.graduation.bean.Record;
import com.bzj.graduation.bean.User;
import com.bzj.graduation.mapper.RecordMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class RecordDao {
    @Autowired
    private RecordMapper recordMapper;

    public void insertRecord(String userName,String title,String content){
        recordMapper.InsertRecord(userName,title,content);
    }

    public void delRecord(Integer id){
        recordMapper.delRecord(id);
    }

    public List<Record> selectRecordByPage(int currentPage, int pageSize){
        PageHelper.startPage(currentPage, pageSize);
        List<Record> allRecords = recordMapper.selectAll();        //全部商品
        int countNums = recordMapper.getCount();            //总记录数
        PageBean<Record> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allRecords);
        return pageData.getItems();
    }

    public Integer getRecordNum(){
        return recordMapper.getCount();
    }

    public int getPersonRecordCount(String userName){
        return recordMapper.getPerosonRecordCount(userName);
    }

    public List<Record> selectPersonRecordByPage(int currentPage, int pageSize,String userName){
        PageHelper.startPage(currentPage, pageSize);
        List<Record> personRecords = recordMapper.getPerosonRecord(userName);        //全部商品
        int countNums = recordMapper.getPerosonRecordCount(userName);            //总记录数
        PageBean<Record> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(personRecords);
        return pageData.getItems();
    }
}

package com.bzj.graduation.dao;

import com.bzj.graduation.bean.RecordDetail;
import com.bzj.graduation.mapper.RecordDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:bai
 * @data:2019/4/1
 **/
@Repository
public class RecordDetailDao {
    @Autowired
    private RecordDetailMapper recordDetailMapper;

    public void addRecordDetail(int recordId,String username,String userId,String comment,String time){
        recordDetailMapper.insertRecordDeatil(recordId,username,userId,comment,time);
    }

    public List<RecordDetail> getAll(){
        return recordDetailMapper.selectAll();
    }

    public Integer getCount(){
        return recordDetailMapper.getCount();
    }

}

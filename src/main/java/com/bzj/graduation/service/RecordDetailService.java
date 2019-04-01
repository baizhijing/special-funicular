package com.bzj.graduation.service;

import com.bzj.graduation.bean.PageBean;
import com.bzj.graduation.bean.RecordDetail;
import com.bzj.graduation.dao.RecordDetailDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author:bai
 * @data:2019/4/1
 **/
@Service
public class RecordDetailService {
    @Autowired
    private RecordDetailDao recordDetailDao;

    public void addRecordDetail(int recordId,String username,String userId,String comment){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime=df.format(new Date()).toString();
        recordDetailDao.addRecordDetail(recordId,username,userId,comment,createTime);
    }

    public List<RecordDetail> selectAllByPage(int currentPage, int pageSize){
        PageHelper.startPage(currentPage, pageSize);
        List<RecordDetail> allRecordDetails = recordDetailDao.getAll();        //全部商品
        Integer countNums = recordDetailDao.getCount();            //总记录数
        PageBean<RecordDetail> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allRecordDetails);
        return pageData.getItems();
    }

    public Integer getPageNum(int pageSize){
        int countNums= recordDetailDao.getCount();
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }


}

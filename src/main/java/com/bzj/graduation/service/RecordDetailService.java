package com.bzj.graduation.service;

import com.bzj.graduation.bean.PageBean;
import com.bzj.graduation.bean.RecordDetail;
import com.bzj.graduation.dao.LoginDao;
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

    @Autowired
    private LoginDao loginDao;

    public void addRecordDetail(int recordId,String username,String comment){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime=df.format(new Date()).toString();
        Integer userId= loginDao.getUserId(username);
        recordDetailDao.addRecordDetail(recordId,username,userId,comment,createTime);
    }

    public List<RecordDetail> selectAllByPage(int currentPage, int pageSize,Integer recordId){
        PageHelper.startPage(currentPage, pageSize);
        List<RecordDetail> allRecordDetails = recordDetailDao.getAll(recordId);        //全部帖子
        Integer countNums = recordDetailDao.getCount(recordId);            //总记录数
        PageBean<RecordDetail> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allRecordDetails);
        return pageData.getItems();
    }

    public Integer getPageNum(int pageSize,Integer recordId){
        int countNums= recordDetailDao.getCount(recordId);
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }


}

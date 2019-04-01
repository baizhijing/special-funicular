package com.bzj.graduation.controller;

import com.bzj.graduation.bean.RecordDetail;
import com.bzj.graduation.service.RecordDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:bai
 * @data:2019/4/1
 **/
@RestController
public class RecordDetailController {

    @Autowired
    private RecordDetailService recordDetailService;

    @PostMapping("/addRecordDetail")
    public void addRecordDetail(int recordId,String username,String userId,String comment){
        recordDetailService.addRecordDetail(recordId,username,userId,comment);
    }

    @PostMapping("/getRecordDetailByPage")
    public List<RecordDetail> getAllByPage(int currentPage, int pageSize){
       return recordDetailService.selectAllByPage(currentPage,pageSize);
    }

    @PostMapping("/getRecordDetailCount")
    public Integer getCount(int pageSize){
        return recordDetailService.getPageNum(pageSize);
    }
}

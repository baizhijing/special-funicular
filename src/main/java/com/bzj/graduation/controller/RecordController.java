package com.bzj.graduation.controller;

import com.bzj.graduation.bean.Record;
import com.bzj.graduation.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class RecordController {
    @Autowired
    private RecordService recordService;

    @PostMapping("/addRecord")
    public void addRecord(Integer userId,String title){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String content=df.format(new Date()).toString();
        recordService.Insert(userId,title,content);
    }

    @GetMapping("/getRecordNum")
    public Integer getRecordNum(int pageSize){
        return recordService.getRecordNum(pageSize);
    }

    @PostMapping("/getAllRecord")
    public List<Record> getAll(int currentPage, int pageSize){
        return recordService.getAll(currentPage,pageSize);
    }

    @PostMapping("/getPersonRecord")
    public List<Record> getPersonRecord(int currentPage, int pageSize,int userId){
        return recordService.getPersonRecord(currentPage,pageSize,userId);
    }

    @PostMapping("/getPersonRecordCount")
    public Integer getPersonRecordCount(int pageSize,int userId){
        return recordService.getPersonRecordCount(userId,pageSize);
    }

    //删除
    @PostMapping("/delRecord")
    public void deleteRecord(Integer id){
        recordService.delete(id);
    }


}

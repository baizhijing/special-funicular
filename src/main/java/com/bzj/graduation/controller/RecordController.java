package com.bzj.graduation.controller;

import com.bzj.graduation.bean.Record;
import com.bzj.graduation.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/getAllRecord")
    public List<Record> getAll(){

    }

    @PostMapping("/delRecord")
    public void deleteRecord(){

    }


}

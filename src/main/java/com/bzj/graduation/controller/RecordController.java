package com.bzj.graduation.controller;

import com.bzj.graduation.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecordController {
    @Autowired
    private RecordService recordService;

    @PostMapping("/addRecord")
    public boolean addRecord(String title,String content){
        return true;
    }
}

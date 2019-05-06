package com.bzj.graduation.controller;

import com.bzj.graduation.bean.Record;
import com.bzj.graduation.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class RecordController {
    @Autowired
    private RecordService recordService;

    @PostMapping("/addRecord")
    public String addRecord(@RequestParam("title") String title, HttpSession session){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String userName=(String)session.getAttribute("loginUser");
        String content=df.format(new Date()).toString();
        recordService.Insert(userName,title,content);
        return "luntan";
    }

    @ResponseBody
    @GetMapping("/getRecordNum")
    public Integer getRecordNum(int pageSize){
        return recordService.getRecordNum(pageSize);
    }

    @ResponseBody
    @PostMapping("/getAllRecord")
    public List<Record> getAll(@RequestBody Map<String,Integer> map){
        Integer currentPage=map.get("currentPage");
        Integer pageSize=map.get("pageSize");
        return recordService.getAll(currentPage,pageSize);
    }

    @ResponseBody
    @PostMapping("/getPersonRecord")
    public List<Record> getPersonRecord(@RequestBody Map<String,Integer> map,HttpSession session){
        String userName=(String)session.getAttribute("loginUser");
        Integer currentPage=map.get("currentPage");
        Integer pageSize=map.get("pageSize");
        return recordService.getPersonRecord(currentPage,pageSize,userName);
    }

    @ResponseBody
    @GetMapping("/getPersonRecordCount")
    public Integer getPersonRecordCount(int pageSize,HttpSession session){
        String userName=(String) session.getAttribute("loginUser");
        return recordService.getPersonRecordCount(userName,pageSize);
    }

    //删除
    @PostMapping("/delRecord")
    public void deleteRecord(Integer id){
        recordService.delete(id);
    }

    @ResponseBody
    @GetMapping("/signIn")
    public boolean signIn(HttpSession session){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//         HH:mm:ss
        String userName=(String)session.getAttribute("loginUser");
        String time=df.format(new Date()).toString();
        return recordService.signIn(userName,time);
    }

}

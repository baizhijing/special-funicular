package com.bzj.graduation.controller;

import com.bzj.graduation.bean.RecordDetail;
import com.bzj.graduation.service.RecordDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @Author:bai
 * @data:2019/4/1
 **/
@Controller
public class RecordDetailController {

    @Autowired
    private RecordDetailService recordDetailService;

    @PostMapping("/addRecordDetail")
    public String addRecordDetail(@RequestParam Integer recordId,
                                  @RequestParam String comment, HttpSession session){
        String loginuser=(String)session.getAttribute("loginUser");
        recordDetailService.addRecordDetail(recordId,loginuser,comment);
        return "recordDetail";
    }

    @ResponseBody
    @PostMapping("/getRecordDetailByPage")
    public List<RecordDetail> getAllByPage(@RequestBody Map<String,Integer> map){
        Integer currentPage=map.get("currentPage");
        Integer pageSize=map.get("pageSize");
        Integer recordId=map.get("recordId");
       return recordDetailService.selectAllByPage(currentPage,pageSize,recordId);
    }

    @ResponseBody
    @GetMapping("/getRecordDetailCount")
    public Integer getCount(Integer pageSize,Integer recordId){
        return recordDetailService.getPageNum(pageSize,recordId);
    }
}

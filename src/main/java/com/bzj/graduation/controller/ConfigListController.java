package com.bzj.graduation.controller;

import com.bzj.graduation.bean.ConfigList;
import com.bzj.graduation.bean.Cpu;
import com.bzj.graduation.service.ConfigListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @Author:bai
 * @data:2019/3/13
 **/
@RestController
public class ConfigListController {
    @Autowired
    private ConfigList configList;

    @Autowired
    ConfigListService configListService;

    @PostMapping("/main/apis/core")
    public String Core(@ModelAttribute ConfigList configList,
                       Map<String,Object> map, HttpSession session){
        int userId=(int)session.getAttribute("userId");
        configList.setUserId(userId);
        Boolean iftrue=configListService.Core(configList,map);
        return "结果";
    }

    @GetMapping("...")
    public List getCPU(){
        List<Cpu> cpuLis=configListService
        return
    }
}

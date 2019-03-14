package com.bzj.graduation.controller;

import com.bzj.graduation.bean.ConfigList;
import com.bzj.graduation.service.CoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @Author:bai
 * @data:2019/3/13
 **/
@RestController
public class CoreController {
    @Autowired
    private ConfigList configList;

    @Autowired
    CoreService coreService;

    @PostMapping("/main/apis/core")
    public String Core(@ModelAttribute ConfigList configList,
                       Map<String,Object> map, HttpSession session){
        Boolean iftrue=coreService.Core(configList,map);
        return "结果";
    }
}

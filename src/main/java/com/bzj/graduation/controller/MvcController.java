package com.bzj.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:bai
 * @data:2019/3/7
 **/
@Controller
public class MvcController {
    @RequestMapping("/")
    public String Hello(){
        return "login";
    }
}
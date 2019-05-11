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

    @RequestMapping("/index")
    public String index(){
        return  "index";
    }

    @RequestMapping("/ziyuan")
    public String ziyuan(){
        return  "ziyuan";
    }

    @RequestMapping("/luntan")
    public String luntan(){
        return  "luntan";
    }

    @RequestMapping("/gerenzhongxin")
    public String gerenzhongxin(){
        return  "gerenzhongxin";
    }

    @RequestMapping("/regist")
    public String regist(){return "regist";}

    @RequestMapping("/recordDetail")
    public String recordDetail(){return "recordDetail";}

    @RequestMapping("/manager")
    public String manager(){
        return "indexManager";
    }

    @RequestMapping("/indexManager")
    public String manager2(){
        return "indexManager";
    }

    @RequestMapping("/luntanManager")
    public String luntan2(){
        return "luntanManager";
    }

    @RequestMapping("/resourceManager")
    public String resource(){
        return "resourceManager";
    }

    @RequestMapping("/configListManager")
    public String configList(){
        return "configListManager";
    }
}

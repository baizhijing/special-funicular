package com.bzj.graduation.controller;

import com.bzj.graduation.bean.*;
import com.bzj.graduation.service.ConfigListService;
import com.bzj.graduation.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private LoginService loginService;

    @Autowired
    ConfigListService configListService;


    @PostMapping("/main/apis/core")
    public String Core(@RequestBody Map<String,Object> map, HttpSession session){
        String username=(String)session.getAttribute("loginUser");
        configList.setUserId(loginService.getUserId(username));
        return configListService.Core(map,configList);
    }
/*
https://www.cnblogs.com/onetwo/p/7371778.html分页查询参考博客
 */
    @PostMapping("/allCpuByPage")
    public List<Cpu> getCPUPage(@RequestBody Map<String,Object> map){
        Integer currentPage=(Integer) map.get("currentPage");
        Integer pageSize=(Integer)map.get("pageSize");
        String type=(String)map.get("type");
        return configListService.getCPUList(currentPage,pageSize,type);
    }

    @GetMapping("/getCPUPageNum")
    public Integer getCPUPageNum(Integer pageSize,String type){
        return configListService.getCPUPage(pageSize,type);
    }

    @PostMapping("/allBoxByPage")
    public List<Box> getBoxPage(@RequestBody Map<String,Object> map){
        Integer currentPage=(Integer) map.get("currentPage");
        Integer pageSize=(Integer)map.get("pageSize");
        String type=(String)map.get("type");
        return configListService.getBoxList(currentPage,pageSize,type);
    }

    @GetMapping("/getBoxPageNum")
    public Integer getBoxPageNum(Integer pageSize,String type){
        return configListService.getBoxPage(pageSize,type);
    }

    @PostMapping("/allDisplayByPage")
    public List<Display> getDisplayPage(@RequestBody Map<String,Object> map){
        Integer currentPage=(Integer) map.get("currentPage");
        Integer pageSize=(Integer)map.get("pageSize");
        String type=(String)map.get("type");
        return configListService.getDisplayList(currentPage,pageSize,type);
    }

    @GetMapping("/getDisplayPageNum")
    public Integer getDisplayPageNum(Integer pageSize,String type){
        return configListService.getDisplayPage(pageSize,type);
    }

    @PostMapping("/allHardDriverByPage")
    public List<HardDisk> getHardDriverPage(@RequestBody Map<String,Object> map){
        Integer currentPage=(Integer) map.get("currentPage");
        Integer pageSize=(Integer)map.get("pageSize");
        String type=(String)map.get("type");
        return configListService.getHardDiskList(currentPage,pageSize,type);
    }

    @GetMapping("/getHardDiskPageNum")
    public Integer getHardDiskPageNum(Integer pageSize,String type){
        return configListService.getHardDiskPage(pageSize,type);
    }

    @PostMapping("/allMainBoardByPage")
    public List<MainBoard> getMainBoardPage(@RequestBody Map<String,Object> map){
        Integer currentPage=(Integer) map.get("currentPage");
        Integer pageSize=(Integer)map.get("pageSize");
        String type=(String)map.get("type");
        return configListService.getMainBoardList(currentPage,pageSize,type);
    }

    @GetMapping("/getMainBoardNum")
    public Integer getHardMainBoardNum(Integer pageSize,String type){
        return configListService.getMainBoardPage(pageSize,type);
    }

    @PostMapping("/allMemoryByPage")
    public List<Memory> getMemoryPage(@RequestBody Map<String,Object> map){
        Integer currentPage=(Integer) map.get("currentPage");
        Integer pageSize=(Integer)map.get("pageSize");
        String type=(String)map.get("type");
        return configListService.getMemoryList(currentPage,pageSize,type);
    }

    @GetMapping("/getMemoryNum")
    public Integer getMemoryNum(Integer pageSize,String type){
        return configListService.getMemoryPage(pageSize,type);
    }

    @PostMapping("/allPowerByPage")
    public List<Power> getPowerPage(@RequestBody Map<String,Object> map){
        Integer currentPage=(Integer) map.get("currentPage");
        Integer pageSize=(Integer)map.get("pageSize");
        String type=(String)map.get("type");
        return configListService.getPowerList(currentPage,pageSize,type);
    }

    @GetMapping("/getPowerNum")
    public Integer getPowerNum(Integer pageSize,String type){
        return configListService.getPowerPage(pageSize,type);
    }

    @PostMapping("/allRadiatorByPage")
    public List<Radiator> getRadiatorPage(@RequestBody Map<String,Object> map){
        Integer currentPage=(Integer) map.get("currentPage");
        Integer pageSize=(Integer)map.get("pageSize");
        String type=(String)map.get("type");
        return configListService.getRadiatorList(currentPage,pageSize,type);
    }

    @GetMapping("/getRadiatorNum")
    public Integer getRadiatorNum(Integer pageSize,String type){
        return configListService.getRadiatorPage(pageSize,type);
    }

    @PostMapping("/configlist/getList")
    public List<ConfigListDto> getConfigList(@RequestBody Map<String,Integer> map){
        Integer currentPage=map.get("currentPage");
        Integer pageSize=map.get("pageSize");
        Integer sortConfigList=map.get("sortConfigList");
        return  configListService.getConfigListByPage(currentPage,pageSize,sortConfigList);
    }

    @GetMapping("/configlist/getCount")
    public Integer getConfiglistCount(Integer pageSize){
        return configListService.getConfiglistPageNum(pageSize);
    }

//    私人配置单
    @PostMapping("/configlist/getPersonList")
    public List<ConfigListDto> getPersonConfigList(@RequestBody Map<String,Integer> map){
        Integer currentPage=map.get("currentPage");
        Integer pageSize=map.get("pageSize");
        Integer userId=map.get("userId");
        return  configListService.getPersonConfigListByPage(currentPage,pageSize,userId);
    }

    @GetMapping("/configlist/getPersonCount")
    public Integer getPersonConfiglistCount(Integer pageSize,Integer userId){
        return configListService.getPersonConfiglistPageNum(pageSize,userId);
    }

    @PostMapping("/submitConfigList")
    public void submitConfigList(@RequestBody Map<String,Integer> map,HttpSession session){
        Integer id=map.get("id");
        String name=(String)session.getAttribute("loginUser");
        configListService.submitConfigList(id,name);
    }
}

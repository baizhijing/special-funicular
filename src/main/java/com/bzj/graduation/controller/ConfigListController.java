package com.bzj.graduation.controller;

import com.bzj.graduation.bean.*;
import com.bzj.graduation.service.ConfigListService;
import org.springframework.beans.factory.annotation.Autowired;
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
    ConfigListService configListService;

    @PostMapping("/main/apis/core")
    public String Core(@ModelAttribute ConfigList configList,
                       Map<String,Object> map, HttpSession session){
        int userId=(int)session.getAttribute("userId");
        configList.setUserId(userId);
        Boolean iftrue=configListService.Core(configList,map);
        return "结果";
    }
/*
https://www.cnblogs.com/onetwo/p/7371778.html分页查询参考博客
 */
    @PostMapping("/allCpuByPage")
    public List<Cpu> getCPUPage(@RequestBody Map<String,Integer> map){
        Integer currentPage=map.get("currentPage");
        Integer pageSize=map.get("pageSize");
        return configListService.getCPUList(currentPage,pageSize);
    }

    @GetMapping("/getCPUPageNum")
    public Integer getCPUPageNum(Integer pageSize){
        return configListService.getCPUPage(pageSize);
    }

    @PostMapping("/allBoxByPage")
    public List<Box> getBoxPage(@RequestBody Map<String,Integer> map){
        Integer currentPage=map.get("currentPage");
        Integer pageSize=map.get("pageSize");
        return configListService.getBoxList(currentPage,pageSize);
    }

    @GetMapping("/getBoxPageNum")
    public Integer getBoxPageNum(Integer pageSize){
        return configListService.getBoxPage(pageSize);
    }

    @PostMapping("/allDisplayByPage")
    public List<Display> getDisplayPage(@RequestBody Map<String,Integer> map){
        Integer currentPage=map.get("currentPage");
        Integer pageSize=map.get("pageSize");
        return configListService.getDisplayList(currentPage,pageSize);
    }

    @GetMapping("/getDisplayPageNum")
    public Integer getDisplayPageNum(Integer pageSize){
        return configListService.getDisplayPage(pageSize);
    }

    @PostMapping("/allHardDriverByPage")
    public List<HardDisk> getHardDriverPage(@RequestBody Map<String,Integer> map){
        Integer currentPage=map.get("currentPage");
        Integer pageSize=map.get("pageSize");
        return configListService.getHardDiskList(currentPage,pageSize);
    }

    @GetMapping("/getHardDiskPageNum")
    public Integer getHardDiskPageNum(Integer pageSize){
        return configListService.getHardDiskPage(pageSize);
    }

    @PostMapping("/allMainBoardByPage")
    public List<MainBoard> getMainBoardPage(@RequestBody Map<String,Integer> map){
        Integer currentPage=map.get("currentPage");
        Integer pageSize=map.get("pageSize");
        return configListService.getMainBoardList(currentPage,pageSize);
    }

    @GetMapping("/getMainBoardNum")
    public Integer getHardMainBoardNum(Integer pageSize){
        return configListService.getMainBoardPage(pageSize);
    }

    @PostMapping("/allMemoryByPage")
    public List<Memory> getMemoryPage(@RequestBody Map<String,Integer> map){
        Integer currentPage=map.get("currentPage");
        Integer pageSize=map.get("pageSize");
        return configListService.getMemoryList(currentPage,pageSize);
    }

    @GetMapping("/getMemoryNum")
    public Integer getMemoryNum(Integer pageSize){
        return configListService.getMemoryPage(pageSize);
    }

    @PostMapping("/allPowerByPage")
    public List<Power> getPowerPage(@RequestBody Map<String,Integer> map){
        Integer currentPage=map.get("currentPage");
        Integer pageSize=map.get("pageSize");
        return configListService.getPowerList(currentPage,pageSize);
    }

    @GetMapping("/getPowerNum")
    public Integer getPowerNum(Integer pageSize){
        return configListService.getPowerPage(pageSize);
    }

    @PostMapping("/allRadiatorByPage")
    public List<Radiator> getRadiatorPage(@RequestBody Map<String,Integer> map){
        Integer currentPage=map.get("currentPage");
        Integer pageSize=map.get("pageSize");
        return configListService.getRadiatorList(currentPage,pageSize);
    }

    @GetMapping("/getRadiatorNum")
    public Integer getRadiatorNum(Integer pageSize){
        return configListService.getRadiatorPage(pageSize);
    }

    @PostMapping("/configlist/getList")
    public List<ConfigListDto> getConfigList(@RequestBody Map<String,Integer> map){
        Integer currentPage=map.get("currentPage");
        Integer pageSize=map.get("pageSize");
        return  configListService.getConfigListByPage(currentPage,pageSize);
    }

    @GetMapping("/configlist/getCount")
    public Integer getConfiglistCount(Integer pageSize){
        return configListService.getConfiglistPageNum(pageSize);
    }


}

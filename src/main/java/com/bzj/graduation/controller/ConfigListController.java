package com.bzj.graduation.controller;

import com.bzj.graduation.bean.*;
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
/*
https://www.cnblogs.com/onetwo/p/7371778.html分页查询参考博客
 */
    @PostMapping("/allCpuByPage")
    public List<Cpu> getCPUPage(Integer currentPage,Integer pageSize){
        return configListService.getCPUList(currentPage,pageSize);
    }

    @GetMapping("/getCPUPageNum")
    public Integer getCPUPageNum(Integer pageSize){
        return configListService.getCPUPage(pageSize);
    }

    @PostMapping("/allBoxByPage")
    public List<Box> getBoxPage(Integer currentPage, Integer pageSize){
        return configListService.getBoxList(currentPage,pageSize);
    }

    @GetMapping("/getBoxPageNum")
    public Integer getBoxPageNum(Integer pageSize){
        return configListService.getBoxPage(pageSize);
    }

    @PostMapping("/allDisplayByPage")
    public List<Display> getDisplayPage(Integer currentPage, Integer pageSize){
        return configListService.getDisplayList(currentPage,pageSize);
    }

    @GetMapping("/getDisplayPageNum")
    public Integer getDisplayPageNum(Integer pageSize){
        return configListService.getDisplayPage(pageSize);
    }

    @PostMapping("/allHardDriverByPage")
    public List<HardDisk> getHardDriverPage(Integer currentPage, Integer pageSize){
        return configListService.getHardDiskList(currentPage,pageSize);
    }

    @GetMapping("/getHardDiskPageNum")
    public Integer getHardDiskPageNum(Integer pageSize){
        return configListService.getHardDiskPage(pageSize);
    }

    @PostMapping("/allMainBoardByPage")
    public List<MainBoard> getMainBoardPage(Integer currentPage, Integer pageSize){
        return configListService.getMainBoardList(currentPage,pageSize);
    }

    @GetMapping("/getMainBoardNum")
    public Integer getHardMainBoardNum(Integer pageSize){
        return configListService.getMainBoardPage(pageSize);
    }

    @PostMapping("/allMemoryByPage")
    public List<Memory> getMemoryPage(Integer currentPage, Integer pageSize){
        return configListService.getMemoryList(currentPage,pageSize);
    }

    @GetMapping("/getMemoryNum")
    public Integer getMemoryNum(Integer pageSize){
        return configListService.getMemoryPage(pageSize);
    }

    @PostMapping("/allPowerByPage")
    public List<Power> getPowerPage(Integer currentPage, Integer pageSize){
        return configListService.getPowerList(currentPage,pageSize);
    }

    @GetMapping("/getPowerNum")
    public Integer getPowerNum(Integer pageSize){
        return configListService.getPowerPage(pageSize);
    }

    @PostMapping("/allRadiatorByPage")
    public List<Radiator> getRadiatorPage(Integer currentPage, Integer pageSize){
        return configListService.getRadiatorList(currentPage,pageSize);
    }

    @GetMapping("/getRadiatorNum")
    public Integer getRadiatorNum(Integer pageSize){
        return configListService.getRadiatorPage(pageSize);
    }

//    @PostMapping("/allRadiatorByPage")
//    public List<Radiator> getRadiatorPage(Integer currentPage, Integer pageSize){
//        return configListService.getRadiatorList(currentPage,pageSize);
//    }
//
//    @GetMapping("/getRadiatorNum")
//    public Integer getRadiatorNum(Integer pageSize){
//        return configListService.getRadiatorPage(pageSize);
//    }



}

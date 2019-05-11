package com.bzj.graduation.controller;

import com.bzj.graduation.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DownloadController {
    @Autowired
    private DownloadService downloadService;

    @RequestMapping("/resource/list")
    public List getList(@RequestBody Map<String, Object> map){
        Integer currentPage=(Integer) map.get("currentPage");
        Integer pageSize=(Integer) map.get("pageSize");
        String type=(String) map.get("type");
        return downloadService.getAll(currentPage,pageSize,type);
    }

//    @RequestMapping("/resource/listByType")
//    public List getListByType(@RequestBody Map<String, Object> map){
//        Integer currentPage=(Integer) map.get("currentPage");
//        Integer pageSize=(Integer) map.get("pageSize");
//        String type=(String)map.get("type");
//        return downloadService.getAllByType(currentPage,pageSize,type);
//    }

    @RequestMapping("/resource/getAllCount")
    public Integer getAllCount(Integer pageSize,String type)
    {
        return downloadService.getAllCount(pageSize,type);
    }
//
//    @RequestMapping("/resource/getCountByType")
//    public Integer getCountByType(String type,Integer pageSize){
//        return downloadService.getCountByType(type,pageSize);
//    }

}

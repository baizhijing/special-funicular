package com.bzj.graduation.dao;

import com.bzj.graduation.bean.ConfigList;
import com.bzj.graduation.bean.PageBean;
import com.bzj.graduation.mapper.ConfigListMapper;
import com.bzj.graduation.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:bai
 * @data:2019/3/15
 **/
@Repository
public class ConfigListDao {
    @Autowired
    private ConfigListMapper configListMapper;

    public boolean insertList(ConfigList configList){
        Integer cpuId=configList.getCpuId();
        Integer userId=configList.getUserId();
        Integer hardDiskId=configList.getHardDiskId();
        Integer radiatorId=configList.getRadiatorId();
        Integer boxId=configList.getBoxId();
        Integer powerId=configList.getPowerId();
        Integer memoryId=configList.getMemoryId();
        Integer mainBoardId=configList.getMainBoardId();
        String name="peizhi1";
        String cpuName=configList.getCpuName();
        String hardDiskName=configList.getHardDiskName();
        String radiatorName=configList.getRadiatorName();
        String boxName=configList.getBoxName();
        String powerName=configList.getPowerName();
        String memoryName=configList.getMemoryName();
        String mainBoardName=configList.getMainBoardName();
        Integer displayId=configList.getDisplayId();
        String displayName=configList.getDisplayName();
        Integer isPublic=0;
        configListMapper.InsertList(cpuId,userId,hardDiskId,radiatorId,boxId,powerId,memoryId,mainBoardId,
                name,cpuName,hardDiskName,radiatorName,boxName,powerName,memoryName,mainBoardName,displayId,displayName,isPublic);
        return true;
    }

    public List<ConfigList> selectConfigListByPage(int currentPage, int pageSize){
        PageHelper.startPage(currentPage, pageSize);
        List<ConfigList> allConfigLists = configListMapper.getAll();        //全部商品
        int countNums = configListMapper.getCount();            //总记录数
        PageBean<ConfigList> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allConfigLists);
        return pageData.getItems();
    }
//私人配置单
    public List<ConfigList> selectPersonConfigListByPage(int currentPage, int pageSize,Integer userId){
        PageHelper.startPage(currentPage, pageSize);
        List<ConfigList> allConfigLists = configListMapper.selectByUserId(userId);        //全部商品
        int countNums = configListMapper.getPersonCount(userId);            //总记录数
        PageBean<ConfigList> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allConfigLists);
        return pageData.getItems();
    }

    public Integer getCount(){
        return configListMapper.getCount();
    }

    public Integer getPersonCount(Integer userId){
        return configListMapper.getPersonCount(userId);
    }
}

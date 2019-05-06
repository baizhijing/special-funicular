package com.bzj.graduation.dao;

import com.bzj.graduation.bean.Cpu;
import com.bzj.graduation.bean.PageBean;
import com.bzj.graduation.bean.Resource;
import com.bzj.graduation.mapper.DownloadMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DownloadDao {
    @Autowired
    private DownloadMapper downloadMapper;

    public List<Resource> selectResourceByPage(int currentPage, int pageSize,String type){
        PageHelper.startPage(currentPage, pageSize);
        List<Resource> allResources;
        int countNums;
        if (type==null){
            allResources =downloadMapper.getAll();       //全部商品
            countNums = downloadMapper.getAllCount();            //总记录数
        }
        else {
            allResources=downloadMapper.selectByType(type);
            countNums=downloadMapper.selectCountByType(type);
        }
        PageBean<Resource> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allResources);
        return pageData.getItems();
    }

//    public List<Resource> selectResourceTypeByPage(int currentPage, int pageSize,String type){
//        PageHelper.startPage(currentPage, pageSize);
//        List<Resource> allResources =downloadMapper.getListByType(type);       //全部商品
//        int countNums = downloadMapper.getCountByType(type);            //总记录数
//        PageBean<Resource> pageData = new PageBean<>(currentPage, pageSize, countNums);
//        pageData.setItems(allResources);
//        return pageData.getItems();
//    }

    public Integer getAllCount(String type){
        if (type==null)
        return downloadMapper.getAllCount();
        else
            return downloadMapper.selectCountByType(type);
    }

//    public Integer getCountByType(String type){
//        return downloadMapper.selectCountByType(type);
//    }
}

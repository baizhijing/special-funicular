package com.bzj.graduation.dao;

import com.bzj.graduation.bean.Display;
import com.bzj.graduation.bean.HardDisk;
import com.bzj.graduation.bean.PageBean;
import com.bzj.graduation.mapper.HardDiskMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HardDiskDao {
    @Autowired
    private HardDiskMapper hardDiskMapper;

    public String getInterfById(int id){
        return hardDiskMapper.selectInterfById(id);
    }

    public List selectHardDiskByPage(int currentPage, int pageSize){
        PageHelper.startPage(currentPage, pageSize);
        List<HardDisk> allHardDisk = hardDiskMapper.getAll();        //全部商品
        int countNums = hardDiskMapper.getCount();            //总记录数
        PageBean<HardDisk> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allHardDisk);
        return pageData.getItems();
    }

    public Integer getCount(){
        return hardDiskMapper.getCount();
    }
}

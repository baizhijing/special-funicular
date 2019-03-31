package com.bzj.graduation.dao;

import com.bzj.graduation.bean.Cpu;
import com.bzj.graduation.bean.Display;
import com.bzj.graduation.bean.PageBean;
import com.bzj.graduation.mapper.DisplayMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DisplayDao {
    @Autowired
    private DisplayMapper displayMapper;

    public int getPowerById(int id){
        return displayMapper.selectPowerById(id);
    }

    public double getLengthById(int id){
        return displayMapper.selectLengthById(id);
    }

    public List selectDisplayByPage(int currentPage, int pageSize){
        PageHelper.startPage(currentPage, pageSize);
        List<Display> allDisplays = displayMapper.getAll();        //全部商品
        int countNums = displayMapper.getCount();            //总记录数
        PageBean<Display> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allDisplays);
        return pageData.getItems();
    }

    public int getCount(){
        return displayMapper.getCount();
    }
}

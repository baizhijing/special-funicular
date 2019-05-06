package com.bzj.graduation.dao;

import com.bzj.graduation.bean.MainBoard;
import com.bzj.graduation.bean.Memory;
import com.bzj.graduation.bean.PageBean;
import com.bzj.graduation.mapper.MemoryMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class MemoryDao {

    @Autowired
    private MemoryMapper memoryMapper;

    public String getMemoryTypeById(int id){
        return memoryMapper.selectMemoryTypeById(id);
    }

    //分页查询
    public List selectMemoryByPage(int currentPage, int pageSize,String type){
        List<Memory> allMemory;
        int countNums;
        PageHelper.startPage(currentPage, pageSize);
        if (type==null){
             allMemory= memoryMapper.getAll();        //全部商品
            countNums= memoryMapper.getCount();            //总记录数
        }
        else {
            allMemory=memoryMapper.selectAllByType(type);
            countNums=memoryMapper.countByType(type);
        }
        PageBean<Memory> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allMemory);
        return pageData.getItems();
    }

    public Integer getCount(String type){
        if (type==null)
        return memoryMapper.getCount();
        else
            return memoryMapper.countByType(type);
    }

    public Double getPriceById(Integer id){
        return memoryMapper.selectPriceById(id);
    }
}

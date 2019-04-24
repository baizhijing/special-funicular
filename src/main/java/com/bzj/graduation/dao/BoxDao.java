package com.bzj.graduation.dao;

import com.bzj.graduation.bean.Box;
import com.bzj.graduation.bean.PageBean;
import com.bzj.graduation.mapper.BoxMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class BoxDao {
    @Autowired
    private BoxMapper boxMapper;

    public List<Box> selectBoxByPage(int currentPage, int pageSize){
        PageHelper.startPage(currentPage, pageSize);
        List<Box> allBoxs = boxMapper.selectAll();        //全部商品
        int countNums = boxMapper.countBoxs();            //总记录数
        PageBean<Box> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allBoxs);
        return pageData.getItems();
    }

    public Integer getCount(){
        return boxMapper.countBoxs();
    }

    public Integer getDisplayCardById(int id){
        return boxMapper.selectDisplayCardById(id);
    }

    public Double getRadiatorById(int id){
        return  boxMapper.selectRadiatorById(id);
    }

    public String getTypeById(int id){
        return boxMapper.selectTypeById(id);
    }

    public Double getPriceById(Integer id){
        return boxMapper.selectPriceById(id);
    }
}

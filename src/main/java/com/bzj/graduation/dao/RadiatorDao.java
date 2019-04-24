package com.bzj.graduation.dao;

import com.bzj.graduation.bean.PageBean;
import com.bzj.graduation.bean.Power;
import com.bzj.graduation.bean.Radiator;
import com.bzj.graduation.mapper.RadiatorMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class RadiatorDao {
    @Autowired
    private RadiatorMapper radiatorMapper;

    public String getInterfById(int id){
        return radiatorMapper.selectInterfById(id);
    }

    public double getHighById(int id){
        return  radiatorMapper.selectHighById(id);
    }

    //分页查询
    public List selectRadiatorByPage(Integer currentPage, Integer pageSize){
        PageHelper.startPage(currentPage, pageSize);
        List<Radiator> allRadiator = radiatorMapper.getAll();        //全部商品
        int countNums = radiatorMapper.getCount();            //总记录数
        PageBean<Radiator> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allRadiator);
        return pageData.getItems();
    }

    public Integer getCount(){
        return radiatorMapper.getCount();
    }

    public Double getPriceById(Integer id){
        return radiatorMapper.selectPriceById(id);
    }
}

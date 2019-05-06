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
    public List selectRadiatorByPage(Integer currentPage, Integer pageSize,String type){
        PageHelper.startPage(currentPage, pageSize);
        List<Radiator> allRadiator;
        int countNums;
        if (type==null){
            allRadiator = radiatorMapper.getAll();        //全部商品
            countNums = radiatorMapper.getCount();            //总记录数
        }
        else{
            allRadiator=radiatorMapper.selectAllByType(type);
            countNums=radiatorMapper.countByType(type);
        }
        PageBean<Radiator> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allRadiator);
        return pageData.getItems();
    }

    public Integer getCount(String type){
        if (type==null)
        return radiatorMapper.getCount();
        else
            return radiatorMapper.countByType(type);
    }

    public Double getPriceById(Integer id){
        return radiatorMapper.selectPriceById(id);
    }
}

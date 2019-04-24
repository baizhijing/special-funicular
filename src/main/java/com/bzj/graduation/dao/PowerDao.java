package com.bzj.graduation.dao;

import com.bzj.graduation.bean.Memory;
import com.bzj.graduation.bean.PageBean;
import com.bzj.graduation.bean.Power;
import com.bzj.graduation.mapper.PowerMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class PowerDao {
    @Autowired
    private PowerMapper powerMapper;

    public int getNumById(int id){
        return powerMapper.selectNumById(id);
    }

    //分页查询
    public List selectPowerByPage(int currentPage, int pageSize){
        PageHelper.startPage(currentPage, pageSize);
        List<Power> allPower = powerMapper.getAll();        //全部商品
        int countNums = powerMapper.getCount();            //总记录数
        PageBean<Power> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allPower);
        return pageData.getItems();
    }

    public Integer getCount(){
        return powerMapper.getCount();
    }

    public Double getPriceById(Integer id){
        return powerMapper.selectPriceById(id);
    }
}

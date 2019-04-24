package com.bzj.graduation.dao;


import com.bzj.graduation.bean.Cpu;
import com.bzj.graduation.bean.PageBean;
import com.bzj.graduation.mapper.CpuMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class CpuDao {
    @Autowired
    private CpuMapper cpuMapper;

    public List<Cpu> selectCpuByPage(int currentPage,int pageSize){
        PageHelper.startPage(currentPage, pageSize);
        List<Cpu> allCpus = cpuMapper.selectAll();        //全部商品
        int countNums = cpuMapper.countCpus();            //总记录数
        PageBean<Cpu> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allCpus);
        return pageData.getItems();
    }

    public String getInterfById(Integer id){
        return cpuMapper.selectInterfById(id);
    }

    public Integer getPowerById(Integer id){
        return cpuMapper.selectPowerById(id);
    }

    public String getGpuById(Integer id){
        return cpuMapper.selectGpuById(id);
    }

    public List selectAll(){
        return cpuMapper.selectAll();
    }

    public int selectCount(){
        return cpuMapper.selectCount();
    }

    public Double getPriceById(Integer id){
        return cpuMapper.selectPriceById(id);
    }
}

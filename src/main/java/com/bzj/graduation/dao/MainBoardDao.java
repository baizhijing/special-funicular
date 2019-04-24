package com.bzj.graduation.dao;

import com.bzj.graduation.bean.HardDisk;
import com.bzj.graduation.bean.MainBoard;
import com.bzj.graduation.bean.PageBean;
import com.bzj.graduation.mapper.MainBoardMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class MainBoardDao {
    @Autowired
    private MainBoardMapper mainBoardMapper;

    public String getInterfById(int id){
        return mainBoardMapper.selectIntefById(id);
    }

    public String getMemoryTypeById(int id){
        return mainBoardMapper.selectMemoryTypeById(id);
    }

    public int getM2ById(int id){
        return mainBoardMapper.selectM2ById(id);
    }

    public String getTypeById(int id){ return mainBoardMapper.selectTypeById(id);}

    //分页查询
    public List selectMainBoardByPage(int currentPage, int pageSize){
        PageHelper.startPage(currentPage, pageSize);
        List<MainBoard> allMainBoard = mainBoardMapper.getAll();        //全部商品
        int countNums = mainBoardMapper.getCount();            //总记录数
        PageBean<MainBoard> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allMainBoard);
        return pageData.getItems();
    }

    public Integer getCount(){
        return mainBoardMapper.getCount();
    }

    public Double getPriceById(Integer id){
        return mainBoardMapper.selectPriceById(id);
    }
}

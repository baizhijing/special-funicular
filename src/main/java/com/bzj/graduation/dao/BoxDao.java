package com.bzj.graduation.dao;

import com.bzj.graduation.mapper.BoxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoxDao {
    @Autowired
    private BoxMapper boxMapper;

    public Integer getDisplayCardById(int id){
        return boxMapper.selectDisplayCardById(id);
    }

    public Double getRadiatorById(int id){
        return  boxMapper.selectRadiatorById(id);
    }

    public String getTypeById(int id){
        return boxMapper.selectTypeById(id);
    }
}

package com.bzj.graduation.dao;

import com.bzj.graduation.mapper.RadiatorMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RadiatorDao {
    private RadiatorMapper radiatorMapper;

    public String getInterfById(int id){
        return radiatorMapper.selectInterfById(id);
    }

    public double getHighById(int id){
        return  radiatorMapper.selectHighById(id);
    }
}

package com.bzj.graduation.dao;

import com.bzj.graduation.mapper.DisplayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}

package com.bzj.graduation.dao;

import com.bzj.graduation.mapper.PowerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PowerDao {
    @Autowired
    private PowerMapper powerMapper;

    public int getNumById(int id){
        return powerMapper.selectNumById(id);
    }
}

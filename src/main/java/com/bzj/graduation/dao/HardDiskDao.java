package com.bzj.graduation.dao;

import com.bzj.graduation.mapper.HardDiskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HardDiskDao {
    @Autowired
    private HardDiskMapper hardDiskMapper;

    public String getInterfById(int id){
        return hardDiskMapper.selectInterfById(id);
    }
}

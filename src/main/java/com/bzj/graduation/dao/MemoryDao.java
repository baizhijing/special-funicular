package com.bzj.graduation.dao;

import com.bzj.graduation.mapper.MemoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryDao {

    @Autowired
    private MemoryMapper memoryMapper;

    public String getMemoryTypeById(int id){
        return memoryMapper.selectMemoryTypeById(id);
    }
}

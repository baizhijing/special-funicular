package com.bzj.graduation.dao;


import com.bzj.graduation.mapper.CpuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CpuDao {
    @Autowired
    private CpuMapper cpuMapper;

    public String getInterfById(Integer id){
        return cpuMapper.selectInterfById(id);
    }

    public Integer getPowerById(Integer id){
        return cpuMapper.selectPowerById(id);
    }

    public String getGpuById(Integer id){
        return cpuMapper.selectGpuById(id);
    }


}

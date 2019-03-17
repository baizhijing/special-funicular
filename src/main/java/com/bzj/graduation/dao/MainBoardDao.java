package com.bzj.graduation.dao;

import com.bzj.graduation.mapper.MainBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}

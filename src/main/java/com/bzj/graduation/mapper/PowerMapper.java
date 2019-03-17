package com.bzj.graduation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PowerMapper {

    @Select("")
    public int selectNumById(int id);
}

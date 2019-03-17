package com.bzj.graduation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RadiatorMapper {
    @Select("select ")
    public String selectInterfById(int id);

    @Select("")
    double selectHighById(int id);
}

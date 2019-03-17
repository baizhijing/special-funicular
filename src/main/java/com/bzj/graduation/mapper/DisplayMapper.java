package com.bzj.graduation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DisplayMapper {
    @Select("")
    public int selectPowerById(int id);

    @Select("")
    double selectLengthById(int id);
}

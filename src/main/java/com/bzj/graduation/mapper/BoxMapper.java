package com.bzj.graduation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BoxMapper {
    @Select("")
    Integer selectDisplayCardById(int id);

    @Select("")
    double selectRadiatorById(int id);

    @Select("")
    String selectTypeById(int id);
}

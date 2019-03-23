package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.Box;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoxMapper {
    @Select("")
    Integer selectDisplayCardById(int id);

    @Select("")
    double selectRadiatorById(int id);

    @Select("")
    String selectTypeById(int id);

    @Select("select * from box")
    List<Box> selectAll();

    @Select("select count(*) from box")
    int countBoxs();
}

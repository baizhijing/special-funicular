package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.Box;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoxMapper {
    @Select("select displayCard from box where id =#{id}")
    Integer selectDisplayCardById(int id);

    @Select("select radiator from box where id =#{id}")
    double selectRadiatorById(int id);

    @Select("select type from box where id =#{id}")
    String selectTypeById(int id);

    @Select("select * from box")
    List<Box> selectAll();

    @Select("select count(*) from box")
    int countBoxs();
}

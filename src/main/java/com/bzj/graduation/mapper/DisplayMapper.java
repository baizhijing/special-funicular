package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.Display;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DisplayMapper {
    @Select("select power from displaycard where id=#{id}")
    int selectPowerById(int id);

    @Select("select length from displaycard where id={id}")
    double selectLengthById(int id);

    @Select("select * from displaycard")
    List<Display> getAll();

    @Select("select count(*) from displaycard")
    int getCount();
}

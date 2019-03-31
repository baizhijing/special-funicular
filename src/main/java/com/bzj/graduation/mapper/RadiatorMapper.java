package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.Radiator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RadiatorMapper {
    @Select("select interf from radiator where id=#{id}")
    String selectInterfById(int id);

    @Select("select hign from radiator where id=#{id}")
    double selectHighById(int id);

    @Select("select count(*) from radiator")
    int getCount();

    @Select("select * from radiator")
    List<Radiator> getAll();
}

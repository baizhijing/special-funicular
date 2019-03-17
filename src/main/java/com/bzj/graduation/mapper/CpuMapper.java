package com.bzj.graduation.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CpuMapper {

    @Select("select Interf from cpu where id=#{id}")
    String selectInterfById(Integer id);

    @Select("select")
    int selectPowerById(Integer id);

    @Select("")
    String selectGpuById(Integer id);
}

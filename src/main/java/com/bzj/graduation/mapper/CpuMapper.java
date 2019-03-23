package com.bzj.graduation.mapper;


import com.bzj.graduation.bean.Cpu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CpuMapper {


    @Select("select Interf from cpu where id=#{id}")
    String selectInterfById(Integer id);

    @Select("select")
    int selectPowerById(Integer id);

    @Select("select count(*) from cpu")
    int countCpus();

    @Select("select")
    String selectGpuById(Integer id);

    @Select("select * from cpu")
    List<Cpu> selectAll();
}

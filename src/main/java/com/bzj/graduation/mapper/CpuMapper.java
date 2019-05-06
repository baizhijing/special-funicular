package com.bzj.graduation.mapper;


import com.bzj.graduation.bean.Cpu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface CpuMapper {


    @Select("select interf from cpu where id=#{id}")
    String selectInterfById(Integer id);

    @Select("select power from cpu where id=#{id}")
    int selectPowerById(Integer id);

    @Select("select count(*) from cpu")
    int countCpus();

    @Select("select GPU from cpu where id=#{id}")
    String selectGpuById(Integer id);

    @Select("select * from cpu")
    List<Cpu> selectAll();

    @Select("select * from cpu where name like CONCAT('%',#{type},'%')")
    List<Cpu> selectByType(String type);

    @Select("select count(*) from cpu")
    int selectCount();

    @Select("select count(*) from cpu where name like CONCAT('%',#{type},'%')")
    int selectCountByType(String type);

    @Select("select price from cpu where id=#{id}")
    Double selectPriceById(Integer id);
}

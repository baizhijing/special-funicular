package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.Power;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface PowerMapper {

    @Select("select num from power where id=#{id}")
    int selectNumById(int id);

    @Select("select * from power")
    List<Power> getAll();

    @Select("select * from power where name like CONCAT('%',#{type},'%')")
    List<Power> selectAllByType(String type);

    @Select("select count(*) from power")
    int getCount();

    @Select("select count(*) from power where name like CONCAT('%',#{type},'%')")
    int countByType(String type);

    @Select("select price from power where id=#{id}")
    Double selectPriceById(Integer id);
}

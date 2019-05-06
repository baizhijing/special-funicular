package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.Box;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
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

    @Select("select * from box where name like CONCAT('%',#{type},'%')")
    List<Box> selectAllByType(String type);

    @Select("select count(*) from box")
    int countBoxs();

    @Select("select count(*) from box where name like CONCAT('%',#{type},'%')")
    int countBoxsByType(String type);

    @Select("select price from box where id=#{id}")
    Double selectPriceById(Integer id);
}

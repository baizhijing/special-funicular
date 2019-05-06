package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.Radiator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface RadiatorMapper {
    @Select("select interf from radiator where id=#{id}")
    String selectInterfById(int id);

    @Select("select high from radiator where id=#{id}")
    double selectHighById(int id);

    @Select("select count(*) from radiator")
    int getCount();

    @Select("select count(*) from radiator where name like CONCAT('%',#{type},'%')")
    int countByType(String type);

    @Select("select * from radiator")
    List<Radiator> getAll();

    @Select("select * from radiator where name like CONCAT('%',#{type},'%')")
    List<Radiator> selectAllByType(String type);

    @Select("select price from radiator where id=#{id}")
    Double selectPriceById(Integer id);
}

package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.HardDisk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface HardDiskMapper {

    @Select("select interf from harddisk where id=#{id}")
    String selectInterfById(int id);

    @Select("select * from harddisk")
    List<HardDisk> getAll();

    @Select("select * from harddisk where name like CONCAT('%',#{type},'%')")
    List<HardDisk> selectAllByType(String type);

    @Select("select count(*) from harddisk")
    int getCount();

    @Select("select count(*) from harddisk where name like CONCAT('%',#{type},'%')")
    int countByType(String type);

    @Select("select price from harddisk where id=#{id}")
    Double selectPriceById(Integer id);
}

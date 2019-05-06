package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.Memory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface MemoryMapper {
    @Select("select memoryType from memory where id=#{id}")
    String selectMemoryTypeById(int id);

    @Select("select count(*) from memory")
    int getCount();

    @Select("select count(*) from memory where name like CONCAT('%',#{type},'%')")
    int countByType(String type);

    @Select("select * from memory")
    List<Memory> getAll();

    @Select("select * from memory where name like CONCAT('%',#{type},'%')")
    List<Memory> selectAllByType(String type);

    @Select("select price from memory where id=#{id}")
    Double selectPriceById(Integer id);
}

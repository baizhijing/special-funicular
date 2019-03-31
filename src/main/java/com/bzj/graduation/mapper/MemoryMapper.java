package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.Memory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemoryMapper {
    @Select("select memory_type from memory where id=#{id}")
    String selectMemoryTypeById(int id);

    @Select("select count(*) from memory")
    int getCount();

    @Select("select * from memory")
    List<Memory> getAll();
}

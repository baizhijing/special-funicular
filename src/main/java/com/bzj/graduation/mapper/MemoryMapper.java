package com.bzj.graduation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemoryMapper {
    @Select("")
    public String selectMemoryTypeById(int id);
}

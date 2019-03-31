package com.bzj.graduation.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecordMapper {
    @Insert("insert into record values(0,#{userId},#{title},#{content})")
    void InsertRecord(Integer userId,String title,String content);
}

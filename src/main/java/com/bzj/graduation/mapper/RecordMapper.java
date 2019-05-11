package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.Record;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RecordMapper {
    @Insert("insert into record values(0,#{userName},#{title},#{content},#{content1})")
    void InsertRecord(String userName,String title,String content,String content1);

    @Delete("delete from record where id=#{id}")
    void delRecord(Integer id);

    //全部帖子
    @Select("select * from record")
    List<Record> selectAll();

    @Select("select count(*) from record")
    Integer getCount();

    //个人帖子
    @Select("select * from record where userName=#{userName}")
    List<Record> getPerosonRecord(String userName);

    @Select("select count(*) from record where userName=#{userName}")
    Integer getPerosonRecordCount(String userName);

    @Select("select max(id) from record")
    Integer selectMaxId();
}

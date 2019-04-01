package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.Record;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecordMapper {
    @Insert("insert into record values(0,#{userId},#{title},#{content})")
    void InsertRecord(Integer userId,String title,String content);

    @Delete("delete from record where id=#{id}")
    void delRecord(Integer id);

    //全部帖子
    @Select("select * from record")
    List<Record> selectAll();

    @Select("select count(*) from record")
    Integer getCount();


    //个人帖子
    @Select("select create_id from record where id=#{id}")
    List<Record> getPerosonRecord(Integer id);

    @Select("select count(*)from record where createId=#{createId}")
    Integer getPerosonRecordCount(Integer createId);
}

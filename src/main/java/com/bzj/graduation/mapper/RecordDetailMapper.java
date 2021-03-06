package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.RecordDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:bai
 * @data:2019/4/1
 **/
@Mapper
public interface RecordDetailMapper {
    @Insert("insert into record_detail values(0,#{recordId},#{username},#{time},#{comment},#{userId})")
    void insertRecordDeatil(int recordId,String username,Integer userId,String comment,String time);

    @Select("select * from record_detail where recordId=#{recordId}")
    List<RecordDetail> selectAll(Integer recordId);

    @Select("select count(*) from record_detail where recordId=#{recordId}")
    Integer getCount(Integer recordId);
}

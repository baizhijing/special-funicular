package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.ConfigList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author:bai
 * @data:2019/3/15
 **/
@Mapper
public interface ConfigListMapper {
//    @Insert("insert into configlist values(0,'自定义',#{},#{}")
//    void InsertList(@PathVariable ConfigList configList);

    @Select("select * from configlist")
    List<ConfigList> getAll();

    @Select("select count(*) from configlist")
    int getCount();

    @Select("select * from configlist where userId=#{userId}")
    List<ConfigList> selectByUserId(Integer userId);

    @Select("select count(*) from configlist where userId=#{userId}")
    Integer getPersonCount(Integer userId);
}

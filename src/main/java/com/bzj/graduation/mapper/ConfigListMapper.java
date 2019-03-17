package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.ConfigList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author:bai
 * @data:2019/3/15
 **/
@Mapper
public interface ConfigListMapper {
    @Insert("insert into configlist values(0,'自定义',#{用户ID？？？},#{}")
    void InsertList(@PathVariable ConfigList configList);
}

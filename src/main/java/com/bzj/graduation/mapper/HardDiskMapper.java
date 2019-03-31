package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.HardDisk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HardDiskMapper {

    @Select("select interf from hard_disk where id=#{id}")
    String selectInterfById(int id);

    @Select("select * from harddisk")
    List<HardDisk> getAll();

    @Select("select count(*) from harddisk")
    int getCount();
}

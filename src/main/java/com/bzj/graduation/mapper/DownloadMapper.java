package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface DownloadMapper {

    @Select("select * from resource")
    List<Resource> getAll();

    @Select("select * from resource where type=#{type}")
    List<Resource> getListByType(String type);

    @Select("select count(*) from resource")
    Integer getAllCount();

    @Select("select count(*) from resource where type=#{type}")
    Integer getCountByType(String type);
}

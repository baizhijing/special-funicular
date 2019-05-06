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
    @Insert("insert into configlist values(0,#{userId},#{cpuId},#{hardDiskId},#{radiatorId},#{boxId},#{powerId},#{memoryId},#{mainBoardId},#{name},#{cpuName},#{hardDiskName},#{radiatorName},#{boxName},#{powerName},#{memoryName},#{mainBoardName},#{displayId},#{displayName},#{isPublic})")
    void InsertList(Integer cpuId,Integer userId,Integer hardDiskId,Integer radiatorId,Integer boxId,Integer powerId,Integer memoryId,Integer mainBoardId,
                    String name,String cpuName,String hardDiskName,String radiatorName,String boxName,String powerName,String memoryName,String mainBoardName,
                    Integer displayId,String displayName,Integer isPublic);
    @Select("select * from configlist where isPublic=1")
    List<ConfigList> getAll();

    @Select("select count(*) from configlist")
    int getCount();

    @Select("select * from configlist where userId=#{userId}")
    List<ConfigList> selectByUserId(Integer userId);

    @Select("select count(*) from configlist where userId=#{userId}")
    Integer getPersonCount(Integer userId);
}

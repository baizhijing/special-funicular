package com.bzj.graduation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MainBoardMapper {
    @Select("select")
    String selectIntefById(int id);

    @Select("")
    String selectMemoryTypeById(int id);

    @Select("")
    int selectM2ById(int id);

    @Select("")
    String selectTypeById(int id);

}

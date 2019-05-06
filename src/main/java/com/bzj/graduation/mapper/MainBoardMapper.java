package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.MainBoard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface MainBoardMapper {
    @Select("select cpuInterface from mainboard where id=#{id}")
    String selectIntefById(int id);

    @Select("select memoryType from mainboard where id=#{id}")
    String selectMemoryTypeById(int id);

    @Select("select m2 from mainboard where id=#{id}")
    int selectM2ById(int id);

    @Select("select type from mainboard where id=#{id}")
    String selectTypeById(int id);

    @Select("select * from mainboard")
    List<MainBoard> getAll();

    @Select("select * from mainboard where name like CONCAT('%',#{type},'%')")
    List<MainBoard> selectAllByType(String type);

    @Select("select count(*) from mainboard")
    int getCount();

    @Select("select count(*) from mainboard where name like CONCAT('%',#{type},'%')")
    int countByType(String type);

    @Select("select price from mainboard where id=#{id}")
    Double selectPriceById(Integer id);

}

package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.MainBoard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface MainBoardMapper {
    @Select("select cpu_interf from mainboard where id=#{id}")
    String selectIntefById(int id);

    @Select("select memory_type from mainboard where id=#{id}")
    String selectMemoryTypeById(int id);

    @Select("select m2 from mainboard where id=#{id}")
    int selectM2ById(int id);

    @Select("select type from mainboard where id=#{id}")
    String selectTypeById(int id);

    @Select("select * from mainboard")
    List<MainBoard> getAll();

    @Select("select count(*) from mainboard")
    int getCount();

    @Select("select price from mainboard where id=#{id}")
    Double selectPriceById(Integer id);

}

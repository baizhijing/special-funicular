package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author:bai
 * @data:2019/3/7
 **/
@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> getAll();

    @Select("select password from user where username=#{username}")
    String getPassword(@PathVariable String username);

    @Select("select id from user where username=#{username}")
    Integer getUserId(String username);

    @Insert("insert into user values(0,#{username},#{password},1)")
    void insertUser(String username,String password);

    @Select("select * from user where username=#{userName}")
    User selectUserByName(String userName);

    @Select("update user set integ=integ+#{integNum} where userName=#{username}")
    void addInteg(Integer integNum,String username);

    @Update("update user set lastSignTime=#{time} where username=#{username}")
    void updateLastSignTime(String time,String username);

    @Select("select lastSignTime from user where username=#{username}")
    String getSignInTime(String username);
}

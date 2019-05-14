package com.bzj.graduation.mapper;

import com.bzj.graduation.bean.ConfigList;
import org.apache.ibatis.annotations.*;
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
//    @Select("select * from configlist where isPublic=1")
        @SelectProvider(type = UserDaoProvider.class, method = "getAll")
        List<ConfigList> getAll(String type);
        class UserDaoProvider {
            public String getAll(String type) {
                String sql = "SELECT * FROM configlist";
                if(type!=null){
                    sql += " where name like CONCAT('%',#{type},'%')";
                }
                return sql;
            }
        }


//    @Select("select count(*) from configlist")
    @SelectProvider(type = CountProvider.class, method = "getCount")
    int getCount(String type);
    class CountProvider {
        public String getCount(String type) {
            String sql = "SELECT count(*) FROM configlist";
            if(type!=null){
                sql += " where name like CONCAT('%',#{type},'%')";
            }
            return sql;
        }
    }

    @Select("select * from configlist where userId=#{userId}")
    List<ConfigList> selectByUserId(Integer userId);

    @Select("select count(*) from configlist where userId=#{userId}")
    Integer getPersonCount(Integer userId);

    @Update("update configlist set isPublic = 1 where id=#{id}")
    void submitConfigList(Integer id);

    @Select("select isPublic from configlist where id=#{id}")
    Integer addInteg(Integer id);

    @Update("update configlist set name=#{name} where id=#{id}")
    void renameConfigList(String name,Integer id);

    @Insert("insert into cpu values (0,#{name},#{power},#{interf},#{gpu},#{src},#{price},#{series},#{frequency},#{turbo},#{core},#{thread},#{technology})")
    void addCpu(String name,Integer power,String interf,String gpu,String src,Double price,String series,Double frequency,Double turbo,Integer core,Integer thread,Integer technology);

    @Update("update cpu set name=#{name},power=#{power},interf=#{interf},gpu=#{gpu},#{src},price=#{price},series=#{series},frequency=#{frequency},turbo=#{turbo},core=#{core},thread=#{thread},technology=#{technology} where id=#{id}")
    void editCpu(Integer id,String name,Integer power,String interf,String gpu,String src,Double price,String series,Double frequency,Double turbo,Integer core,Integer thread,Integer technology);

    @Insert("insert into mainboard values(0,#{name},#{type},#{cpuInterface},#{memoryType},#{maxMemory},#{memoryNum},#{sata},#{m2},#{power},#{src},#{price},#{dvi},#{hdmi},#{vga},#{cpuPower})")
    void addMainBoard(Integer id,String name,String type,String cpuInterface,String memoryType,Integer maxMemory,Integer memoryNum,Integer sata,Integer m2,Integer power,String src,Double price,Integer dvi,Integer hdmi,Integer vga,Integer cpuPower);

    @Update("update mainboard set name=#{name},type=#{type},cpuInterface=#{cpuInterface},memoryType=#{memoryType},maxMemory=#{maxMemory},memoryNum=#{memoryNum},sata=#{sata},m2=#{m2},power=#{power},src=#{src},price=#{price},dvi=#{dvi},hdmi=#{hdmi},vga=#{vga},cpuPower=#{cpuPower} where id=#{id}")
    void editMainBoard(Integer id,String name,String type,String cpuInterface,String memoryType,Integer maxMemory,Integer memoryNum,Integer sata,Integer m2,Integer power,String src,Double price,Integer dvi,Integer hdmi,Integer vga,Integer cpuPower);

    @Insert("insert into memory values(0,#{name},#{memoryType},#{memorySize},#{src},#{price},#{frequency},#{voltage})")
    void addMemory(String name,String memoryType,Integer memorySize,String src,Double price,Integer frequency,Double voltage);

    @Update("update memory set name=#{name},memoryType=#{memoryType},memorySize=#{memorySize},#{src},price=#{price},frequency=#{frequency},voltage=#{voltage} where id=#{id}")
    void editMemory(Integer id,String name,String memoryType,Integer memorySize,String src,Double price,Integer frequency,Double voltage);

    @Insert("insert into harddisk values(0,#{name},#{src},#{price},#{interf},#{capacity},#{size})")
    void addHardDisk(String name,String src,Double price,String interf,Integer capacity,Double size);

    @Update("update harddisk set name=#{name},src=#{src},price=#{price},interf=#{interf},capacity=#{capacity},size=#{size} where id=#{id}")
    void editHardDisk(Integer id,String name,String src,Double price,String interf,Integer capacity,Double size);

    @Insert("insert into displaycard values(0,#{name},#{src},#{price},#{length},#{power},#{mhz},#{technology},#{memory})")
    void addDisplay(String name,String src,Double price,Double length,Integer power,Integer mhz,Integer technology,Integer memory);

    @Update("update displaycard set name=#{name},src=#{src},price=#{price},length=#{length},power=#{power},mhz=#{mhz},technology=#{technology},memory=#{memory} where id=#{id}")
    void editDisplay(Integer id,String name,String src,Double price,Double length,Integer power,Integer mhz,Integer technology,Integer memory);

    @Insert("insert into box values(0,#{name},#{src},#{price},#{displayCard},#{radiator},#{type},#{powerDesign})")
    void addBox(String name,String src,Double price,Double displayCard,Double radiator,String type,String powerDesign);

    @Update("update box set name=#{name},src=#{src},price=#{price},displayCard=#{displayCard},radiator=#{radiator},type=#{type},powerDesign=#{powerDesign} where id=#{id}")
    void editBox(Integer id,String name,String src,Double price,Double displayCard,Double radiator,String type,String powerDesign);

    @Insert("insert into power values(0,#{name},#{num},#{src},#{price},#{mainboardPowerNum},#{pfcType},#{plus},#{cpuPowerNum})")
    void addPower(String name,Integer num,String src,Double price,Integer mainboardPowerNum,String pfcType,String plus,Integer cpuPowerNum);

    @Update("update power set name=#{name},num=#{num},src=#{src},price=#{price},mainboardPowerNum=#{mainboardPowerNum},pfcType=#{pfcType},plus=#{plus},cpuPowerNum=#{cpuPowerNum} where id=#{id}")
    void editPower(Integer id,String name,Integer num,String src,Double price,Integer mainboardPowerNum,String pfcType,String plus,Integer cpuPowerNum);

    @Insert("insert into radiator values(0,#{name},#{src},#{price},#{high},#{interf})")
    void addRadiator(String name,String src,Double price,Double high,String interf);

    @Update("update radiator set name=#{name},src=#{src},price=#{price},high=#{high},interf=#{interf} where id=#{id}")
    void editRadiator(Integer id,String name,String src,Double price,Double high,String interf);

    @Delete("delete from ${a} where id=#{id}")
    void deleteCpu(Integer id,String a);

    @Insert("insert into resource values(0,#{name},#{url},#{type})")
    void addSoft(String name,String url,String type);

    @Update("update resource set name=#{name},url=#{url},type=#{type} where id=#{id}")
    void editSoft(Integer id,String name,String url,String type);

    @Select("select * from configlist")
    List<ConfigList> allConfigList();

    @Delete("delete from configList where id=#{id}")
    void deleteConfigList(Integer id);
}

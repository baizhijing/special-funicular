package com.bzj.graduation.dao;

import com.bzj.graduation.bean.*;
import com.bzj.graduation.mapper.ConfigListMapper;
import com.bzj.graduation.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author:bai
 * @data:2019/3/15
 **/
@Repository
public class ConfigListDao {

    @Autowired
    private ConfigListMapper configListMapper;

    @Autowired
    private LoginDao loginDao;

    public boolean insertList(ConfigList configList){
        Integer cpuId=configList.getCpuId();
        Integer userId=configList.getUserId();
        Integer hardDiskId=configList.getHardDiskId();
        Integer radiatorId=configList.getRadiatorId();
        Integer boxId=configList.getBoxId();
        Integer powerId=configList.getPowerId();
        Integer memoryId=configList.getMemoryId();
        Integer mainBoardId=configList.getMainBoardId();
        String name="我的配置单";
        String cpuName=configList.getCpuName();
        String hardDiskName=configList.getHardDiskName();
        String radiatorName=configList.getRadiatorName();
        String boxName=configList.getBoxName();
        String powerName=configList.getPowerName();
        String memoryName=configList.getMemoryName();
        String mainBoardName=configList.getMainBoardName();
        Integer displayId=configList.getDisplayId();
        String displayName=configList.getDisplayName();
        Integer isPublic=0;
        configListMapper.InsertList(cpuId,userId,hardDiskId,radiatorId,boxId,powerId,memoryId,mainBoardId,
                name,cpuName,hardDiskName,radiatorName,boxName,powerName,memoryName,mainBoardName,displayId,displayName,isPublic);
        return true;
    }

    public void submitConfigList(Integer id,String name){
        if (configListMapper.addInteg(id)==0)
            loginDao.addInteg(5,name);
        configListMapper.submitConfigList(id);
    }

    public List<ConfigList> selectConfigListByPage(int currentPage, int pageSize,String type){
        PageHelper.startPage(currentPage, pageSize);
        List<ConfigList> allConfigLists = configListMapper.getAll(type);        //全部商品
        int countNums = configListMapper.getCount(type);            //总记录数
        PageBean<ConfigList> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allConfigLists);
        return pageData.getItems();
    }
//私人配置单
    public List<ConfigList> selectPersonConfigListByPage(int currentPage, int pageSize,Integer userId){
        PageHelper.startPage(currentPage, pageSize);
        List<ConfigList> allConfigLists = configListMapper.selectByUserId(userId);        //全部商品
        int countNums = configListMapper.getPersonCount(userId);            //总记录数
        PageBean<ConfigList> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allConfigLists);
        return pageData.getItems();
    }

    public Integer getCount(String type){
        return configListMapper.getCount(type);
    }

    public Integer getPersonCount(Integer userId){
        return configListMapper.getPersonCount(userId);
    }

    public boolean renameConfigList(String title,Integer id){
         try{
             configListMapper.renameConfigList(title,id);
         }
         catch (Exception e){
             e.printStackTrace();
         }
         return true;
    }

    public void addCpu(Cpu cpu){
        configListMapper.addCpu(cpu.getName(),cpu.getPower(),cpu.getInterf(),cpu.getGpu(),cpu.getSrc(),cpu.getPrice(),cpu.getSeries(),cpu.getFrequency(),cpu.getTurbo(),cpu.getCores(),cpu.getThread(),cpu.getTechnology());
    }

    public void editCpu(Cpu cpu){
        configListMapper.editCpu(cpu.getId(),cpu.getName(),cpu.getPower(),cpu.getInterf(),cpu.getGpu(),cpu.getSrc(),cpu.getPrice(),cpu.getSeries(),cpu.getFrequency(),cpu.getTurbo(),cpu.getCores(),cpu.getThread(),cpu.getTechnology());
    }

    public void addMainBoard(MainBoard mainBoard){
        configListMapper.addMainBoard(mainBoard.getId(),mainBoard.getName(),mainBoard.getType(),mainBoard.getCpuInterface(),mainBoard.getMemoryType(),mainBoard.getMaxMemory(),mainBoard.getMemoryNum(),mainBoard.getSata(),mainBoard.getM2(),mainBoard.getPower(),mainBoard.getSrc(),mainBoard.getPrice(),mainBoard.getDvi(),mainBoard.getHdmi(),mainBoard.getVga(),mainBoard.getCpuPower());
    }

    public void editMainBoard(MainBoard mainBoard){
        configListMapper.editMainBoard(mainBoard.getId(),mainBoard.getName(),mainBoard.getType(),mainBoard.getCpuInterface(),mainBoard.getMemoryType(),mainBoard.getMaxMemory(),mainBoard.getMemoryNum(),mainBoard.getSata(),mainBoard.getM2(),mainBoard.getPower(),mainBoard.getSrc(),mainBoard.getPrice(),mainBoard.getDvi(),mainBoard.getHdmi(),mainBoard.getVga(),mainBoard.getCpuPower());
    }
//
    public void addMemory(Memory memory){
        configListMapper.addMemory(memory.getName(),memory.getMemoryType(),memory.getMemorySize(),memory.getSrc(),memory.getPrice(),memory.getFrequency(),memory.getVoltage());
    }

    public void editMemory(Memory memory){
        configListMapper.editMemory(memory.getId(),memory.getName(),memory.getMemoryType(),memory.getMemorySize(),memory.getSrc(),memory.getPrice(),memory.getFrequency(),memory.getVoltage());
    }
//
    public void addHardDisk(HardDisk hardDisk){
        configListMapper.addHardDisk(hardDisk.getName(),hardDisk.getSrc(),hardDisk.getPrice(),hardDisk.getInterf(),hardDisk.getCapacity(),hardDisk.getSize());
    }

    public void editHardDisk(HardDisk hardDisk){
        configListMapper.editHardDisk(hardDisk.getId(),hardDisk.getName(),hardDisk.getSrc(),hardDisk.getPrice(),hardDisk.getInterf(),hardDisk.getCapacity(),hardDisk.getSize());
    }
//
    public void addDisplay(Display display){
        configListMapper.addDisplay(display.getName(),display.getSrc(),display.getPrice(),display.getLength(),display.getPower(),display.getMHZ(),display.getTechnology(),display.getMemory());
    }

    public void editDisplay(Display display){
        configListMapper.editDisplay(display.getId(),display.getName(),display.getSrc(),display.getPrice(),display.getLength(),display.getPower(),display.getMHZ(),display.getTechnology(),display.getMemory());
    }
//
    public void addBox(Box box){
        configListMapper.addBox(box.getName(),box.getSrc(),box.getPrice(),box.getDisplayCard(),box.getRadiator(),box.getType(),box.getPowerDesign());
    }

    public void editBox(Box box){
        configListMapper.editBox(box.getId(),box.getName(),box.getSrc(),box.getPrice(),box.getDisplayCard(),box.getRadiator(),box.getType(),box.getPowerDesign());
    }

    public void addPower(Power power){
        configListMapper.addPower(power.getName(),power.getNum(),power.getSrc(),power.getPrice(),power.getMainboardPowerNum(),power.getPfcType(),power.getPlus(),power.getCpuPowerNum());
    }

    public void editPower(Power power){
        configListMapper.editPower(power.getId(),power.getName(),power.getNum(),power.getSrc(),power.getPrice(),power.getMainboardPowerNum(),power.getPfcType(),power.getPlus(),power.getCpuPowerNum());
    }

    public void addRadiator(Radiator radiator){
        configListMapper.addRadiator(radiator.getName(),radiator.getSrc(),radiator.getPrice(),radiator.getHigh(),radiator.getInterf());
    }

    public void editRadiator(Radiator radiator){
        configListMapper.editRadiator(radiator.getId(),radiator.getName(),radiator.getSrc(),radiator.getPrice(),radiator.getHigh(),radiator.getInterf());
    }

    public void delete(Map<String,Integer> map){
        Integer id=map.get("id");
        Integer hard=map.get("type");
        System.out.println(id+" "+hard);
        // 1代表当前在操作CPU，2代表主板，3代表内存，4硬盘，5显卡，6机箱，7电源，8散热器
        if (hard==1)
            configListMapper.deleteCpu(id,"cpu");
        if (hard==2)
            configListMapper.deleteCpu(id,"mainboard");
        if (hard==3)
            configListMapper.deleteCpu(id,"memory");
        if (hard==4)
            configListMapper.deleteCpu(id,"harddisk");
        if (hard==5)
            configListMapper.deleteCpu(id,"displaycard");
        if (hard==6)
            configListMapper.deleteCpu(id,"box");
        if (hard==7)
            configListMapper.deleteCpu(id,"power");
        if (hard==8)
            configListMapper.deleteCpu(id,"radiator");
        else if (hard==9)
        configListMapper.deleteCpu(id,"record");
    }

    public void addSoft(Resource resource){
        configListMapper.addSoft(resource.getName(),resource.getUrl(),resource.getType());
    }

    public void editSoft(Resource resource){
        configListMapper.editSoft(resource.getId(),resource.getName(),resource.getUrl(),resource.getType());
    }

    public void deleteResource(Integer id)
    {
        configListMapper.deleteCpu(id,"resource");
    }

    public List<ConfigList> allConfigList(int currentPage, int pageSize,String type){
        PageHelper.startPage(currentPage, pageSize);
        List<ConfigList> allConfigLists = configListMapper.allConfigList();
        System.out.println(allConfigLists);
        int countNums = configListMapper.getCount(type);            //总记录数
        PageBean<ConfigList> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allConfigLists);
        return pageData.getItems();
    }

    public Integer allConfigListCount(Integer pageSize,String type){
        return configListMapper.getCount(type);
    }

    public void deleteConfigList(Integer id){
        configListMapper.deleteConfigList(id);
    }
}

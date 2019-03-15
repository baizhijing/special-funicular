package com.bzj.graduation.service;

import com.bzj.graduation.bean.*;
import com.bzj.graduation.dao.CoreDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author:bai
 * @data:2019/3/13
 **/
@Service
public class CoreService {
    @Autowired
    private ConfigList configList;

    @Autowired
    private CoreDao coreDao;

    //判断CPU规格，散热器可能同时支持两种
    public Boolean Core(ConfigList configList, Map<String,Object> map) {
        Cpu cpu = configList.getCpu();
        MainBoard mainBoard = configList.getMainBoard();
        Power power = configList.getPower();
        Radiator radiator = configList.getRadiator();
        Memory memory = configList.getMemory();
        Display display=configList.getDisplay();
        HardDisk hardDisk=configList.getHardDisk();
        Box box=configList.getBox();
        //判断cpu兼容性
        if (!cpu.getInterf().equals(mainBoard.getCpuInterf()) || radiator.getIntef().indexOf(cpu.getInterf())==-1) {
            map.put("coremsg", "请检查主板，散热器是否支持cpu!");
            return false;
        }
        //判断内存兼容性
        else if (!(mainBoard.getMemoryType().equals(memory.getMemoryType()))) {
            map.put("coremsg","请检查内存规格是否兼容主板!");
            return false;
        }
        //判断电源功率
        else if ((cpu.getPower()+display.getPower()+100)>power.getNum()){
            map.put("coremsg","电源功率不足！");
            return false;
        }
        //硬盘兼容性
        else if (hardDisk.getInterf()=="m.2" && mainBoard.getM2()==0){
            map.put("coremsg","硬盘不兼容，主板缺少M.2接口！");
            return false;
        }
        else if ( StringUtils.isBlank(cpu.getGpu()) && display==null ){
            map.put("coremsg","该CPU没有显示核心，请添加独立显卡!");
            return false;
        }
        else if (box.getDisplayCard()<display.getLength()){
            map.put("coremsg","显卡过长，请更换显卡或机箱!");
        }
        else if (radiator.getHign()>box.getRadiator()){
            map.put("coremsg","散热器过高，请更换散热器或机箱!");
            return false;
        }
        else if (box.getType().indexOf(mainBoard.getType())==-1){
            map.put("coremsg","主板与机箱不兼容!");
            return false;
        }

        map.put("coremsg","装机成功！");
        coreDao.insertList(configList);
            return true;
    }
}

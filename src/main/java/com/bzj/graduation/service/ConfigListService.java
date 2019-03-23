package com.bzj.graduation.service;

import com.bzj.graduation.bean.*;
import com.bzj.graduation.dao.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author:bai
 * @data:2019/3/13
 **/
@Service
public class ConfigListService {
    @Autowired
    private ConfigList configList;

    @Autowired
    private ConfigListDao configListDao;

    @Autowired
    private CpuDao cpuDao;

    @Autowired
    private MainBoardDao mainBoardDao;

    @Autowired
    private RadiatorDao radiatorDao;

    @Autowired
    private MemoryDao memoryDao;

    @Autowired
    private DisplayDao displayDao;

    @Autowired
    private PowerDao powerDao;

    @Autowired
    private HardDiskDao hardDiskDao;

    @Autowired
    private BoxDao boxDao;

    //判断CPU规格，散热器可能同时支持两种
    public Boolean Core(ConfigList configList, Map<String,Object> map) {
        Integer cpuId = configList.getCpuId();
        Integer mainBoardId = configList.getMainBoardId();
        Integer powerId = configList.getPowerId();
        Integer radiatorId = configList.getRadiatorId();
        Integer memoryId = configList.getMemoryId();
        Integer displayId=configList.getDisplayId();
        Integer hardDiskId=configList.getHardDiskId();
        Integer boxId=configList.getBoxId();
        Integer userId=configList.getUserId();
        //判断cpu兼容性
        if (!cpuDao.getInterfById(userId).equals(mainBoardDao.getInterfById(mainBoardId)) || radiatorDao.getInterfById(radiatorId).indexOf(cpuDao.getInterfById(userId))==-1) {
            map.put("coremsg", "请检查主板，散热器是否支持cpu!");
            return false;
        }
        //判断内存兼容性
        else if (!(mainBoardDao.getMemoryTypeById(mainBoardId).equals(memoryDao.getMemoryTypeById(memoryId)))) {
            map.put("coremsg","请检查内存规格是否兼容主板!");
            return false;
        }
        //判断电源功率
        else if ((cpuDao.getPowerById(cpuId)+displayDao.getPowerById(displayId)+100)>powerDao.getNumById(powerId)){
            map.put("coremsg","电源功率不足！");
            return false;
        }
        //硬盘兼容性
        else if (hardDiskDao.getInterfById(hardDiskId)=="m.2" && mainBoardDao.getM2ById(mainBoardId)==0){
            map.put("coremsg","硬盘不兼容，主板缺少M.2接口！");
            return false;
        }
        else if ( StringUtils.isBlank(cpuDao.getGpuById(cpuId)) && displayId==null ){
            map.put("coremsg","该CPU没有显示核心，请添加独立显卡!");
            return false;
        }
        else if (boxDao.getDisplayCardById(boxId)<displayDao.getLengthById(displayId)){
            map.put("coremsg","显卡过长，请更换显卡或机箱!");
        }
        else if (radiatorDao.getHighById(radiatorId)>boxDao.getRadiatorById(boxId)){
            map.put("coremsg","散热器过高，请更换散热器或机箱!");
            return false;
        }
        else if (boxDao.getTypeById(boxId).indexOf(mainBoardDao.getTypeById(mainBoardId))==-1){
            map.put("coremsg","主板与机箱不兼容!");
            return false;
        }

        map.put("coremsg","装机成功！");
        configListDao.insertList(configList);
            return true;
    }

    public List getCPU(){
        return cpuList;
    }
}

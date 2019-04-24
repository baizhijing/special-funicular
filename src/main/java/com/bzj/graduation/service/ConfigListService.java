package com.bzj.graduation.service;

import com.bzj.graduation.bean.*;
import com.bzj.graduation.dao.*;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author:bai
 * @data:2019/3/13
 **/
@Service
public class ConfigListService {

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

        //散热器接口需要判断，有些只兼容intel或AMD的

        //显卡供电接口？？

        else if (boxDao.getTypeById(boxId).indexOf(mainBoardDao.getTypeById(mainBoardId))==-1){
            map.put("coremsg","主板与机箱不兼容!");
            return false;
        }

        map.put("coremsg","装机成功！");
        configListDao.insertList(configList);
            return true;
    }

    public Integer getCPUPage(Integer pageSize){
        int countNums= cpuDao.selectCount();
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

    public List<Cpu> getCPUList(Integer currentPage,Integer pageSize){
        return cpuDao.selectCpuByPage(currentPage,pageSize);
    }

    public Integer getBoxPage(Integer pageSize){
        int countNums= boxDao.getCount();
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

    public List<Box> getBoxList(Integer currentPage,Integer pageSize){
        return boxDao.selectBoxByPage(currentPage,pageSize);
    }

    public Integer getDisplayPage(Integer pageSize){
        int countNums= displayDao.getCount();
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

    public List<Display> getDisplayList(Integer currentPage,Integer pageSize){
        return displayDao.selectDisplayByPage(currentPage,pageSize);
    }

    public Integer getHardDiskPage(Integer pageSize){
        int countNums= hardDiskDao.getCount();
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

    public List<HardDisk> getHardDiskList(Integer currentPage,Integer pageSize){
        return hardDiskDao.selectHardDiskByPage(currentPage,pageSize);
    }

    public Integer getMainBoardPage(Integer pageSize){
        int countNums= mainBoardDao.getCount();
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

    public List<MainBoard> getMainBoardList(Integer currentPage,Integer pageSize){
        return mainBoardDao.selectMainBoardByPage(currentPage,pageSize);
    }

    public Integer getMemoryPage(Integer pageSize){
        int countNums= memoryDao.getCount();
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

    public List<Memory> getMemoryList(Integer currentPage,Integer pageSize){
        return memoryDao.selectMemoryByPage(currentPage,pageSize);
    }

    public Integer getPowerPage(Integer pageSize){
        int countNums= powerDao.getCount();
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

    public List<Power> getPowerList(Integer currentPage,Integer pageSize){
        return powerDao.selectPowerByPage(currentPage,pageSize);
    }

    public Integer getRadiatorPage(Integer pageSize){
        int countNums= radiatorDao.getCount();
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

    public List<Radiator> getRadiatorList(Integer currentPage,Integer pageSize){
        return radiatorDao.selectRadiatorByPage(currentPage,pageSize);
    }

    public List<ConfigListDto> getConfigListByPage(Integer currentPage,Integer pageSize){
        List<ConfigList> list=configListDao.selectConfigListByPage(currentPage,pageSize);
        List<ConfigListDto> listDto=new ArrayList<ConfigListDto>();
        for (int i=0;i<list.size();i++){
            ConfigList ct=list.get(i);
            ConfigListDto configListDto0=new ConfigListDto();
            listDto.add(configListDto0);
            ConfigListDto configListDto=listDto.get(i);
            configListDto.setUserId(ct.getUserId());
            configListDto.setCpuId(ct.getCpuId());
            configListDto.setCpuName(ct.getCpuName());
            configListDto.setHardDiskId(ct.getHardDiskId());
            configListDto.setHardDiskName(ct.getHardDiskName());
            configListDto.setRadiatorId(ct.getRadiatorId());
            configListDto.setRadiatorName(ct.getRadiatorName());
            configListDto.setBoxId(ct.getBoxId());
            configListDto.setBoxName(ct.getBoxName());
            configListDto.setPowerId(ct.getPowerId());
            configListDto.setPowerName(ct.getPowerName());
            configListDto.setMemoryId(ct.getMemoryId());
            configListDto.setMemoryName(ct.getMemoryName());
            configListDto.setMainBoardId(ct.getMainBoardId());
            configListDto.setMainBoardName(ct.getMainBoardName());
            configListDto.setName(ct.getName());
            configListDto.setDisplayId(ct.getDisplayId());
            configListDto.setDisplayName(ct.getDisplayName());
            //计算配置单总价格
            double sum=0;
            sum+=cpuDao.getPriceById(ct.getCpuId())
                    +boxDao.getPriceById(ct.getBoxId())
                    +displayDao.getPriceById(ct.getDisplayId())
                    +hardDiskDao.getPriceById(ct.getHardDiskId())
                    +mainBoardDao.getPriceById(ct.getMainBoardId())
                    +memoryDao.getPriceById(ct.getMemoryId())
                    +powerDao.getPriceById(ct.getPowerId())
                    +radiatorDao.getPriceById(ct.getRadiatorId());
            configListDto.setPrice(sum);
        }
        return listDto;
    }

    public Integer getConfiglistPageNum(Integer pageSize){
        int countNums= configListDao.getCount();
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

//    获取私人配置单
public List<ConfigListDto> getPersonConfigListByPage(Integer currentPage,Integer pageSize,Integer userId){
    List<ConfigList> list=configListDao.selectPersonConfigListByPage(currentPage,pageSize,userId);
    List<ConfigListDto> listDto=new ArrayList<ConfigListDto>();
    for (int i=0;i<list.size();i++){
        ConfigList ct=list.get(i);
        ConfigListDto configListDto0=new ConfigListDto();
        listDto.add(configListDto0);
        ConfigListDto configListDto=listDto.get(i);
        configListDto.setUserId(ct.getUserId());
        configListDto.setCpuId(ct.getCpuId());
        configListDto.setCpuName(ct.getCpuName());
        configListDto.setHardDiskId(ct.getHardDiskId());
        configListDto.setHardDiskName(ct.getHardDiskName());
        configListDto.setRadiatorId(ct.getRadiatorId());
        configListDto.setRadiatorName(ct.getRadiatorName());
        configListDto.setBoxId(ct.getBoxId());
        configListDto.setBoxName(ct.getBoxName());
        configListDto.setPowerId(ct.getPowerId());
        configListDto.setPowerName(ct.getPowerName());
        configListDto.setMemoryId(ct.getMemoryId());
        configListDto.setMemoryName(ct.getMemoryName());
        configListDto.setMainBoardId(ct.getMainBoardId());
        configListDto.setMainBoardName(ct.getMainBoardName());
        configListDto.setName(ct.getName());
        configListDto.setDisplayId(ct.getDisplayId());
        configListDto.setDisplayName(ct.getDisplayName());
        //计算配置单总价格
        double sum=0;
        sum+=cpuDao.getPriceById(ct.getCpuId())
                +boxDao.getPriceById(ct.getBoxId())
                +displayDao.getPriceById(ct.getDisplayId())
                +hardDiskDao.getPriceById(ct.getHardDiskId())
                +mainBoardDao.getPriceById(ct.getMainBoardId())
                +memoryDao.getPriceById(ct.getMemoryId())
                +powerDao.getPriceById(ct.getPowerId())
                +radiatorDao.getPriceById(ct.getRadiatorId());
        configListDto.setPrice(sum);
    }
    return listDto;
}
}

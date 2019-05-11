package com.bzj.graduation.service;

import com.bzj.graduation.bean.*;
import com.bzj.graduation.dao.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

//    @Autowired
//    private ConfigList configList;

    //判断CPU规格，散热器可能同时支持两种
    public String Core(Map<String,Object> map,ConfigList configList) {
        Integer cpuId = (Integer) map.get("cpuId");
        Integer mainBoardId = (Integer) map.get("mainBoardId");
        Integer powerId = (Integer) map.get("powerId");
        Integer radiatorId = (Integer) map.get("radiatorId");
        Integer memoryId = (Integer) map.get("memoryId");
        Integer displayId=(Integer) map.get("displayId");
        Integer hardDiskId=(Integer) map.get("hardDiskId");
        Integer boxId=(Integer) map.get("boxId");
        Integer userId=configList.getUserId();
        String cpuName=(String) map.get("cpuName");
        String mainBoardName=(String) map.get("mainBoardName");
        String powerName=(String) map.get("powerName");
        String radiatorName=(String) map.get("radiatorName");
        String memoryName=(String) map.get("memoryName");
        String displayName=(String) map.get("displayName");
        String hardDiskName=(String) map.get("hardDiskName");
        String boxName=(String) map.get("boxName");
        //判断cpu兼容性
        if (!cpuDao.getInterfById(cpuId).equals(mainBoardDao.getInterfById(mainBoardId))) {
            return "主板和CPU不兼容，接口不匹配！！";
        }
        else if (radiatorDao.getInterfById(radiatorId).indexOf(cpuDao.getInterfById(userId),1)==-1){
            return "散热器和CPU不兼容，接口不匹配！！";
        }
        //判断内存兼容性
        else if (!(mainBoardDao.getMemoryTypeById(mainBoardId).equals(memoryDao.getMemoryTypeById(memoryId)))) {
            return "主板和内存不兼容";
        }
        //判断电源功率
        else if ((cpuDao.getPowerById(cpuId)+displayDao.getPowerById(displayId)+100)>powerDao.getNumById(powerId)){
            return "电源功率不足!请更换更大功率电源";
        }
        //硬盘兼容性
        else if (hardDiskDao.getInterfById(hardDiskId).equals("M2") && mainBoardDao.getM2ById(mainBoardId)==0){
            return "硬盘不兼容，主板缺少M.2接口！!";
        }
        else if (boxDao.getTypeById(boxId).equals("MATX")&&mainBoardDao.getTypeById(mainBoardId).equals("ATX")){
            return "主板与机箱不兼容!";
        }
        else if (boxDao.getDisplayCardById(boxId)<displayDao.getLengthById(displayId)){
            return "显卡过长，请更换显卡或机箱!";
        }
        else if (radiatorDao.getHighById(radiatorId)>boxDao.getRadiatorById(boxId)){
            return "散热器过高，请更换散热器或机箱!";
        }

        configList.setRadiatorId(radiatorId);
        configList.setRadiatorName(radiatorName);
        configList.setPowerId(powerId);
        configList.setPowerName(powerName);
        configList.setBoxId(boxId);
        configList.setBoxName(boxName);
        configList.setCpuId(cpuId);
        configList.setCpuName(cpuName);
        configList.setDisplayId(displayId);
        configList.setDisplayName(displayName);
        configList.setHardDiskId(hardDiskId);
        configList.setHardDiskName(hardDiskName);
        configList.setMainBoardId(mainBoardId);
        configList.setMainBoardName(mainBoardName);
        configList.setMemoryId(memoryId);
        configList.setMemoryName(memoryName);
        configListDao.insertList(configList);
            return "装机成功！";
    }

    public Integer getCPUPage(Integer pageSize,String type){
        int countNums=cpuDao.selectCount(type);
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

    public List<Cpu> getCPUList(Integer currentPage,Integer pageSize,String type){
        return cpuDao.selectCpuByPage(currentPage,pageSize,type);
    }

    public Integer getBoxPage(Integer pageSize,String type){
        int countNums= boxDao.getCount(type);
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

    public List<Box> getBoxList(Integer currentPage,Integer pageSize,String type){
        return boxDao.selectBoxByPage(currentPage,pageSize,type);
    }

    public Integer getDisplayPage(Integer pageSize,String type){
        int countNums= displayDao.getCount(type);
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

    public List<Display> getDisplayList(Integer currentPage,Integer pageSize,String type){
        return displayDao.selectDisplayByPage(currentPage,pageSize,type);
    }

    public Integer getHardDiskPage(Integer pageSize,String type){
        int countNums= hardDiskDao.getCount(type);
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

    public List<HardDisk> getHardDiskList(Integer currentPage,Integer pageSize,String type){
        return hardDiskDao.selectHardDiskByPage(currentPage,pageSize,type);
    }

    public Integer getMainBoardPage(Integer pageSize,String type){
        int countNums= mainBoardDao.getCount(type);
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

    public List<MainBoard> getMainBoardList(Integer currentPage,Integer pageSize,String type){
        return mainBoardDao.selectMainBoardByPage(currentPage,pageSize,type);
    }

    public Integer getMemoryPage(Integer pageSize,String type){
        int countNums= memoryDao.getCount(type);
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

    public List<Memory> getMemoryList(Integer currentPage,Integer pageSize,String type){
        return memoryDao.selectMemoryByPage(currentPage,pageSize,type);
    }

    public Integer getPowerPage(Integer pageSize,String type){
        int countNums= powerDao.getCount(type);
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

    public List<Power> getPowerList(Integer currentPage,Integer pageSize,String type){
        return powerDao.selectPowerByPage(currentPage,pageSize,type);
    }

    public Integer getRadiatorPage(Integer pageSize,String type){
        int countNums= radiatorDao.getCount(type);
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

    public List<Radiator> getRadiatorList(Integer currentPage,Integer pageSize,String type){
        return radiatorDao.selectRadiatorByPage(currentPage,pageSize,type);
    }

    public List<ConfigListDto> getConfigListByPage(Integer currentPage,Integer pageSize,Integer sortConfigList){
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
        System.out.println(listDto);
        if (sortConfigList!=1)
            return listDto;
        else{
            Collections.sort(listDto);
            System.out.println(listDto);
            return listDto;
        }
    }

    public Integer getConfiglistPageNum(Integer pageSize){
        int countNums= configListDao.getCount();
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

    public Integer getPersonConfiglistPageNum(Integer pageSize,Integer userId){
        int countNums= configListDao.getPersonCount(userId);
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

    public void submitConfigList(Integer id,String name){
        configListDao.submitConfigList(id,name);
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
        configListDto.setId(ct.getId());
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
        configListDto.setIsPublic(ct.getIsPublic());
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

public boolean renameConfigList(String title,Integer id){
        return configListDao.renameConfigList(title,id);
}

public void addCpu(Cpu cpu){
        configListDao.addCpu(cpu);
}

public void editCpu(Cpu cpu){
        configListDao.editCpu(cpu);
}

    public void addMainBoard(MainBoard mainBoard){
        configListDao.addMainBoard(mainBoard);
    }

    public void editMainBoard(MainBoard mainBoard){
        configListDao.editMainBoard(mainBoard);
    }
//
    public void addMemory(Memory memory){
        configListDao.addMemory(memory);
    }

    public void editMemory(Memory memory){
        configListDao.editMemory(memory);
    }
//
    public void addHardDisk(HardDisk hardDisk){
        configListDao.addHardDisk(hardDisk);
    }

    public void editHardDisk(HardDisk hardDisk){
        configListDao.editHardDisk(hardDisk);
    }
//
    public void addDisplay(Display display){
        configListDao.addDisplay(display);
    }

    public void editDisplay(Display display){
        configListDao.editDisplay(display);
    }
//
    public void addBox(Box box){
        configListDao.addBox(box);
    }

    public void editBox(Box box){
        configListDao.editBox(box);
    }

    public void addPower(Power power){
        configListDao.addPower(power);
    }

    public void editPower(Power power){
        configListDao.editPower(power);
    }

    public void addRadiator(Radiator radiator){
        configListDao.addRadiator(radiator);
    }

    public void editRadiator(Radiator radiator){
        configListDao.editRadiator(radiator);
    }

    public void delete(Map<String,Integer> map){
        configListDao.delete(map);
    }

    public void addSoft(Resource resource){
        configListDao.addSoft(resource);
    }

    public void editSoft(Resource resource){
        configListDao.editSoft(resource);
    }

    public void deleteResource(Integer id){
        configListDao.deleteResource(id);
    }


    public List<ConfigListDto> allConfigList(Integer currentPage,Integer pageSize){
        List<ConfigList> list=configListDao.allConfigList(currentPage,pageSize);
        List<ConfigListDto> listDto=new ArrayList<ConfigListDto>();
        for (int i=0;i<list.size();i++){
            ConfigList ct=list.get(i);
            ConfigListDto configListDto0=new ConfigListDto();
            listDto.add(configListDto0);
            ConfigListDto configListDto=listDto.get(i);
            configListDto.setId(ct.getId());
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
            configListDto.setIsPublic(ct.getIsPublic());
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

    public Integer allConfigListCount(Integer pageSize){
        int countNums= configListDao.allConfigListCount(pageSize);
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

    public void deleteConfigList(Integer id){
        configListDao.deleteConfigList(id);
    }

}

package com.bzj.graduation.service;

import com.bzj.graduation.bean.Resource;
import com.bzj.graduation.dao.DownloadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DownloadService {
    @Autowired
    private DownloadDao downloadDao;

    public List<Resource> getAll(Integer currentPage,Integer pageSize){
        return downloadDao.selectResourceByPage(currentPage,pageSize);
    }

    public List<Resource> getAllByType(Integer currentPage,Integer pageSize,String type){
        return downloadDao.selectResourceTypeByPage(currentPage,pageSize,type);
    }

    public Integer getAllCount(Integer pageSize){
        Integer countNums= downloadDao.getAllCount();
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

    public Integer getCountByType(String type,Integer pageSize){
        Integer countNums= downloadDao.getCountByType(type);
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }
}

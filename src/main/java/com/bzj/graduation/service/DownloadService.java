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

    public List<Resource> getAll(Integer currentPage,Integer pageSize,String type){
        return downloadDao.selectResourceByPage(currentPage,pageSize,type);
    }

//    public List<Resource> getAllByType(Integer currentPage,Integer pageSize,String type){
//        return downloadDao.selectResourceTypeByPage(currentPage,pageSize,type);
//    }

    public Integer getAllCount(Integer pageSize,String type){
        Integer countNums= downloadDao.getAllCount(type);
        if (countNums%pageSize==0)
            return countNums/pageSize;
        return countNums/pageSize+1;
    }

}

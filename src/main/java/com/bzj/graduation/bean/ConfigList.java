package com.bzj.graduation.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author:bai
 * @data:2019/3/13
 **/
@Component
@Data
public class ConfigList {
    private Integer id;
    @Autowired
    private Cpu cpu;
    @Autowired
    private Box box;
    @Autowired
    private HardDisk hardDisk;
    @Autowired
    private MainBoard mainBoard;
    @Autowired
    private  Memory memory;
    @Autowired
    private  Power power;
    @Autowired
    private Radiator radiator;
    @Autowired
    private Display display;
}

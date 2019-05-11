package com.bzj.graduation.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @Author:bai
 * @data:2019/3/13
 **/
@Component
@Data
public class MainBoard {
    private Integer id;
    private String name;
    private String type;
    private String cpuInterface;//cpu接口
    private String memoryType;
    private Integer maxMemory;//支持最大内存
    private Integer memoryNum;
    private Integer sata;
    private Integer m2;
    private Integer power;
    private String src;
    private Double price;
    private Integer dvi;
    private Integer hdmi;
    private Integer vga;
    private Integer cpuPower;
}

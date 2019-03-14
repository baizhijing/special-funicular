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
    private String cpuInterf;//cpu接口
    private Integer memoryType;
    private Integer memoryNum;
    private Integer sata;
    private Integer m2;
    private Integer power;
    private String src;
    private BigDecimal price;
}

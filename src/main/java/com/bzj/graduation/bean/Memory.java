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
public class Memory {
    private Integer id;
    private String name;
    private String memoryType;
    private Integer memorySize;
    private String src;
    private Double price;
    private Integer frequency;//频率
    private Double voltage;//工作电压
}

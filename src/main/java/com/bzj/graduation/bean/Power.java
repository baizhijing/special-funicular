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
public class Power {
    private Integer id;
    private String name;
    private Integer num;//瓦数
    private String src;
    private Double price;
    private Integer mainboardPowerNum;//主板供电
    private Integer cpuPowerNum;//主板供电
    private String pfcType;//PFC类型
    private String plus;//80PLUS认证
}

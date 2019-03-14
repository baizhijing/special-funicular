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
    private BigDecimal price;
}

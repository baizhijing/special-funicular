package com.bzj.graduation.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @Author:bai
 * @data:2019/3/14
 **/
@Data
@Component
public class Display {
    private Integer id;
    private String name;
    private String src;
    private BigDecimal price;
    private Integer power;
    private Double length;
}

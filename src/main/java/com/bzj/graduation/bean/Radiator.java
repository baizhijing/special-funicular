package com.bzj.graduation.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @Author:bai
 * @data:2019/3/13
 * 散热器
 **/
@Component
@Data
public class Radiator {
    private Integer id;
    private String name;
    private String src;
    private BigDecimal price;
    private double high;
    private String Interf;
}

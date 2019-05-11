package com.bzj.graduation.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @Author:bai
 * @data:2019/3/13
 **/
//机箱
@Component
@Data
public class Box {
    private Integer id;
    private String name;
    private String src;
    private Double price;
    private String type;
    private double displayCard;
    private double radiator;
    private String powerDesign;//设计类型
}

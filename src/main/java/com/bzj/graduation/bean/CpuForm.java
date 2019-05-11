package com.bzj.graduation.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author:bai
 * @data:2019/3/13
 **/
@Component
@Data
public class CpuForm {
    private Integer id;
    private String name;
    private int power;
    private String interf;
    private String gpu;
    private String src;
    private Double price;
    private String series;//cpu系列
    private double frequency;//主频
    private double turbo;//睿频
    private Integer cores;//核心数
    private Integer thread;//线程数
    private Integer technology;//制作工艺
}

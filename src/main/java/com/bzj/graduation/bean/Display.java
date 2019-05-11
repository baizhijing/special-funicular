package com.bzj.graduation.bean;

import lombok.Data;
import org.springframework.stereotype.Component;
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
    private Double price;
    private Integer power;
    private Double length;
    private Integer MHZ;//核心频率
    private Integer technology;//制作工艺
    private Integer memory;//显存容量
}

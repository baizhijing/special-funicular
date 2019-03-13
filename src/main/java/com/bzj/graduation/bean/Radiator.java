package com.bzj.graduation.bean;

import java.math.BigDecimal;

/**
 * @Author:bai
 * @data:2019/3/13
 * 散热器
 **/
public class Radiator {
    private Integer id;
    private String name;
    private String src;
    private BigDecimal price;
    private double hign;
    private String Intef;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public double getHign() {
        return hign;
    }

    public void setHign(double hign) {
        this.hign = hign;
    }

    public String getIntef() {
        return Intef;
    }

    public void setIntef(String intef) {
        Intef = intef;
    }
}

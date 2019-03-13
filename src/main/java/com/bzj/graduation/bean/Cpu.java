package com.bzj.graduation.bean;

import java.math.BigDecimal;

/**
 * @Author:bai
 * @data:2019/3/13
 **/
public class Cpu {
    private Integer id;
    private String name;
    private int power;
    private String interf;
    private boolean gpu;
    private String src;
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getInterf() {
        return interf;
    }

    public void setInterf(String interf) {
        this.interf = interf;
    }

    public boolean isGpu() {
        return gpu;
    }

    public void setGpu(boolean gpu) {
        this.gpu = gpu;
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
}

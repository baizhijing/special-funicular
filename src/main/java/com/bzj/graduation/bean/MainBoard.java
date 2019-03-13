package com.bzj.graduation.bean;

import java.math.BigDecimal;

/**
 * @Author:bai
 * @data:2019/3/13
 **/
public class MainBoard {
    private Integer id;
    private String name;
    private String type;
    private String cpuInterf;//cpu接口
    private Integer memoryType;
    private Integer memoryNum;
    private Integer sata;
    private Integer m2;
    private Integer power;
    private String src;
    private BigDecimal price;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCpuInterf() {
        return cpuInterf;
    }

    public void setCpuInterf(String cpuInterf) {
        this.cpuInterf = cpuInterf;
    }

    public Integer getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(Integer memoryType) {
        this.memoryType = memoryType;
    }

    public Integer getMemoryNum() {
        return memoryNum;
    }

    public void setMemoryNum(Integer memoryNum) {
        this.memoryNum = memoryNum;
    }

    public Integer getSata() {
        return sata;
    }

    public void setSata(Integer sata) {
        this.sata = sata;
    }

    public Integer getM2() {
        return m2;
    }

    public void setM2(Integer m2) {
        this.m2 = m2;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
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

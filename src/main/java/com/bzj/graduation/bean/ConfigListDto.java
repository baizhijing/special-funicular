package com.bzj.graduation.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
public class ConfigListDto {
    private Integer id;

//    配置单名称
    private String name;

    private Integer userId;

    private Integer cpuId;

    private String cpuName;

    private Integer boxId;

    private String boxName;

    private Integer hardDiskId;

    private String hardDiskName;

    private Integer mainBoardId;

    private String mainBoardName;

    private  Integer memoryId;

    private String memoryName;

    private  Integer powerId;

    private String powerName;

    private Integer radiatorId;

    private String radiatorName;

    private Integer displayId;

    private String displayName;

    private Double price;

}

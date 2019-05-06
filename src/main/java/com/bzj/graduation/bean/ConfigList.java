package com.bzj.graduation.bean;

import lombok.Data;
import org.springframework.stereotype.Component;
/**
 * @Author:bai
 *  * @data:2019/3/13
 **/
@Component
@Data
public class ConfigList {
    private Integer id;

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

    private Integer isPublic;

}

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

    private Integer userId;

    private Integer cpuId;

    private Integer boxId;

    private Integer hardDiskId;

    private Integer mainBoardId;

    private  Integer memoryId;

    private  Integer powerId;

    private Integer radiatorId;

    private Integer displayId;
}

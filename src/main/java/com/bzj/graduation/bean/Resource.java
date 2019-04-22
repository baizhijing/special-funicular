package com.bzj.graduation.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Resource {
    private Integer id;
    private String name;
    private String url;
    private String type;
}

package com.bzj.graduation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GraduationApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void demo1(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
    }
}

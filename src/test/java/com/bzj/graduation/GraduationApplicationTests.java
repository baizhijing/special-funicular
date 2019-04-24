package com.bzj.graduation;

import com.bzj.graduation.dao.BoxDao;
import com.bzj.graduation.dao.DisplayDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GraduationApplicationTests {

    @Autowired
    private BoxDao boxDao;

    @Autowired
    private DisplayDao displayDao;
    @Test
    public void contextLoads() {
        BigDecimal bigDecimal=new BigDecimal("0");
    }

    @Test
    public void demo1(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
    }
}

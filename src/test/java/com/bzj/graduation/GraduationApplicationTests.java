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
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

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
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));//可以对每个时间域单独修改
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int date = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        String monthS,dateS,hourS,minuteS,secondS;
        if (month<10)
            monthS="0"+month;
        else
            monthS= month+"";
        if (date<10)
            dateS="0"+date;
        else
            dateS= date+"";
        if (hour<10)
            hourS="0"+hour;
        else
            hourS= hour+"";
        if (minute<10)
            minuteS="0"+minute;
        else
            minuteS= minute+"";
        if (second<10)
            secondS="0"+second;
        else
            secondS= second+"";
        String nowTime="当前时间："+year+"年"+monthS+"月"+dateS+"日"+" "+hourS+"点"+minuteS+"分"+secondS+"秒";
        System.out.println(nowTime);
        c.setFirstDayOfWeek(Calendar.MONDAY);
        int weekOfYear = c.get(Calendar.WEEK_OF_YEAR);
        String week="今天是"+year+"年的第"+weekOfYear+"周";
        System.out.println(week);
    }

    @Test
    public void hh(){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("hh");
        stringBuilder.append(1);
        System.out.println(stringBuilder);
    }
}

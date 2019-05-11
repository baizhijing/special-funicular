package com.bzj.graduation.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.TimeZone;

@WebServlet(urlPatterns = "/time")
public class TimeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
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
        PrintWriter out=resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println(nowTime);
        out.println("<br>");
        out.println(weekOfYear);
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }
}

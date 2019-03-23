package com.bzj.graduation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GraduationApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public static double max(double... values){
        double largest=Double.NEGATIVE_INFINITY;
        for (double v:values)
            if (v>largest)
                largest=v;
        return largest;
    }

    @Test
    public void demo1(){

    }
}

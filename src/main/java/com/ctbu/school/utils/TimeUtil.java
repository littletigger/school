package com.ctbu.school.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class TimeUtil {

    public static String  formatDate() {
        SimpleDateFormat format=new SimpleDateFormat("MM-dd  E");
        String time=format.format(new Date());
        //System.out.println("当前时间: "+time);
        return time ;

    }
    public static String  formatDate(Date date) {
        SimpleDateFormat format=new SimpleDateFormat("MM-dd E");
        String time=format.format(date);
        //System.out.println("当前时间: "+time);
        return time ;

    }

}

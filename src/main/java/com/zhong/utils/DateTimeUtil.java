package com.zhong.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
    public static String getFormatSystemTime(){
        Date date  = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}

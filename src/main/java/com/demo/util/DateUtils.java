package com.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author 今天不加班
 * @date 2024/3/28 21:14:41
 */
public class DateUtils {

    private DateUtils(){}

    public static Date stringToDate(String timeStr,String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(timeStr);
    }

    public static String dateToString(Date date,String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static String localDateTimeToString(LocalDateTime time,String pattern){
        if (time == null){
            return null;
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        return df.format(time);
    }
}

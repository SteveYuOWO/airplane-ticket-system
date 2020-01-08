package com.littlepage.airplaneticketsystem.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Easily to deal with date
 */
public class DateUtils {
    /**
     * Source to Date
     * @param source
     * @return
     */
    public static Date getDate(String source){
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            date = sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Date to Source
     * @param date
     * @return
     */
    public static String getString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = sdf.format(date);
        return format;
    }
}

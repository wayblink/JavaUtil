package com.way.util;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    static DateFormat SHORT_DF = DateFormat.getDateTimeInstance(  
        DateFormat.SHORT,  
        DateFormat.SHORT);  

    static DateFormat MEDIUM_DF = DateFormat.getDateTimeInstance(  
        DateFormat.MEDIUM,  
        DateFormat.MEDIUM);  

    static DateFormat LONG_DF = DateFormat.getDateTimeInstance(  
        DateFormat.LONG,  
        DateFormat.LONG);  

    static DateFormat FULL_DF = DateFormat.getDateTimeInstance(
        DateFormat.FULL,  
        DateFormat.FULL); 
    
    static SimpleDateFormat SIMPLE_DF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    //9/29/01 8:44 PM    
    public static String shortDate(){
        return SHORT_DF.format(new Date());
    }
    
    //Sep 29, 2001 8:44:45 PM  
    public static String mediumDate(){
        return MEDIUM_DF.format(new Date());
    }
    
    //September 29, 2001 8:44:45 PM EDT  
    public static String longDate(){
        return LONG_DF.format(new Date());
    }
    
    //Saturday, September 29, 2001 8:44:45 PM EDT
    public static String fullDate(){
        return FULL_DF.format(new Date());
    }  
    
    public static String simpleDate(){
        return SIMPLE_DF.format(new Date());
    }  
}

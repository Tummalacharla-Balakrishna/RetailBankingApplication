package com.casestudy.retailbank.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class CurrentDate {
    
    public static String convertDateToString(){
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	   LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
    	    
        
    }
    
}
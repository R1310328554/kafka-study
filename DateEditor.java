package com.lk;

import org.springframework.beans.propertyeditors.PropertiesEditor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEditor extends PropertiesEditor {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    @Override    
    public void setAsText(String text) throws IllegalArgumentException {    
        if (text == null || text.equals("")) {    
            text = "0";    
        }
        Date date = null;
        try {
            date = sdf.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        setValue(date);
    }    
    
    @Override    
    public String getAsText() {    
        return getValue().toString();    
    }    
}
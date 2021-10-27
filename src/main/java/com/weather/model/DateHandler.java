package com.weather.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateHandler {

    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM");

    private String getCurrentDate() {
        Date date = new Date();
        String currentDate = formatter.format(date);
        return currentDate;
    }

    public ArrayList<String> getArrayOfFiveDays() {
        ArrayList<String> arrayOfFiveDays = new ArrayList<String>() {
            {
                add(getCurrentDate());
            }
        };

        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(formatter.parse(getCurrentDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int i=0;
        while(i < 4){
            calendar.add(Calendar.DATE, 1);
            arrayOfFiveDays.add(formatter.format(calendar.getTime()));
            i++;
        }
        return arrayOfFiveDays;
    }
}

package com.weather.model;

import com.weather.App;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateHandler {

    private static SimpleDateFormat formatter = new SimpleDateFormat("E");

    public ArrayList<String> getArrayOfFiveDays() {

        ArrayList<String> arrayOfFiveDays = new ArrayList<String>() {};

        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(formatter.parse(getCurrentDate()));
        } catch (ParseException e) {
            App.showErrorMessage("Wystąpił problem z ustaleniem daty.");
        }

        calendar.add(Calendar.DATE, 0);
        arrayOfFiveDays.add(formatter.format(calendar.getTime()));

        int i=0;
        while(i < 4){
            calendar.add(Calendar.DATE, 1);
            arrayOfFiveDays.add(formatter.format(calendar.getTime()));
            i++;
        }
        return arrayOfFiveDays;
    }

    private static String getCurrentDate() {
        Date date = new Date();
        String currentDate = formatter.format(date);
        return currentDate;
    }
}

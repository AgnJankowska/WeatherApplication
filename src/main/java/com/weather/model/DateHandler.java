package com.weather.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DateHandler {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E \ndd.MM");

    public List<String> createArrayOfFiveDays() {

        List<String> arrayOfFiveDays = new ArrayList<>();
        LocalDate localDate = LocalDate.now();

        int numberOfDaysInForecast = 5;
        for(int i = 0; i< numberOfDaysInForecast; i++){
            arrayOfFiveDays.add(localDate.plusDays(i).format(formatter));
        }
        return arrayOfFiveDays;
    }
}

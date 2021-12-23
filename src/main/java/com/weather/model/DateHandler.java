package com.weather.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DateHandler {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E \ndd.MM");
    private final LocalDate currentDate;

    public DateHandler(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public List<String> createArrayOfFiveDays() {

        List<String> arrayOfFiveDays = new ArrayList<>();

        int numberOfDaysInForecast = 5;
        for(int i = 0; i< numberOfDaysInForecast; i++){
            arrayOfFiveDays.add(currentDate.plusDays(i).format(formatter));
        }
        return arrayOfFiveDays;
    }
}

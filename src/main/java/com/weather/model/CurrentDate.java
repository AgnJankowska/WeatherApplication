package com.weather.model;

import java.time.LocalDate;

public class CurrentDate {

    private final LocalDate currentDate;

    public CurrentDate() {
        this.currentDate = LocalDate.now();
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

}

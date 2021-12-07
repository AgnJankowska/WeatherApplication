package com.weather.model.weatherCondition;

public class SingleCondition {

    private final int id;
    private final MainCondition main;
    private final String description;

    public SingleCondition(int id, MainCondition main, String description) {
        this.id = id;
        this.main = main;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public MainCondition getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }
}


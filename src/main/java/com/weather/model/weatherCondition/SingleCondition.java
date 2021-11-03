package com.weather.model.weatherCondition;

public class SingleCondition {

    private int Id;
    private MainCondition main;
    private String description;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public MainCondition getMain() {
        return main;
    }

    public void setMain(MainCondition main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

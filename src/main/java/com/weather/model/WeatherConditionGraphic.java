package com.weather.model;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class WeatherConditionGraphic {

    private Image clearSky = new Image(getClass().getResourceAsStream("graphics/clear_sky.png"));
    private Image brokenClouds = new Image(getClass().getResourceAsStream("graphics/broken_clouds.png"));
    private Image fewClouds = new Image(getClass().getResourceAsStream("graphics/few_clouds.png"));
    private Image mist = new Image(getClass().getResourceAsStream("graphics/mist.png"));
    private Image rain = new Image(getClass().getResourceAsStream("graphics/rain.png"));
    private Image scatteredClouds = new Image(getClass().getResourceAsStream("graphics/scattered_clouds.png"));
    private Image showerRain = new Image(getClass().getResourceAsStream("graphics/shower_rain.png"));
    private Image snow = new Image(getClass().getResourceAsStream("graphics/snow.png"));
    private Image thunderstorm = new Image(getClass().getResourceAsStream("graphics/thunderstorm.png"));
    private Image notSet = new Image(getClass().getResourceAsStream("graphics/not_set.png"));

    public Image getInitialGraphic() {
       Image image = notSet;
       return image;
    }

    public Image getConditionGraphic(ArrayList<Integer> arrayOfConditions, int i) {

        Image image = null;
        if(arrayOfConditions.get(i) >= 200 && arrayOfConditions.get(i) <= 232)  {
            image = thunderstorm;
        } else if (arrayOfConditions.get(i) >= 300 && arrayOfConditions.get(i) <= 311) {
            image = rain;
        } else if (arrayOfConditions.get(i) >= 312 && arrayOfConditions.get(i) <= 311) {
            image = showerRain;
        } else if (arrayOfConditions.get(i) >= 500 && arrayOfConditions.get(i) <= 504) {
            image = rain;
        } else if (arrayOfConditions.get(i) == 511) {
            image = snow;
        } else if (arrayOfConditions.get(i) >= 520 && arrayOfConditions.get(i) <= 531) {
            image = showerRain;
        } else if (arrayOfConditions.get(i) >= 600 && arrayOfConditions.get(i) <= 622) {
            image = snow;
        } else if (arrayOfConditions.get(i) >= 701 && arrayOfConditions.get(i) <= 781) {
            image = mist;
        } else if (arrayOfConditions.get(i) == 800) {
            image = clearSky;
        } else if (arrayOfConditions.get(i) == 801 || arrayOfConditions.get(i) == 802) {
            image = fewClouds;
        } else if (arrayOfConditions.get(i) == 803) {
            image = scatteredClouds;
        } else if (arrayOfConditions.get(i) == 804) {
            image = brokenClouds;
        } else {
            image = null;
        }
        System.out.println(arrayOfConditions.get(i));
        return image;
    }
}

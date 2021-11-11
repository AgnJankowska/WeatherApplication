package com.weather.model.service;

import com.weather.model.WeatherConditionGraphic;
import com.weather.model.WeatherForecastManager;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphicService extends Service<List<Image>> {

    private WeatherForecastManager weatherForecastManager;
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

    public GraphicService(WeatherForecastManager weatherForecastManager) {
        this.weatherForecastManager = weatherForecastManager;
    }

    @Override
    protected Task<List<Image>> createTask() {
        return new Task<List<Image>>() {
            @Override
            protected List<Image> call() throws Exception {
                ArrayList<Integer> arrayOfConditions = weatherForecastManager.getArrayOfConditions();
                return getConditionGraphic(arrayOfConditions);
            }
        };
    }

    public List<Image> getConditionGraphic(ArrayList<Integer> arrayOfConditions) {

        List<Image> images = null;
        Image image0 = null;
        Image image1 = null;
        Image image2 = null;
        Image image3 = null;
        Image image4 = null;

        for(int i=0; i<5; i++) {
            Image image = null;
            if (arrayOfConditions.get(i) >= 200 && arrayOfConditions.get(i) <= 232) {
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

            switch(i) {
                case 0:
                    image0 = image;
                    break;
                case 1:
                    image1 = image;
                    break;
                case 2:
                    image2 = image;
                    break;
                case 3:
                    image3 = image;
                    break;
                case 4:
                    image4 = image;
                    break;
            }
        }
        images = Arrays.asList(image0, image1, image2, image3, image4);
        return images;
    }
}

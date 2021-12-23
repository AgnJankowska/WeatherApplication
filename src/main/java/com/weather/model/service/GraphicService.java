package com.weather.model.service;

import com.weather.model.WeatherForecastFor5Days;
import com.weather.model.forecastComponent.RootWeather;
import com.weather.model.weatherCondition.MainCondition;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.image.Image;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GraphicService extends Service<List<Image>> {

    public GraphicService(RootWeather weatherObject) {
        this.weatherObject = weatherObject;
    }

    private final RootWeather weatherObject;
    private final Image clearSky = new Image(Objects.requireNonNull(getClass().getResourceAsStream("graphics/clear_sky.png")));
    private final Image brokenClouds = new Image(Objects.requireNonNull(getClass().getResourceAsStream("graphics/broken_clouds.png")));
    private final Image fewClouds = new Image(Objects.requireNonNull(getClass().getResourceAsStream("graphics/few_clouds.png")));
    private final Image mist = new Image(Objects.requireNonNull(getClass().getResourceAsStream("graphics/mist.png")));
    private final Image rain = new Image(Objects.requireNonNull(getClass().getResourceAsStream("graphics/rain.png")));
    private final Image scatteredClouds = new Image(Objects.requireNonNull(getClass().getResourceAsStream("graphics/scattered_clouds.png")));
    private final Image showerRain = new Image(Objects.requireNonNull(getClass().getResourceAsStream("graphics/shower_rain.png")));
    private final Image snow = new Image(Objects.requireNonNull(getClass().getResourceAsStream("graphics/snow.png")));
    private final Image thunderstorm = new Image(Objects.requireNonNull(getClass().getResourceAsStream("graphics/thunderstorm.png")));

    @Override
    protected Task<List<Image>> createTask() {
        return new Task<>() {
            @Override
            protected List<Image> call() {
                WeatherForecastFor5Days weatherForecastFor5Days = new WeatherForecastFor5Days();
                List<MainCondition> arrayOfConditions = weatherForecastFor5Days.getArrayOfConditions(weatherObject);
                return getListOfImage(arrayOfConditions);
            }
        };
    }

    public List<Image> getListOfImage(List<MainCondition> arrayOfConditions) {

        List<Image> images;
        Image image0 = null;
        Image image1 = null;
        Image image2 = null;
        Image image3 = null;
        Image image4 = null;

        int numberOfDayInForecast = 5;
        for(int i = 0; i< numberOfDayInForecast; i++) {
            Image image = getSingleImage(arrayOfConditions, i);

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

    private Image getSingleImage(List<MainCondition> arrayOfConditions, int i){
        Image image = null;
        switch (arrayOfConditions.get(i)) {
            case THUNDERSTORM:
                image = thunderstorm;
                break;
            case MIST:
                image = mist;
                break;
            case FEW_CLOUDS:
                image = fewClouds;
                break;
            case SHOWER_RAIN:
                image = showerRain;
                break;
            case BROKEN_CLOUDS:
                image = brokenClouds;
                break;
            case SCATTERED_CLOUDS:
                image = scatteredClouds;
                break;
            case RAIN:
                image = rain;
                break;
            case SNOW:
                image = snow;
                break;
            case CLEAR:
                image = clearSky;
                break;
        }
        return image;
    }


}

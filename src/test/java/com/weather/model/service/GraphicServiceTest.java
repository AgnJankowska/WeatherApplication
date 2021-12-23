package com.weather.model.service;

import com.weather.model.WeatherForecastFor5Days;
import com.weather.model.forecastComponent.Daily;
import com.weather.model.forecastComponent.RootWeather;
import com.weather.model.forecastComponent.Temp;
import com.weather.model.forecastComponent.Weather;
import com.weather.model.weatherCondition.MainCondition;
import javafx.scene.image.Image;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GraphicServiceTest {

    @Test
    void taskShouldReturnListOfDifferentImagesForDifferentCondition() {
        //given
        Temp temp1 = new Temp(32);
        Weather weather1 = new Weather(200);
        Weather weather2 = new Weather(300);
        Weather weather3 = new Weather(800);
        Weather weather4 = new Weather(701);
        Weather weather5 = new Weather(600);

        List<Weather> weatherList1 = new ArrayList<>();
        List<Weather> weatherList2 = new ArrayList<>();
        List<Weather> weatherList3 = new ArrayList<>();
        List<Weather> weatherList4 = new ArrayList<>();
        List<Weather> weatherList5 = new ArrayList<>();

        weatherList1.add(weather1);
        weatherList2.add(weather2);
        weatherList3.add(weather3);
        weatherList4.add(weather4);
        weatherList5.add(weather5);

        Daily daily1 = new Daily(temp1, weatherList1);
        Daily daily2 = new Daily(temp1, weatherList2);
        Daily daily3 = new Daily(temp1, weatherList3);
        Daily daily4 = new Daily(temp1, weatherList4);
        Daily daily5 = new Daily(temp1, weatherList5);

        List<Daily> dailyList = new ArrayList<Daily>(List.of(daily1, daily2, daily3, daily4, daily5));

        RootWeather weatherObject = new RootWeather(dailyList);
        GraphicService graphicService = new GraphicService(weatherObject);
        WeatherForecastFor5Days weatherForecastFor5Days = new WeatherForecastFor5Days();
        List<MainCondition> arrayOfConditions = weatherForecastFor5Days.getArrayOfConditions(weatherObject);

        //when
        List<Image> listOfImage = graphicService.getListOfImage(arrayOfConditions);

        //then
        Assertions.assertAll(() -> {
            assertThat(listOfImage, hasSize(5));
            assertThat(listOfImage.get(0), allOf(not(sameInstance(listOfImage.get(1))), not(sameInstance(listOfImage.get(2))), not(sameInstance(listOfImage.get(3))), not(sameInstance(listOfImage.get(4)))));
            assertThat(listOfImage.get(1), allOf(not(sameInstance(listOfImage.get(0))), not(sameInstance(listOfImage.get(2))), not(sameInstance(listOfImage.get(3))), not(sameInstance(listOfImage.get(4)))));
            assertThat(listOfImage.get(2), allOf(not(sameInstance(listOfImage.get(1))), not(sameInstance(listOfImage.get(0))), not(sameInstance(listOfImage.get(3))), not(sameInstance(listOfImage.get(4)))));
            assertThat(listOfImage.get(3), allOf(not(sameInstance(listOfImage.get(1))), not(sameInstance(listOfImage.get(2))), not(sameInstance(listOfImage.get(0))), not(sameInstance(listOfImage.get(4)))));
            assertThat(listOfImage.get(4), allOf(not(sameInstance(listOfImage.get(1))), not(sameInstance(listOfImage.get(2))), not(sameInstance(listOfImage.get(3))), not(sameInstance(listOfImage.get(0)))));
        });
    }

    @Test
    void taskShouldReturnListOfTheSameImagesForTheSameCondition() {
        //given
        Temp temp1 = new Temp(32);
        Weather weather1 = new Weather(200);
        Weather weather2 = new Weather(200);
        Weather weather3 = new Weather(200);
        Weather weather4 = new Weather(200);
        Weather weather5 = new Weather(200);

        List<Weather> weatherList1 = new ArrayList<>();
        List<Weather> weatherList2 = new ArrayList<>();
        List<Weather> weatherList3 = new ArrayList<>();
        List<Weather> weatherList4 = new ArrayList<>();
        List<Weather> weatherList5 = new ArrayList<>();

        weatherList1.add(weather1);
        weatherList2.add(weather2);
        weatherList3.add(weather3);
        weatherList4.add(weather4);
        weatherList5.add(weather5);

        Daily daily1 = new Daily(temp1, weatherList1);
        Daily daily2 = new Daily(temp1, weatherList2);
        Daily daily3 = new Daily(temp1, weatherList3);
        Daily daily4 = new Daily(temp1, weatherList4);
        Daily daily5 = new Daily(temp1, weatherList5);

        List<Daily> dailyList = new ArrayList<Daily>(List.of(daily1, daily2, daily3, daily4, daily5));

        RootWeather weatherObject = new RootWeather(dailyList);
        GraphicService graphicService = new GraphicService(weatherObject);
        WeatherForecastFor5Days weatherForecastFor5Days = new WeatherForecastFor5Days();
        List<MainCondition> arrayOfConditions = weatherForecastFor5Days.getArrayOfConditions(weatherObject);

        //when
        List<Image> listOfImage = graphicService.getListOfImage(arrayOfConditions);

        //then
        Assertions.assertAll(() -> {
            assertThat(listOfImage, hasSize(5));
            assertThat(listOfImage.get(0), allOf((sameInstance(listOfImage.get(1))), (sameInstance(listOfImage.get(2))), (sameInstance(listOfImage.get(3))), (sameInstance(listOfImage.get(4)))));
            assertThat(listOfImage.get(1), allOf((sameInstance(listOfImage.get(0))), (sameInstance(listOfImage.get(2))), (sameInstance(listOfImage.get(3))), (sameInstance(listOfImage.get(4)))));
            assertThat(listOfImage.get(2), allOf((sameInstance(listOfImage.get(1))), (sameInstance(listOfImage.get(0))), (sameInstance(listOfImage.get(3))), (sameInstance(listOfImage.get(4)))));
            assertThat(listOfImage.get(3), allOf((sameInstance(listOfImage.get(1))), (sameInstance(listOfImage.get(2))), (sameInstance(listOfImage.get(0))), (sameInstance(listOfImage.get(4)))));
            assertThat(listOfImage.get(4), allOf((sameInstance(listOfImage.get(1))), (sameInstance(listOfImage.get(2))), (sameInstance(listOfImage.get(3))), (sameInstance(listOfImage.get(0)))));
        });
    }
}
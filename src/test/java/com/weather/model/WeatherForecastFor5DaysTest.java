package com.weather.model;

import com.weather.model.forecastComponent.Daily;
import com.weather.model.forecastComponent.RootWeather;
import com.weather.model.forecastComponent.Temp;
import com.weather.model.forecastComponent.Weather;
import com.weather.model.weatherCondition.MainCondition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class WeatherForecastFor5DaysTest {

    private static WeatherForecastManager weatherForecastManager;

    @BeforeAll
    static void setWeatherCondition() {
        Temp temp1 = new Temp(32);
        Temp temp2 = new Temp(28);

        Weather weather1 = new Weather(800);
        Weather weather2 = new Weather(500);

        List<Weather> weatherList1 = new ArrayList<>();
        List<Weather> weatherList2 = new ArrayList<>();

        weatherList1.add(weather1);
        weatherList2.add(weather2);

        Daily daily1 = new Daily(temp1, weatherList1);
        Daily daily2 = new Daily(temp2, weatherList2);

        List<Daily> dailyList = new ArrayList<>();
        dailyList.add(daily1);
        dailyList.add(daily1);
        dailyList.add(daily1);
        dailyList.add(daily2);
        dailyList.add(daily2);

        weatherForecastManager = new WeatherForecastManager(new RootWeather(dailyList));
    }

    @Test
    void arrayOfTemperatureShouldBeInCorrectSizeAndFormat() {
        //given
        WeatherForecastFor5Days weatherForecastFor5Days = new WeatherForecastFor5Days();

        //when
        List<String> arrayOfTemperature = weatherForecastFor5Days.getArrayOfTemperature(weatherForecastManager.getWeatherObject());

        //then
        assertThat(arrayOfTemperature, contains("32", "32", "32", "28", "28"));
    }

    @Test
    void arrayOfConditionShouldBeInCorrectSizeAndFormat() {
        //given
        WeatherForecastFor5Days weatherForecastFor5Days = new WeatherForecastFor5Days();

        //when
        List<MainCondition> arrayOfConditions = weatherForecastFor5Days.getArrayOfConditions(weatherForecastManager.getWeatherObject());

        //then
        assertThat(arrayOfConditions, contains(MainCondition.CLEAR, MainCondition.CLEAR, MainCondition.CLEAR, MainCondition.RAIN, MainCondition.RAIN));
    }

    @Test
    void arrayOfDescriptionShouldBeInCorrectSizeAndFormat() {
        //given
        WeatherForecastFor5Days weatherForecastFor5Days = new WeatherForecastFor5Days();

        //when
        List<String> arrayOfDescription = weatherForecastFor5Days.getArrayOfDescription(weatherForecastManager.getWeatherObject());

        //then
        assertThat(arrayOfDescription, contains("czyste niebo", "czyste niebo", "czyste niebo", "lekkie opady deszczu", "lekkie opady deszczu"));
    }
}
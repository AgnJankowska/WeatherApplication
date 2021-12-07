package com.weather.model;

import com.weather.model.forecastComponent.Daily;
import com.weather.model.forecastComponent.RootWeather;
import com.weather.model.forecastComponent.Temp;
import com.weather.model.forecastComponent.Weather;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class WeatherForecastManagerTest {

    @Test
    void constructorShouldCreateWeatherObject() {
        //given
        Temp temp1 = new Temp(32);
        Weather weather1 = new Weather(800);
        List<Weather> weatherList1 = new ArrayList<>();
        weatherList1.add(weather1);
        Daily daily1 = new Daily(temp1, weatherList1);

        List<Daily> dailyList = new ArrayList<>();
        dailyList.add(daily1);
        dailyList.add(daily1);
        dailyList.add(daily1);
        dailyList.add(daily1);
        dailyList.add(daily1);

        RootWeather weatherObject = new RootWeather(dailyList);

        //when
        WeatherForecastManager weatherForecastManager = new WeatherForecastManager(weatherObject);

        //then
        assertThat(weatherForecastManager.getWeatherObject(), is(notNullValue()));
        assertThat(weatherForecastManager.getWeatherObject(), equalTo(weatherObject));
        assertThat(weatherForecastManager.getWeatherObject(), sameInstance(weatherObject));
    }
}
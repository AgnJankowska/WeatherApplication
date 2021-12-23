package com.weather.model.service;

import com.weather.App;
import com.weather.model.forecastComponent.RootWeather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WeatherServiceTest {




    @Test
    void taskShouldReturnWeatherData() throws Exception {
        //given
        URL url = this.getClass().getResource("weatherTest.json");

        //when
        WeatherService.WeatherTask weatherTask = new WeatherService.WeatherTask(url);
        RootWeather result = weatherTask.call();

        //then
        Assertions.assertAll(() -> {

            assertThat(result.getDaily().get(0).getTemp().getMax(), equalTo(23.0));
            assertThat(result.getDaily().get(0).getWeather().get(0).getId(), equalTo(800));
            assertThat(result.getDaily().get(1).getTemp().getMax(), equalTo(25.5));
            assertThat(result.getDaily().get(1).getWeather().get(0).getId(), equalTo(221));
            assertThat(result.getDaily().get(2).getTemp().getMax(), equalTo(21.0));
            assertThat(result.getDaily().get(2).getWeather().get(0).getId(), equalTo(520));
            assertThat(result.getDaily().get(3).getTemp().getMax(), equalTo(22.3));
            assertThat(result.getDaily().get(3).getWeather().get(0).getId(), equalTo(701));
            assertThat(result.getDaily().get(4).getTemp().getMax(), equalTo(18.5));
            assertThat(result.getDaily().get(4).getWeather().get(0).getId(), equalTo(803));
        });
    }

    @Test
    void taskShouldReturnExceptionIfThereIsNoFileAndReturnNull() throws Exception {
        //given
        URL url = this.getClass().getResource("");

        //when
        WeatherService.WeatherTask weatherTask = new WeatherService.WeatherTask(url);

        //then
        Assertions.assertAll(() -> {
            assertThrows(ExceptionInInitializerError.class, weatherTask::call);
        });
    }
}
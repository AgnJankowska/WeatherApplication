package com.weather.model.forecastComponent;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WeatherTest {

    @Test
    void correctIdShouldReturnThisId() {
        //given
        int id = 800;

        //when
        Weather weather = new Weather(id);

        //then
        assertThat(weather.getId(), equalTo(id));
    }

    @Test
    void incorrectIdShouldThrowException() {
        //given
        int id = 1;

        //when
        Weather weather = new Weather(id);

        //then
        assertThrows(IllegalStateException.class, weather::getId);
    }
}
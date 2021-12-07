package com.weather.model.forecastComponent;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WeatherTest {

    @Test
    void correctIdShouldReturnThisId() {
        //when
        int id = 800;
        Weather weather = new Weather(id);

        //then
        assertThat(weather.getId(), equalTo(id));
    }

    @Test
    void incorrectIdShouldThrowException() {
        //when
        int id = 1;
        Weather weather = new Weather(id);

        //then
        assertThrows(IllegalStateException.class, weather::getId);
    }
}
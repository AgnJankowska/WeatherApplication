package com.weather.model;
import com.weather.model.privateKey.WeatherKey;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class CreateURLTest {

    @Test
    void URLShouldBeCorrectForGivenData() {
        //given
        double longitude = 50.55;
        double latitude = 60.55;
        String weatherKey = WeatherKey.getApiKey();

        String givenURL = "https://api.openweathermap.org/data/2.5/onecall?&lat=60.55&lon=50.55&units=metric"+weatherKey+"&exclude=current,minutely,hourly";

        //when
        URLWeather createURL = new URLWeather(longitude, latitude);

        //then
        assertThat(createURL.getUrl(), equalTo(givenURL));
    }

    @Test
    void URLShouldBeCorrectForZeroData() {
        //given
        double longitude = 0;
        double latitude = 0;
        String weatherKey = WeatherKey.getApiKey();

        String givenURL = "https://api.openweathermap.org/data/2.5/onecall?&lat=0.0&lon=0.0&units=metric"+weatherKey+"&exclude=current,minutely,hourly";

        //when
        URLWeather createURL = new URLWeather(longitude, latitude);

        //then
        assertThat(createURL.getUrl(), equalTo(givenURL));
    }
}
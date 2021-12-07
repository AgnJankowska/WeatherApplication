package com.weather.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class CityTest {

    @Test
    void constructorShouldCreateCityObject() {
        //given
        String name = "City1";
        Integer country_id = 1;
        Double latitude = 60.4;
        Double longitude = 50.4;

        //when
        City city = new City(name, country_id, latitude, longitude);

        //then
        assertThat(city, is(notNullValue()));
        assertThat(city.getName(), equalTo("City1"));
        assertThat(city.getCountryId(), equalTo(1));
        assertThat(city.getLatitude(), equalTo(60.4));
        assertThat(city.getLongitude(), equalTo(50.4));
    }
}
package com.weather.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    @Test
    void constructorShouldCreateCountryObject() {
        //given
        String name = "Country1";
        Integer id = 1;
        Double latitude = 60.4;
        Double longitude = 50.4;

        //when
        Country country = new Country(name, id, latitude, longitude);

        //then
        assertThat(country, is(notNullValue()));
        assertThat(country.getName(), equalTo("Country1"));
        assertThat(country.getId(), equalTo(1));
        assertThat(country.getLatitude(), equalTo(60.4));
        assertThat(country.getLongitude(), equalTo(50.4));
    }

}
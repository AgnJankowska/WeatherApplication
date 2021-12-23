package com.weather.model.service;

import com.google.gson.JsonSyntaxException;
import com.weather.model.City;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CitiesListServiceTest {

    @Test
    void taskShouldReturnArrayOfCities() {
        //given
        URL url = this.getClass().getResource("citiesTest.json");

        //when
        CitiesListService.CitiesTask citiesTask = new CitiesListService.CitiesTask(url);
        List<City> result = citiesTask.call();

        //then
        Assertions.assertAll(() -> {
            assertThat(result, hasSize(3));
            assertThat(result.get(0).getName(), equalTo("Jurm"));
            assertThat(result.get(0).getCountryId(), equalTo(1));
            assertThat(result.get(0).getLongitude(), equalTo(70.83421));
            assertThat(result.get(0).getLatitude(), equalTo(36.86477));

            assertThat(result.get(1).getName(), equalTo("Tuchola"));
            assertThat(result.get(1).getCountryId(), equalTo(176));
            assertThat(result.get(1).getLongitude(), equalTo(17.85905000));
            assertThat(result.get(1).getLatitude(), equalTo(53.58792000));

            assertThat(result.get(2).getName(), equalTo("Lazurne"));
            assertThat(result.get(2).getCountryId(), equalTo(230));
            assertThat(result.get(2).getLongitude(), equalTo(32.52955000));
            assertThat(result.get(2).getLatitude(), equalTo(46.08400000));
        });
    }

    @Test
    void taskShouldReturnExceptionIfThereIsNoFile() {
        //given
        URL url = this.getClass().getResource("");

        //when
        CitiesListService.CitiesTask citiesTask = new CitiesListService.CitiesTask(url);

        //then
        Assertions.assertAll(() -> {
            assertThrows(JsonSyntaxException.class, citiesTask::call);
        });
    }
}
package com.weather.model.service;

import com.google.gson.JsonSyntaxException;
import com.weather.model.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CountriesListServiceTest {

    @Test
    void taskShouldReturnArrayOfCities() {
        //given
        URL url = this.getClass().getResource("countriesTest.json");

        //when
        CountriesListService.CountriesTask countriesTask = new CountriesListService.CountriesTask(url);
        List<Country> result = countriesTask.call();

        //then
        Assertions.assertAll(() -> {
            assertThat(result, hasSize(3));
            assertThat(result.get(0).getName(), equalTo("Afghanistan"));
            assertThat(result.get(0).getId(), equalTo(1));
            assertThat(result.get(0).getLongitude(), equalTo(65.0));
            assertThat(result.get(0).getLatitude(), equalTo(33.0));

            assertThat(result.get(1).getName(), equalTo("Indonesia"));
            assertThat(result.get(1).getId(), equalTo(102));
            assertThat(result.get(1).getLongitude(), equalTo(120.0));
            assertThat(result.get(1).getLatitude(), equalTo(-5.0));

            assertThat(result.get(2).getName(), equalTo("Panama"));
            assertThat(result.get(2).getId(), equalTo(170));
            assertThat(result.get(2).getLongitude(), equalTo(-80.0));
            assertThat(result.get(2).getLatitude(), equalTo(9.0));
        });
    }

    @Test
    void taskShouldReturnExceptionIfThereIsNoFile() {
        //given
        URL url = this.getClass().getResource("");

        //when
        CountriesListService.CountriesTask countriesTask = new CountriesListService.CountriesTask(url);

        //then
        Assertions.assertAll(() -> {
            assertThrows(JsonSyntaxException.class, countriesTask::call);
        });
    }

}
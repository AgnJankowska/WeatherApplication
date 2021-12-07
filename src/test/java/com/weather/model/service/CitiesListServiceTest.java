package com.weather.model.service;

import com.weather.model.City;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CitiesListServiceTest {

    //próbowałam przetestować klasy z katalogu service
    //jednak miałam problem z uzyskaniem wyników jakie zwraca metoda getValue()
    //poniżej wklejam mój sposób rozumowania i prosze o pomoc w jaki sposób zrobić to poprawnie


/*    @Test
    void taskShouldReturnArrayOfCities() {
        //given
        City city1 = new City("city1", 1, 13.0, 19.0);
        City city2 = new City("city2", 1, 14.0, 20.0);
        City city3 = new City("city3", 1, 15.0, 21.0);
        List<City> cities = List.of(city1, city2, city3);

        CitiesListService citiesListService = mock(CitiesListService.class);
        when(citiesListService.createCityListFromJSON()).thenReturn(cities);

        //when
        citiesListService.start();

        //then
        citiesListService.setOnSucceeded(e -> {
            assertThat(citiesListService.getValue(), equalTo(cities));
            assertThat(citiesListService.getValue(), hasSize(3));
        });
    }*/
}
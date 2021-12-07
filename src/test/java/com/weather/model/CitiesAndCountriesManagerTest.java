package com.weather.model;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class CitiesAndCountriesManagerTest {

    private static Country country1;
    private static Country country2;
    private static City city1inCountry1;
    private static City city2inCountry1;
    private static City city1inCountry2;
    private static City city2inCountry2;

    @BeforeAll
    static void createCitiesAndCountries() {
        country1 = new Country("country1", 1, 11.0, 17.0);
        country2 = new Country("country2", 2, 12.0, 18.0);
        city1inCountry1 = new City("city1inCountry1", 1, 13.0, 19.0);
        city2inCountry1 = new City("city2inCountry1", 1, 14.0, 20.0);
        city1inCountry2 = new City("city1inCountry2", 2, 15.0, 21.0);
        city2inCountry2 = new City("city2inCountry2", 2, 16.0, 22.0);
    }

    @Test
    void observableList1ShouldContainOnlyCitiesOfSelectedCountry() {
        //given
        List<Country> allCountriesList = new ArrayList<>();
        List<City> allCitiesList = new ArrayList<>();

        allCountriesList.add(country1);
        allCountriesList.add(country2);
        allCitiesList.add(city1inCountry1);
        allCitiesList.add(city2inCountry1);
        allCitiesList.add(city1inCountry2);
        allCitiesList.add(city2inCountry2);

        CitiesAndCountriesManager citiesAndCountriesManager = new CitiesAndCountriesManager(allCountriesList, allCitiesList);

        //when
        String selectedCountry = "country1";
        ObservableList<String> observableList = citiesAndCountriesManager.getObservableList1(selectedCountry);

        //then
        assertThat(observableList, hasSize(3));
        assertThat(observableList, not(contains(city1inCountry2, city2inCountry2)));
        assertThat(observableList, contains("Cały kraj", "city1inCountry1", "city2inCountry1"));
    }

    @Test
    void observableList2ShouldContainOnlyCitiesOfSelectedCountry() {
        //given
        List<Country> allCountriesList = new ArrayList<>();
        List<City> allCitiesList = new ArrayList<>();

        allCountriesList.add(country1);
        allCountriesList.add(country2);
        allCitiesList.add(city1inCountry1);
        allCitiesList.add(city2inCountry1);
        allCitiesList.add(city1inCountry2);
        allCitiesList.add(city2inCountry2);

        CitiesAndCountriesManager citiesAndCountriesManager = new CitiesAndCountriesManager(allCountriesList, allCitiesList);

        //when
        String selectedCountry = "country2";
        ObservableList<String> observableList = citiesAndCountriesManager.getObservableList2(selectedCountry);

        //then
        assertThat(observableList, hasSize(3));
        assertThat(observableList, not(contains(city1inCountry2, city2inCountry2)));
        assertThat(observableList, contains("Cały kraj", "city1inCountry2", "city2inCountry2"));
    }

    @Test
    void observableList1ShouldContainOnlyOneElementsIfThereIsNoCities() {
        //given
        List<Country> allCountriesList = new ArrayList<>();
        List<City> allCitiesList = new ArrayList<>();

        allCountriesList.add(country1);
        allCountriesList.add(country2);

        CitiesAndCountriesManager citiesAndCountriesManager = new CitiesAndCountriesManager(allCountriesList, allCitiesList);

        //when
        String selectedCountry = "country1";
        ObservableList<String> observableList = citiesAndCountriesManager.getObservableList1(selectedCountry);

        //then
        assertThat(observableList, hasSize(1));
        assertThat(observableList, contains("Cały kraj"));
    }

    @Test
    void observableList2ShouldContainOnlyOneElementsIfThereIsNoCities() {
        //given
        List<Country> allCountriesList = new ArrayList<>();
        List<City> allCitiesList = new ArrayList<>();

        allCountriesList.add(country1);
        allCountriesList.add(country2);

        CitiesAndCountriesManager citiesAndCountriesManager = new CitiesAndCountriesManager(allCountriesList, allCitiesList);

        //when
        String selectedCountry = "country2";
        ObservableList<String> observableList = citiesAndCountriesManager.getObservableList2(selectedCountry);

        //then
        assertThat(observableList, hasSize(1));
        assertThat(observableList, contains("Cały kraj"));
    }

    @Test
    void coordinateOfLocationShouldBeSetBySelectedCity() throws IOException {
        //given
        List<Country> allCountriesList = new ArrayList<>();
        List<City> allCitiesList = new ArrayList<>();

        allCountriesList.add(country1);
        allCitiesList.add(city1inCountry1);

        CitiesAndCountriesManager citiesAndCountriesManager = new CitiesAndCountriesManager(allCountriesList, allCitiesList);

        //when
        String selectedCityId1 = "comboBoxCities1";
        String selectedCityId2 = "comboBoxCities2";
        String selectedCityName = "city1inCountry1";
        String selectedCountryName = "country1";

        City city1 = citiesAndCountriesManager.getCoordinate(selectedCityId1, selectedCityName, selectedCountryName);
        City city2 = citiesAndCountriesManager.getCoordinate(selectedCityId2, selectedCityName, selectedCountryName);

        //then
        assertThat(city1.getLatitude(), equalTo(13.0));
        assertThat(city1.getLongitude(), equalTo(19.0));
        assertThat(city2.getLatitude(), equalTo(13.0));
        assertThat(city2.getLongitude(), equalTo(19.0));
    }

    @Test
    void coordinateOfLocationShouldBeSetBySelectedCountryIfThereIsNoCity() throws IOException {
        //given
        List<Country> allCountriesList = new ArrayList<>();
        List<City> allCitiesList = new ArrayList<>();

        allCountriesList.add(country1);
        allCitiesList.add(city1inCountry1);

        CitiesAndCountriesManager citiesAndCountriesManager = new CitiesAndCountriesManager(allCountriesList, allCitiesList);

        //when
        String selectedCityId1 = "comboBoxCities1";
        String selectedCityId2 = "comboBoxCities2";
        String selectedCityName = "Cały kraj";
        String selectedCountryName = "country1";

        City city1 = citiesAndCountriesManager.getCoordinate(selectedCityId1, selectedCityName, selectedCountryName);
        City city2 = citiesAndCountriesManager.getCoordinate(selectedCityId2, selectedCityName, selectedCountryName);

        //then
        assertThat(city1.getLatitude(), equalTo(11.0));
        assertThat(city1.getLongitude(), equalTo(17.0));
        assertThat(city2.getLatitude(), equalTo(11.0));
        assertThat(city2.getLongitude(), equalTo(17.0));
    }
}
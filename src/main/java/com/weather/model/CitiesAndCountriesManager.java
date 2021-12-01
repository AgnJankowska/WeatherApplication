package com.weather.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CitiesAndCountriesManager {

    private List<City> cities1;
    private List<City> cities2;
    private final List<Country> allCountriesList;
    private final List<City> allCitiesList;

    public CitiesAndCountriesManager(List<Country> countriesList, List<City> citiesList) {
        this.cities1 = new ArrayList<>();
        this.cities2 = new ArrayList<>();
        this.allCountriesList = countriesList;
        this.allCitiesList = citiesList;
    }

    public List<City> getCities1() {
        return cities1;
    }
    public List<City> getCities2() {
        return cities2;
    }

    public void setCities1(String selectedCountry) {
        this.cities1 = getCitiesOfSelectedCountry(selectedCountry);
    }
    public void setCities2(String selectedCountry) {
        this.cities2 = getCitiesOfSelectedCountry(selectedCountry);
    }

    public ObservableList<String> getObservableList1(String selectedCountry) {
        setCities1(selectedCountry);
        List<String> citiesName = addCitiesToArrayOfName(getCities1());
        return createSortedObservableList(citiesName);
    }

    public ObservableList<String> getObservableList2(String selectedCountry) {
        setCities2(selectedCountry);
        List<String> citiesName = addCitiesToArrayOfName(getCities2());
        return createSortedObservableList(citiesName);
    }

    private ObservableList<String> createSortedObservableList(List<String> citiesName) {
        Collections.sort(citiesName);
        return FXCollections.observableList(citiesName);
    }

    public City getCoordinate(String selectedCityId, String selectedCityName, String selectedCountryName) throws IOException {
        List<City> cities = new ArrayList<>();
        City city = null;

        if(selectedCityId.equals("comboBoxCities1")) {
            setCities1(selectedCountryName);
            cities = getCities1();
        } else if(selectedCityId.equals("comboBoxCities2")) {
            setCities2(selectedCountryName);
            cities = getCities2();
        }

        for(City city1 : cities) {
            if(selectedCityName.equals(city1.getName())){
                city = new City(city1.getName(), city1.getCountryId(), city1.getLatitude(), city1.getLongitude());
            }
        }
        return city;
    }

    private List<String> addCitiesToArrayOfName(List<City> cities) {
        List<String> citiesName = new ArrayList<>();

        for(City city : cities) {
            citiesName.add(city.getName());
        }
        return citiesName;
    }

    private List<City> getCitiesOfSelectedCountry(String countryName) {
        List<City> citiesOfSelectedCountry = new ArrayList<>();
        Integer countryId = getSelectedCountryId(countryName);

        for(City city : allCitiesList) {
            if(city.getCountryId().equals(countryId)) {
                citiesOfSelectedCountry.add(city);
            }
        }
        citiesOfSelectedCountry.add(getFirstElementOfList(countryName));
        return citiesOfSelectedCountry;
    }

    private Integer getSelectedCountryId(String countryName) {
        Integer countryId = 0;

        for(Country country : allCountriesList) {
            if(country.getName().equals(countryName)) {
                countryId = country.getId();
            }
        }
        return countryId;
    }

    private City getFirstElementOfList(String countryName) {

        City representationOfWholeCountry = null;

        for(Country country : allCountriesList) {
            if(country.getName().equals(countryName)) {
                String name = "Cały kraj";
                int id = country.getId();
                double latitude = country.getLatitude();
                double longitude = country.getLongitude();

                representationOfWholeCountry = new City(name, id, latitude, longitude);
            }
        }
        return representationOfWholeCountry;
    }



}

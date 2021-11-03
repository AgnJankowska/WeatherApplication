package com.weather.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class CitiesAndCountries {

    private ArrayList<City> cities1;
    private ArrayList<City> cities2;
    private JSONReaderLocation jsonReader;

    public CitiesAndCountries() {
        this.cities1 = new ArrayList<>();
        this.cities2 = new ArrayList<>();
        this.jsonReader = new JSONReaderLocation();
    }

    public ArrayList<City> getCities1() {
        return cities1;
    }

    public void setCities1(String selectedCountry) {
        this.cities1 = jsonReader.getCitiesOfSelectedCountry(selectedCountry);
    }

    public ArrayList<City> getCities2() {
        return cities2;
    }

    public void setCities2(String selectedCountry) {
        this.cities2 = jsonReader.getCitiesOfSelectedCountry(selectedCountry);
    }

    public ObservableList<String> getObservableList1(String selectedCountry) {

        setCities1(selectedCountry);
        ArrayList<String> citiesName = addCitiesToArrayOfName(getCities1());
        ObservableList<String> observableListCities = createSortedObservableList(citiesName);

        return observableListCities;
    }

    public ObservableList<String> getObservableList2(String selectedCountry) {

        setCities2(selectedCountry);
        ArrayList<String> citiesName = addCitiesToArrayOfName(getCities2());
        ObservableList<String> observableListCities = createSortedObservableList(citiesName);

        return observableListCities;
    }

    public City getCoordinate(String selectedCityId, String selectedCityName) throws IOException {
        ArrayList<City> cities;
        City city = new City();

        cities = (selectedCityId.equals("comboBoxCities1")) ? getCities1() : getCities2();

        int i=0;
        while(i<cities.size()){
            if(selectedCityName.equals(cities.get(i).getName())){
                city.setName(cities.get(i).getName());
                city.setId(cities.get(i).getId());
                city.setLatitude(cities.get(i).getLatitude());
                city.setLongitude(cities.get(i).getLongitude());
            }
            i++;
        }
        return city;
    }

    private ArrayList<String> addCitiesToArrayOfName(ArrayList<City> cities) {
        ArrayList<String> citiesName = new ArrayList<>();
        int i = 0;
        while (i < cities.size()) {
            citiesName.add(cities.get(i).getName());
            i++;
        }
        return citiesName;
    }

    private ObservableList<String> createSortedObservableList(ArrayList<String> citiesName) {
        Collections.sort(citiesName);
        ObservableList<String> observableListCities = FXCollections.observableList(citiesName);
        return observableListCities;
    }
}

package com.weather.model;

import com.weather.model.auxiliaryClasses.StringFromList;
import com.weather.model.service.CountriesObservableListService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JSONReaderLocation{

    private String urlCities = "src/main/resources/com/weather/model/cities.json";
    private String urlCounties = "src/main/resources/com/weather/model/countries.json";

    public ArrayList<City> getCitiesOfSelectedCountry(String country) {
        ArrayList<City> cities = new ArrayList<City>();
        Integer countryId = getSelectedCountryId(country);

        try {
            List<String> listOfCities = Files.readAllLines(Paths.get(urlCities), StandardCharsets.UTF_8);
            JSONArray allContent = new JSONArray(StringFromList.getStringFromList(listOfCities));
            for (int i = 0; i < allContent.length(); i++) {
                if((allContent.getJSONObject(i).get("country_id")).equals(countryId)) {

                    City city = new City();
                    city.setId((Integer) allContent.getJSONObject(i).get("id"));
                    city.setName((String) allContent.getJSONObject(i).get("name"));
                    city.setLatitude(Double.parseDouble((String)allContent.getJSONObject(i).get("latitude")));
                    city.setLongitude(Double.parseDouble((String)allContent.getJSONObject(i).get("longitude")));

                    cities.add(city);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //dodatkowy element reprezentujący cały kraj
        cities.add(getFirstElementOfList(country));

        return cities;
    }

    private City getFirstElementOfList(String country) {

        City representationOfWholeCountry = new City();
        Integer countryId = getSelectedCountryId(country);

        try {
            String contents = new String((Files.readAllBytes(Paths.get(urlCounties))));
            JSONArray allContent = new JSONArray(contents);
            for (int i = 0; i < allContent.length(); i++) {
                if((allContent.getJSONObject(i).get("id")).equals(countryId)){
                    representationOfWholeCountry.setId((Integer) allContent.getJSONObject(i).get("id"));
                    representationOfWholeCountry.setName("Cały kraj");
                    representationOfWholeCountry.setLatitude(Double.parseDouble((String)allContent.getJSONObject(i).get("latitude")));
                    representationOfWholeCountry.setLongitude(Double.parseDouble((String)allContent.getJSONObject(i).get("longitude")));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return representationOfWholeCountry;
    }

    private Integer getSelectedCountryId(String country){

        Integer countryId = 0;
        try {
            String contents = new String((Files.readAllBytes(Paths.get(urlCounties))));
            JSONArray allContent = new JSONArray(contents);
            for (int i = 0; i < allContent.length(); i++) {
                if((allContent.getJSONObject(i).get("name")).equals(country)) {
                    countryId = (Integer)allContent.getJSONObject(i).get("id");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countryId;
    }
}

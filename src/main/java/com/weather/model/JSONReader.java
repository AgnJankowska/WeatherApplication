package com.weather.model;

import org.json.JSONArray;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JSONReader {

    private String urlCities = "src/main/resources/com/weather/model/cities.json";
    private String urlCounties = "src/main/resources/com/weather/model/countries.json";

    public ArrayList<String> getCountriesArray() {

        ArrayList<String> countries = new ArrayList<String>();
        try {
            String contents = new String((Files.readAllBytes(Paths.get(urlCounties))));
            JSONArray allContent = new JSONArray(contents);
            for (int i = 0; i < allContent.length(); i++) {
                countries.add((String)allContent.getJSONObject(i).get("name"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }

    public ArrayList<String> getCitiesOfSelectedCountry(String country) {
        ArrayList<String> cities = new ArrayList<String>();
        Integer countryId = getSelectedCountryId(country);

        try {
            List<String> listOfCities = Files.readAllLines(Paths.get(urlCities), StandardCharsets.UTF_8);
            JSONArray allContent = new JSONArray(getStringFromList(listOfCities));
            for (int i = 0; i < allContent.length(); i++) {
                if((allContent.getJSONObject(i).get("country_id")).equals(countryId)) {
                    cities.add((String) allContent.getJSONObject(i).get("name"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;
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

    private String getStringFromList(List<String> list) {
        String delim = "";
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < list.size(); i++ ) {
            sb.append(list.get(i));
            sb.append(delim);
        }
        String res = sb.toString();
        return res;
    }

}

package com.weather;

import org.json.JSONArray;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

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
            String contents = new String((Files.readAllBytes(Paths.get(urlCities))));
            JSONArray allContent = new JSONArray(contents);
            for (int i = 0; i < allContent.length(); i++) {
                if(((Integer)allContent.getJSONObject(i).get("country_id")).equals(countryId)) {
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
                if(((String)allContent.getJSONObject(i).get("name")).equals(country)) {
                    countryId = (Integer)allContent.getJSONObject(i).get("id");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countryId;
    }
}

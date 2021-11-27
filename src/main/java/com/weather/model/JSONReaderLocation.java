package com.weather.model;

import com.weather.App;
import com.weather.model.auxiliaryClasses.StringFromList;
import org.json.JSONArray;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JSONReaderLocation{

    private URL urlCountries = this.getClass().getResource("countries.json");
    private URL urlCities = this.getClass().getResource("cities.json");

    public ArrayList<City> getCitiesOfSelectedCountry(String country) {
        ArrayList<City> cities = new ArrayList<City>();
        Integer countryId = getSelectedCountryId(country);

        try {
            InputStream in = urlCities.openStream();
            List<String> listOfCities = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8)).lines().collect(Collectors.toList());

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
            App.showErrorMessage("Nie znaleziono wymaganego pliku źródłowego.");
        }

        //dodatkowy element reprezentujący cały kraj
        cities.add(getFirstElementOfList(country));

        return cities;
    }

    private City getFirstElementOfList(String country) {

        City representationOfWholeCountry = new City();
        Integer countryId = getSelectedCountryId(country);

        try {
            InputStream in = urlCountries.openStream();
            String contents = new String(in.readAllBytes());
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
            App.showErrorMessage("Nie znaleziono wymaganego pliku źródłowego.");
        }

        return representationOfWholeCountry;
    }

    private Integer getSelectedCountryId(String country){

        Integer countryId = 0;
        try {
            InputStream in = urlCountries.openStream();
            String contents = new String(in.readAllBytes());
            JSONArray allContent = new JSONArray(contents);
            for (int i = 0; i < allContent.length(); i++) {
                if((allContent.getJSONObject(i).get("name")).equals(country)) {
                    countryId = (Integer)allContent.getJSONObject(i).get("id");
                }
            }
        } catch (IOException e) {
            App.showErrorMessage("Nie znaleziono wymaganego pliku źródłowego.");
        }
        return countryId;
    }
}

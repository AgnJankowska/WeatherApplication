package com.weather.model;

import com.weather.model.privateKey.WeatherKey;

public class URLWeather {

    private final Double latitudeDouble;
    private final Double longitudeDouble;

    public URLWeather(Double longitude, Double latitude){
        this.longitudeDouble = longitude;
        this.latitudeDouble = latitude;
    }

    public String getUrl() {
        String latitude = "&lat=" + createCoordinateAsString(latitudeDouble);
        String longitude = "&lon=" + createCoordinateAsString(longitudeDouble);
        String apiForecast = "https://api.openweathermap.org/data/2.5/onecall?";
        String units = "&units=metric";
        String apiKey = WeatherKey.getApiKey();
        String apiExclude = "&exclude=current,minutely,hourly";

        return apiForecast + latitude + longitude + units + apiKey + apiExclude;
    }

    private String createCoordinateAsString(Double coordinate) {
        return String.valueOf(coordinate);
    }
}


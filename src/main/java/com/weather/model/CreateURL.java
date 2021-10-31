package com.weather.model;

public class CreateURL {

    private String apiForecast = "http://api.openweathermap.org/data/2.5/forecast?";
    private String units = "&units=metric";
    private String apiKey = "&appid=2fdecf9a527ebefbfe75ed24657fecf0";
    private String latitude = "";
    private String longitude = "";

    private Double latitudeDouble;
    private Double longitudeDouble;

    public CreateURL(Double longitude, Double latitude){
        this.longitudeDouble = longitude;
        this.latitudeDouble = latitude;
    }

    private String createCoordinateAsString(Double coordinate) {
        String coordinateString = coordinate+"";
        return coordinateString;
    }

    public String getUrl() {
        latitude = "&lat="+createCoordinateAsString(latitudeDouble);
        longitude = "&lon="+createCoordinateAsString(longitudeDouble);
        return apiForecast+latitude+longitude+units+apiKey;
    }
}


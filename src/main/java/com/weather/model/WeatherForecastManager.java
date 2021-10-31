package com.weather.model;

import com.weather.model.forecastComponent.Weather;
import java.io.IOException;

public class WeatherForecastManager {

    private Weather weatherObject;

    public WeatherForecastManager(Double longitude, Double latitude) throws IOException {
        JSONReaderWeather jsonReaderWeather = new JSONReaderWeather(longitude, latitude);
        this.weatherObject = jsonReaderWeather.createObjectFromJSON();
    }

    public void getWeather() throws IOException {

        getTemperature();

        System.out.println(weatherObject.getCity().getName());

        /*System.out.println("City " + obj.getName() + "(" + obj.getSys().getCountry()+ ")" + "today's "+ System.lineSeparator() +
                "Temperature: " + obj.getMain().getTemp() + "°C, " + System.lineSeparator()+
                "Humidity: " + obj.getMain().getHumidity() + "%, " + System.lineSeparator()+
                "Rain: " + obj.getWeather().get(0).getDescription()+ System.lineSeparator()+
                "Wind speed: " + obj.getWind().getSpeed() + " m/s";*/
    }

    private void getTemperature() {

    }


}

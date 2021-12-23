package com.weather.model.service;

import java.net.URL;

public class URLForCitiesAndCountries {

    private final String url;

    public URLForCitiesAndCountries(String urlString) {
        this.url = urlString;
    }

    public URL getUrl() {
        return this.getClass().getResource(this.url);
    }
}

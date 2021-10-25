package com.weather;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONReader {

    public static void fileReader() {

        String url = "src/main/resources/com/weather/model/cities.json";
        try {
            String contents = new String((Files.readAllBytes(Paths.get(url))));
            JSONArray allContent = new JSONArray(contents);
            String city;

            for (int i = 0; i < allContent.length(); i++) {
                city = (String)allContent.getJSONObject(i).get("name");

                if(city.equals("Benjin")) {
                    System.out.println(city);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

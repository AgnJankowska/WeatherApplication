package com.weather;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class JSONReader {

    public static void fileReader() {

        System.out.println(System.getProperty("user.dir"));

        File file = new File("src/main/resources/com/weather/cities.txt");
        System.out.println(file.getAbsolutePath());

        try {
            FileReader fileReader = new FileReader(file);
            System.out.println("tak");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

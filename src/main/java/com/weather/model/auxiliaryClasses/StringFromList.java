package com.weather.model.auxiliaryClasses;

import java.util.List;

public class StringFromList {

    public static String getStringFromList(List<String> list) {
        String delim = "";
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < list.size(); i++ ) {
            stringBuilder.append(list.get(i));
            stringBuilder.append(delim);
        }
        String res = stringBuilder.toString();
        return res;
    }
}

package com.weather.model.forecastComponent;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Description {
    BROKEN_CLOUDS, CLEAR_SKY, FEW_CLOUDS, LIGHT_RAIN, OVERCAST_CLOUDS, SCATTERED_CLOUDS;

    @JsonValue
    public String toValue() {
        switch (this) {
            case BROKEN_CLOUDS:
                return "broken clouds";
            case CLEAR_SKY:
                return "clear sky";
            case FEW_CLOUDS:
                return "few clouds";
            case LIGHT_RAIN:
                return "light rain";
            case OVERCAST_CLOUDS:
                return "overcast clouds";
            case SCATTERED_CLOUDS:
                return "scattered clouds";
        }
        return null;
    }

    @JsonCreator
    public static Description forValue(String value) throws IOException {
        if (value.equals("broken clouds")) return BROKEN_CLOUDS;
        if (value.equals("clear sky")) return CLEAR_SKY;
        if (value.equals("few clouds")) return FEW_CLOUDS;
        if (value.equals("light rain")) return LIGHT_RAIN;
        if (value.equals("overcast clouds")) return OVERCAST_CLOUDS;
        if (value.equals("scattered clouds")) return SCATTERED_CLOUDS;
        throw new IOException("Cannot deserialize Description");
    }
}
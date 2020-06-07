package com.przedwojski.hexagon.apisis;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.przedwojski.hexagon.domain.WeatherObservationSource;
import com.przedwojski.hexagon.domain.WeatherObservation;
import lombok.SneakyThrows;

import java.net.URL;

public class WeatherAPI implements WeatherObservationSource {

    // Hardcoded for Reykjavik
    public static final String API_URL = "https://apis.is/weather/observations/en?stations=1";

    @SneakyThrows
    @Override
    public WeatherObservation getObservation() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        WeatherResult weatherResult = objectMapper.readValue(new URL(API_URL), WeatherResult.class);
        if (weatherResult.results != null && weatherResult.results.size() > 0)
            return weatherResult.results.get(0).toWeatherObservation();
        else return WeatherObservation.builder().build(); // TODO Handle missing result
    }
}

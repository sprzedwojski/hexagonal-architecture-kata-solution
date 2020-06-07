package com.przedwojski.hexagon.apisis;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.przedwojski.hexagon.domain.DrivingInputPort;
import com.przedwojski.hexagon.domain.WeatherObservation;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class WeatherFetcher implements DrivingInputPort {
    @SneakyThrows
    @Override
    public WeatherObservation getObservation() {
        //        String url = "https://apis.is/weather/observations/en?stations=422";
        //        OkHttpClient client = new OkHttpClient();
        //        Request request = new Request.Builder().url(url).build();
        //        Response response = client.newCall(request).execute();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //        String responseBody = response.body().string();
        //        WeatherResult weatherResult = objectMapper.readValue(responseBody,
        // WeatherResult.class);
        WeatherResult weatherResult =
                objectMapper.readValue(
                        new URL("https://apis.is/weather/observations/en?stations=422"),
                        WeatherResult.class);
        if (weatherResult.results != null && weatherResult.results.size() > 0)
            return weatherResult.results.get(0).toWeatherObservation();
        else return WeatherObservation.builder().build(); // TODO
    }
}

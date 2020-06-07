package com.przedwojski.hexagon.infra;

import com.przedwojski.hexagon.domain.WeatherObservationSink;
import com.przedwojski.hexagon.domain.WeatherObservation;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvSaver implements WeatherObservationSink {
    Logger logger = LoggerFactory.getLogger(CsvSaver.class);

    @SneakyThrows
    @Override
    public void save(WeatherObservation observation) {
        File file = new File("weather.csv");
        FileWriter writer = new FileWriter(file, true);
        writer.write(convertToCsv(observation) + "\n");
        writer.close();
        logger.info("Added a new observation to the file.");
    }

    private String convertToCsv(WeatherObservation observation) {
        List<String> result = new ArrayList<>();
        result.add(observation.getId());
        result.add(observation.getName());
        result.add(observation.getTime());
        result.add(String.valueOf(observation.getTemperatureCelsius()));
        result.add(String.valueOf(observation.getPressureHPa()));
        result.add(observation.getWindDirection());
        return String.join(",", result);
    }
}

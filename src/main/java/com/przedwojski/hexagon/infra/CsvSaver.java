package com.przedwojski.hexagon.infra;

import com.przedwojski.hexagon.domain.DrivenRepositoryPort;
import com.przedwojski.hexagon.domain.WeatherObservation;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvSaver implements DrivenRepositoryPort {
    Logger logger = LoggerFactory.getLogger(CsvSaver.class);

    @SneakyThrows
    @Override
    public void save(WeatherObservation observation) {
        File file = new File("weather.csv");
        FileWriter writer = new FileWriter(file, true);
        writer.write(convertToCsv(observationToString(observation)) + "\n");
        writer.close();
    }

    private List<String> observationToString(WeatherObservation observation) {
        List<String> result = new ArrayList<>();
        result.add(observation.getId());
        result.add(observation.getName());
        result.add(observation.getTime());
        result.add(String.valueOf(observation.getTemperatureCelsius()));
        result.add(String.valueOf(observation.getPressureHPa()));
        result.add(observation.getWindDirection());
        return result;
    }

    private String convertToCsv(List<String> data) {
        return String.join(",", data);
    }
}

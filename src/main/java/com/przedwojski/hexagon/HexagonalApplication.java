package com.przedwojski.hexagon;

import com.przedwojski.hexagon.apisis.WeatherAPI;
import com.przedwojski.hexagon.domain.WeatherObservationSink;
import com.przedwojski.hexagon.domain.WeatherObservationSource;
import com.przedwojski.hexagon.domain.WeatherObservationFacade;
import com.przedwojski.hexagon.infra.CsvSaver;

public class HexagonalApplication {

    public static void main(String[] args) {
        WeatherObservationSource observationSource = new WeatherAPI();
        WeatherObservationSink observationSink = new CsvSaver();
        WeatherObservationFacade service =
                new WeatherObservationFacade(observationSource, observationSink);
        service.processObservation();
    }
}

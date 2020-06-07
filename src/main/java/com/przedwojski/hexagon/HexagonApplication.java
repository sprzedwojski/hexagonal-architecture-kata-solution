package com.przedwojski.hexagon;

import com.przedwojski.hexagon.apisis.WeatherFetcher;
import com.przedwojski.hexagon.domain.DrivenRepositoryPort;
import com.przedwojski.hexagon.domain.DrivingInputPort;
import com.przedwojski.hexagon.domain.WeatherObservationService;
import com.przedwojski.hexagon.infra.CsvSaver;
import com.przedwojski.hexagon.infra.SimpleLogger;

// @SpringBootApplication
public class HexagonApplication {

    public static void main(String[] args) {
        //        SpringApplication.run(HexagonApplication.class, args);
        DrivingInputPort drivingPortAdapter = new WeatherFetcher();
//        DrivenRepositoryPort drivenPortAdapter = new SimpleLogger();
        DrivenRepositoryPort drivenPortAdapter = new CsvSaver();
        WeatherObservationService service =
                new WeatherObservationService(drivingPortAdapter, drivenPortAdapter);
        service.processObservation();
    }
}

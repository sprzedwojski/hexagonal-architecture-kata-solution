package com.przedwojski.hexagon.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WeatherObservationFacade {
    private final WeatherObservationSource observationSource;
    private final WeatherObservationSink observationSink;

    public void processObservation() {
        WeatherObservation observation = observationSource.getObservation();
        observationSink.save(observation);
    }
}

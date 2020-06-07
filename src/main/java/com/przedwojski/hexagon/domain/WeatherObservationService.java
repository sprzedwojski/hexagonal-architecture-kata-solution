package com.przedwojski.hexagon.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WeatherObservationService {
    private final DrivingInputPort inputPort;
    private final DrivenRepositoryPort repositoryPort;

    public void processObservation() {
        WeatherObservation observation = inputPort.getObservation();
        repositoryPort.save(observation);
    }
}

package com.przedwojski.hexagon.domain;

public interface WeatherObservationSink {
    void save(WeatherObservation observation);
}

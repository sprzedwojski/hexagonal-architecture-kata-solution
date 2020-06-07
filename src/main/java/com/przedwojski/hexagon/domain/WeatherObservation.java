package com.przedwojski.hexagon.domain;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class WeatherObservation {
    String id;
    String name;
    String time;
    float temperatureCelsius;
    float pressureHPa;
    String windDirection;
}

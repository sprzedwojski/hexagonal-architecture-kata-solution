package com.przedwojski.hexagon.apisis;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
class WeatherResult {
    List<WeatherObservationDTO> results;
}

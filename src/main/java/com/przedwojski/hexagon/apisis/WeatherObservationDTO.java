package com.przedwojski.hexagon.apisis;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.przedwojski.hexagon.domain.WeatherObservation;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
public class WeatherObservationDTO {
    String id;
    String name;
    String time;
    @JsonProperty("T")
    float temperatureCelsius;
    @JsonProperty("P")
    float pressureHPa;
    @JsonProperty("D")
    String windDirection;

    public WeatherObservation toWeatherObservation() {
        return WeatherObservation.builder()
                       .id(this.id)
                       .name(this.name)
                       .time(this.time)
                       .temperatureCelsius(this.temperatureCelsius)
                       .pressureHPa(this.pressureHPa)
                       .windDirection(this.windDirection)
                       .build();
    }
}

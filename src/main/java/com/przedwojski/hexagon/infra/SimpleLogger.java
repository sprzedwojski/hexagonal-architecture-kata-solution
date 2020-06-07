package com.przedwojski.hexagon.infra;

import com.przedwojski.hexagon.domain.DrivenRepositoryPort;
import com.przedwojski.hexagon.domain.WeatherObservation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleLogger implements DrivenRepositoryPort {

    Logger logger = LoggerFactory.getLogger(SimpleLogger.class);

    @Override
    public void save(WeatherObservation observation) {
        logger.info(observation.toString());
    }
}

package com.crud.travelAgency.weather;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class WeatherConfig {


    @Value("${openweathermap.api.endpoint}")
    private String weatherApiEndpoint;

    @Value("${openweatrher.api.key}")
    private String weatherApiKey;

    @Value("${openweather.api.language}")
    private String language;

    @Value("${openweather.api.units}")
    private String units;


}

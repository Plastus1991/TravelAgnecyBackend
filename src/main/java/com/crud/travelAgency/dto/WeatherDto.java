package com.crud.travelAgency.dto;

import lombok.*;


@Getter
@Builder
public class WeatherDto {

    private final float temperature;
    private final int pressure;
    private final  int humidity;
    private final float windSpeed;
}

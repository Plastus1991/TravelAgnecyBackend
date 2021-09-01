package com.crud.travelAgency.weather;

import com.crud.travelAgency.dto.WeatherDto;
import com.crud.travelAgency.weather.dto.OpenWeatherWeatherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class WeatherClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final WeatherConfig weatherConfig;

    public WeatherDto getWeather(String place) {
        URI url = UriComponentsBuilder.fromHttpUrl(weatherConfig.getWeatherApiEndpoint())
                .queryParam("q", place)
                .queryParam("appid", weatherConfig.getWeatherApiKey())
                .queryParam("lang", weatherConfig.getLanguage())
                .queryParam("units", weatherConfig.getUnits())
                .build()
                .encode()
                .toUri();

        OpenWeatherWeatherDto openWeatherWeatherDto = restTemplate.getForObject(url, OpenWeatherWeatherDto.class);

        if (openWeatherWeatherDto != null) {
            return WeatherDto.builder()
                    .temperature(openWeatherWeatherDto.getMain().getTemp())
                    .humidity(openWeatherWeatherDto.getMain().getHumidity())
                    .pressure(openWeatherWeatherDto.getMain().getPressure())
                    .windSpeed(openWeatherWeatherDto.getWind().getSpeed())
                    .build();
        } else
            return null;
    }
}

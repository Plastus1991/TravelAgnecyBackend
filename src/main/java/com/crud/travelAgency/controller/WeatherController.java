package com.crud.travelAgency.controller;


import com.crud.travelAgency.dto.WeatherDto;
import com.crud.travelAgency.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("v1/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @RequestMapping(method = RequestMethod.GET)
    public WeatherDto getWeatherForPlace(@RequestParam String place, @RequestParam Long id) {
        return weatherService.weatherForPlace(place, id);
    }
}
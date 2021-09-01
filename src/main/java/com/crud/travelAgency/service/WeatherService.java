package com.crud.travelAgency.service;


import com.crud.travelAgency.domain.CountCallMethod;
import com.crud.travelAgency.dto.WeatherDto;
import com.crud.travelAgency.repository.CountCallMethodRepository;
import com.crud.travelAgency.weather.WeatherClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;
    private final CountCallMethodRepository countCallMethodRepository;

    public WeatherDto weatherForPlace(String place, Long id) {

        countCallWeather(id);
        return weatherClient.getWeather(place);
    }

    public void countCallWeather(Long methodNameId) {

        CountCallMethod countCallMethod = countCallMethodRepository.getById(methodNameId);
        int count = countCallMethod.getCount() + 1;
        countCallMethod.setCount(count);
        countCallMethodRepository.save(countCallMethod);
    }
}

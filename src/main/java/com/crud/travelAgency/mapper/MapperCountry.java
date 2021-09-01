package com.crud.travelAgency.mapper;

import com.crud.travelAgency.domain.Country;
import com.crud.travelAgency.domain.Hotel;
import com.crud.travelAgency.domain.Trip;
import com.crud.travelAgency.dto.CountryDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapperCountry {

    public Country mapToCountry(final CountryDto countryDto) {

        Country country = new Country();
        country.setId(countryDto.getId());
        country.setName(countryDto.getName());
        return country;
    }

    public CountryDto mapToCountryDto(final Country country) {

        return new CountryDto(
                country.getId(),
                country.getName());
    }

    public List<CountryDto> mapToCountryDtoToList(final List<Country> countries) {

        return countries.stream()
                .map(this::mapToCountryDto)
                .collect(Collectors.toList());

    }
}

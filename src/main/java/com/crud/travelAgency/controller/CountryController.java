package com.crud.travelAgency.controller;

import com.crud.travelAgency.domain.Country;
import com.crud.travelAgency.dto.CountryDto;
import com.crud.travelAgency.mapper.MapperCountry;
import com.crud.travelAgency.mapper.MapperCustomer;
import com.crud.travelAgency.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/country")
public class CountryController {

    private final MapperCountry mapperCountry;
    private final CountryService countryService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Country createCountry(@RequestBody CountryDto countryDto) {

        Country country = mapperCountry.mapToCountry(countryDto);
        return countryService.saveCountry(country);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCountry/{id}")
    public CountryDto getCountry(@PathVariable Long id) throws Exception {

        Country country = countryService.getCustomerById(id).orElseThrow(Exception::new);
        return mapperCountry.mapToCountryDto(country);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{countryId}")
    public void deleteCountryById(@PathVariable Long countryId) {
        countryService.deleteCountry(countryId);
    }
}

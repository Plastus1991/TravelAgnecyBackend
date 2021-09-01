package com.crud.travelAgency.service;


import com.crud.travelAgency.domain.Country;
import com.crud.travelAgency.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public void saveCountry(final Country country) {
        countryRepository.save(country);
    }

    public Optional<Country> getCustomerById(Long id) {
        return countryRepository.findById(id);
    }

    public void deleteCountry(Long countryId) {
        countryRepository.deleteById(countryId);
    }
}

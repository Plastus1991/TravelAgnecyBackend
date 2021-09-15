package com.crud.travelAgency.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class CountryDto {

    private final Long id;
    private final String name;


}

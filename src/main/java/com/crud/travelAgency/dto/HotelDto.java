package com.crud.travelAgency.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HotelDto {

    private final Long id;
    private final String name;
    private final String standard;
    private final String menu;
    private final double price;
    private final Long countryId;
}

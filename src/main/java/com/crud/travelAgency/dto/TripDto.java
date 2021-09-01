package com.crud.travelAgency.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TripDto {

    private final Long id;
    private final String name;
    private final double price;
    private final Long countryId;
    private final Long hotelId;
    private final Long transportId;
}

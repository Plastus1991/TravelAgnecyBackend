package com.crud.travelAgency.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TransportDto {

    private final Long id;
    private final String transportType;
    private final String standard;
    private final double price;
}

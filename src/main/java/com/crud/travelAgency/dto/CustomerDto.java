package com.crud.travelAgency.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomerDto {

    private final Long id;
    private final String name;
    private final String secondName;
}

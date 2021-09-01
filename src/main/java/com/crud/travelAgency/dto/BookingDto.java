package com.crud.travelAgency.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Builder
public class BookingDto {

    private final Long id;
    private final String name;
    private final Long customerId;
    private final Long tripId;
    private final Date bookingDate;
}

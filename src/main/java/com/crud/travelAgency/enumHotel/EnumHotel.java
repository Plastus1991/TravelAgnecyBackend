package com.crud.travelAgency.enumHotel;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum EnumHotel {

    LOW(300, "LOW"),
    MEDIUM(400, "MEDIUM"),
    HIGH(500, "EXCLUSIVE");

    private final double price;
    private final String standard;
}

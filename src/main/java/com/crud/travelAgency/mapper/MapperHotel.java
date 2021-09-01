package com.crud.travelAgency.mapper;


import com.crud.travelAgency.domain.Country;
import com.crud.travelAgency.domain.Hotel;
import com.crud.travelAgency.dto.HotelDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapperHotel {

    public Hotel mapToHotel(final HotelDto hotelDto) {

        Country country = new Country();
        country.setId(hotelDto.getCountryId());

        Hotel hotel = new Hotel();
        hotel.setId(hotelDto.getId());
        hotel.setName(hotelDto.getName());
        hotel.setStandard(hotelDto.getStandard());
        hotel.setMenu(hotelDto.getMenu());
        hotel.setPrice(hotelDto.getPrice());

        hotel.setCountry(country);

        return hotel;
    }

    public HotelDto mapToHotelDto(final Hotel hotel) {

        return new HotelDto(
                hotel.getId(),
                hotel.getName(),
                hotel.getStandard(),
                hotel.getMenu(),
                hotel.getPrice(),
                hotel.getCountry().getId());
    }

    public List<HotelDto> mapToHotelDtoToList(final List<Hotel> hotels) {

        return hotels.stream()
                .map(this::mapToHotelDto)
                .collect(Collectors.toList());
    }
}

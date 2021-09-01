package com.crud.travelAgency.mapper;

import com.crud.travelAgency.domain.Country;
import com.crud.travelAgency.domain.Hotel;
import com.crud.travelAgency.domain.Transport;
import com.crud.travelAgency.domain.Trip;
import com.crud.travelAgency.dto.TripDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapperTrip {

    public Trip mapToTrip(final TripDto tripDto) {

        Trip trip = new Trip();
        trip.setId(tripDto.getId());
        trip.setName(tripDto.getName());
        trip.setPrice(tripDto.getPrice());

        Country country = new Country();
        country.setId(tripDto.getCountryId());

        Hotel hotel = new Hotel();
        hotel.setId(tripDto.getHotelId());

        Transport transport = new Transport();
        transport.setId(tripDto.getTransportId());

        trip.setCountry(country);
        trip.setHotel(hotel);
        trip.setTransport(transport);

        return trip;
    }

    public TripDto mapToTripDto(final Trip trip) {

        return new TripDto(
                trip.getId(),
                trip.getName(),
                trip.getPrice(),
                trip.getCountry().getId(),
                trip.getHotel().getId(),
                trip.getTransport().getId());
    }

    public List<TripDto> mapToTripDtoToList(final List<Trip> trips) {

        return trips.stream()
                .map(this::mapToTripDto)
                .collect(Collectors.toList());
    }
}

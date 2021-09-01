package com.crud.travelAgency.mapper;


import com.crud.travelAgency.domain.Booking;
import com.crud.travelAgency.domain.Customer;
import com.crud.travelAgency.domain.Trip;
import com.crud.travelAgency.dto.BookingDto;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapperBooking {

    public Booking mapToBooking(final BookingDto bookingDto) {

        Trip trip = new Trip();
        trip.setId(bookingDto.getTripId());

        Customer customer = new Customer();
        customer.setId(bookingDto.getCustomerId());
        Booking booking = new Booking();
        booking.setId(bookingDto.getId());
        booking.setName(bookingDto.getName());
        booking.setBookingDate(new Date());
        booking.setCustomer(customer);
        booking.setTrip(trip);

        return booking;
    }

    public BookingDto mapToBookingDto(final Booking booking) {

        return new BookingDto(
                booking.getId(),
                booking.getName(),
                booking.getCustomer().getId(),
                booking.getTrip().getId(),
                booking.getBookingDate());
    }

    public List<BookingDto> mapToBookingDtoToList(final List<Booking> bookingList) {
        return bookingList.stream()
                .map(this::mapToBookingDto)
                .collect(Collectors.toList());
    }
}

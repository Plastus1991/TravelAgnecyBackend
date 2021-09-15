package com.crud.travelAgency.controller;


import com.crud.travelAgency.domain.Booking;
import com.crud.travelAgency.dto.BookingDto;
import com.crud.travelAgency.mapper.MapperBooking;
import com.crud.travelAgency.service.BookingService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/booking")
public class BookingController {

    private final MapperBooking mapperBooking;
    private final BookingService bookingService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createBooking(@RequestBody BookingDto bookingDto) {

        Booking booking = mapperBooking.mapToBooking(bookingDto);
        bookingService.saveBooking(booking);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getBooking/{id}")
    public BookingDto getBooking(@PathVariable Long id) throws Exception {
            Booking booking = bookingService.getBookingById(id).orElseThrow(Exception::new);
            return mapperBooking.mapToBookingDto(booking);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{bookingId}")
    public void deleteHotelById(@PathVariable Long bookingId) {
        bookingService.deleteById(bookingId);
    }
}

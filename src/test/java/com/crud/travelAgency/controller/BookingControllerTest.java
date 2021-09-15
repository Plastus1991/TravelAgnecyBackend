package com.crud.travelAgency.controller;

import com.crud.travelAgency.domain.Booking;
import com.crud.travelAgency.domain.Customer;
import com.crud.travelAgency.domain.Trip;
import com.crud.travelAgency.dto.BookingDto;
import com.crud.travelAgency.mapper.MapperBooking;
import com.crud.travelAgency.service.BookingService;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(BookingController.class)
class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookingService bookingService;
    @MockBean
    private MapperBooking mapperBooking;

    @Test
    void testCreateBooking() throws Exception {

        //Given
        Booking booking = Booking.builder()
                .id(2L)
                .name("name2")
                .build();

        BookingDto bookingDto = BookingDto.builder()
                .id(3L)
                .name("name")
                .build();

        when(mapperBooking.mapToBooking(any(BookingDto.class))).thenReturn(booking);
        when(bookingService.saveBooking(any(Booking.class))).thenReturn(booking);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(bookingDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/booking")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDeleteBooking() throws Exception {

        //Given
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/v1/booking/{bookingId}", 3L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testGetBooking() throws Exception {

        //Given
        Booking booking = Booking.builder()
                .id(10L)
                .name("name1")
                .build();

        BookingDto bookingDto = BookingDto.builder()
                .id(20L)
                .name("name123")
                .build();

        when(bookingService.getBookingById(12L)).thenReturn(Optional.of(booking));
        when(mapperBooking.mapToBookingDto(booking)).thenReturn(bookingDto);

        //Then & When
        mockMvc
                .perform(MockMvcRequestBuilders
                .get("/v1/booking/getBooking/{id}", 12L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("name123")));
    }

}
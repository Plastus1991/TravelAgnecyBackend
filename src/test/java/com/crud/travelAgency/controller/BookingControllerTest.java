package com.crud.travelAgency.controller;

import com.crud.travelAgency.mapper.MapperBooking;
import com.crud.travelAgency.service.BookingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

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
        void testCreateBooking() {

        }

}
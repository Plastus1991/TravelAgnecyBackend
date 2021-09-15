package com.crud.travelAgency.controller;

import com.crud.travelAgency.domain.Country;
import com.crud.travelAgency.dto.CountryDto;
import com.crud.travelAgency.mapper.MapperCountry;
import com.crud.travelAgency.service.CountryService;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(CountryController.class)
class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MapperCountry mapperCountry;
    @MockBean
    private CountryService countryService;


    @Test
    void testCreateCountry() throws Exception {

        //Given
        Country country = Country.builder()
                .id(2L)
                .name("country")
                .build();

        CountryDto countryDto = CountryDto.builder()
                .id(4L)
                .name("Country1")
                .build();

        when(mapperCountry.mapToCountry(any(CountryDto.class))).thenReturn(country);
        when(countryService.saveCountry(any(Country.class))).thenReturn(country);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(countryDto);


        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/country")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
               .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(2)));

    }
}
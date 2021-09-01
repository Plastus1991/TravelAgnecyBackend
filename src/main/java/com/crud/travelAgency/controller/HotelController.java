package com.crud.travelAgency.controller;

import com.crud.travelAgency.domain.Hotel;
import com.crud.travelAgency.dto.HotelDto;
import com.crud.travelAgency.mapper.MapperHotel;
import com.crud.travelAgency.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/hotel")
public class HotelController {

    private final MapperHotel mapperHotel;
    private final HotelService hotelService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createHotel(@RequestBody HotelDto hotelDto) {
        Hotel hotel = mapperHotel.mapToHotel(hotelDto);
        hotelService.saveHotel(hotel);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public HotelDto getHotelById(@PathVariable Long id) {

        return mapperHotel.mapToHotelDto(hotelService.findHotelById(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{hotelId}/{standardHotel}")
    public HotelDto changeStandardHotel(@PathVariable Long hotelId, @PathVariable String standardHotel) throws Exception {

        return mapperHotel.mapToHotelDto(hotelService.changeStandardHotel(hotelId, standardHotel));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{hotelId}")
    public void deleteById(@PathVariable Long hotelId) {
        hotelService.deleteHotelById(hotelId);
    }


}

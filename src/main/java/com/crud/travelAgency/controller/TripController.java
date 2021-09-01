package com.crud.travelAgency.controller;


import com.crud.travelAgency.domain.Trip;
import com.crud.travelAgency.dto.TripDto;
import com.crud.travelAgency.mapper.MapperTrip;
import com.crud.travelAgency.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/trip")
public class TripController {

    private final MapperTrip mapperTrip;
    private final TripService tripService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTrip(@RequestBody TripDto tripDto) {
        Trip trip = mapperTrip.mapToTrip(tripDto);
        tripService.saveTrip(trip);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{tripId}")
    public TripDto getTripById(@PathVariable Long tripId) {
        return mapperTrip.mapToTripDto(tripService.findTripById(tripId));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{tripId}/{transportId}")
    public TripDto changeMethodTransport(@PathVariable Long tripId, @PathVariable Long transportId) {
       return mapperTrip.mapToTripDto(tripService.changeTransport(tripId, transportId));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{tripId}")
    public void deleteTripById(@PathVariable Long tripId) {
        tripService.deleteTrip(tripId);
    }
}

package com.crud.travelAgency.service;


import com.crud.travelAgency.domain.Transport;
import com.crud.travelAgency.domain.Trip;
import com.crud.travelAgency.repository.TransportRepository;
import com.crud.travelAgency.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;
    private final TransportRepository transportRepository;

    public void saveTrip(final Trip trip) {
        tripRepository.save(trip);
    }

    public Trip findTripById(Long id) {
        return tripRepository.getById(id);
    }

    public Trip changeTransport(Long id, Long transportId) {
        Transport transport = transportRepository.getById(transportId);
        Trip trip = tripRepository.getById(id);
        trip.setTransport(transport);

        return tripRepository.save(trip);
    }

    public void deleteTrip(Long tripId) {
        tripRepository.deleteById(tripId);
    }
}

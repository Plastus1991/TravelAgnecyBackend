package com.crud.travelAgency.service;


import com.crud.travelAgency.domain.Transport;
import com.crud.travelAgency.repository.TransportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransportService {

    private final TransportRepository transportRepository;

    public void saveTransport(final Transport transport) {
        transportRepository.save(transport);
    }

    public Transport findTransportById(Long id) {
        return transportRepository.getById(id);
    }

    public void deleteTransport(Long transportId) {
        transportRepository.deleteById(transportId);
    }
}

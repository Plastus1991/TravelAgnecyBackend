package com.crud.travelAgency.mapper;

import com.crud.travelAgency.domain.Transport;
import com.crud.travelAgency.dto.TransportDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapperTransport {

    public Transport mapToTransport(final TransportDto transportDto) {

        Transport transport = new Transport();
        transport.setId(transportDto.getId());
        transport.setPrice(transportDto.getPrice());
        transport.setTransportType(transportDto.getTransportType());
        transport.setStandard(transportDto.getStandard());

        return transport;
    }

    public TransportDto mapToTransportDto(final Transport transport) {

        return new TransportDto(
                transport.getId(),
                transport.getTransportType(),
                transport.getStandard(),
                transport.getPrice());
    }

    public List<TransportDto> mapToTransportDtoToList(final List<Transport> transports) {

        return transports.stream()
                .map(this::mapToTransportDto)
                .collect(Collectors.toList());
    }
}

package com.crud.travelAgency.controller;


import com.crud.travelAgency.domain.Transport;
import com.crud.travelAgency.dto.TransportDto;
import com.crud.travelAgency.mapper.MapperTransport;
import com.crud.travelAgency.service.TransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/transport")
public class TransportController {

    private final MapperTransport mapperTransport;
    private final TransportService transportService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTransport(@RequestBody TransportDto transportDto) {

        Transport transport = mapperTransport.mapToTransport(transportDto);
        transportService.saveTransport(transport);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public TransportDto getTransportById(@PathVariable Long id) {
        return mapperTransport.mapToTransportDto(transportService.findTransportById(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{transportId}")
    public void deleteTransportById(@PathVariable Long transportId) {
        transportService.deleteTransport(transportId);
    }
}

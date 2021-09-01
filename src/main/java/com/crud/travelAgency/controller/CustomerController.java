package com.crud.travelAgency.controller;

import com.crud.travelAgency.domain.Customer;
import com.crud.travelAgency.dto.CustomerDto;
import com.crud.travelAgency.mapper.MapperCustomer;
import com.crud.travelAgency.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final MapperCustomer mapperCustomer;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCustomer(@RequestBody CustomerDto customerDto) {

        Customer customer = mapperCustomer.mapToCustomer(customerDto);
        customerService.saveCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public CustomerDto getCustomerById(@PathVariable Long id) {
        return mapperCustomer.mapToCustomerDto(customerService.getById(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{customerId}/{newName}/{newSecondName}")
    public CustomerDto changeName(@PathVariable Long customerId, @PathVariable String newName,
                                  @PathVariable String newSecondName) {

       return mapperCustomer.mapToCustomerDto(customerService.changeName(customerId, newName, newSecondName));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{customerId}")
    public void deleteCustomerById(@PathVariable Long customerId) {
        customerService.deleteById(customerId);
    }
}

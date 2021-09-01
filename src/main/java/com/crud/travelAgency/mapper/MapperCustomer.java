package com.crud.travelAgency.mapper;

import com.crud.travelAgency.domain.Customer;
import com.crud.travelAgency.dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapperCustomer {

    public Customer mapToCustomer(CustomerDto customerDto) {

        Customer customer = new Customer();

        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setSecondName(customerDto.getSecondName());

        return customer;
    }

    public CustomerDto mapToCustomerDto(final Customer customer) {

        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getSecondName());
    }

    public List<CustomerDto> mapToCustomerDtoToList(final List<Customer> customers) {

        return customers.stream()
                .map(this::mapToCustomerDto)
                .collect(Collectors.toList());
    }
}

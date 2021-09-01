package com.crud.travelAgency.service;

import com.crud.travelAgency.domain.Customer;
import com.crud.travelAgency.dto.CustomerDto;
import com.crud.travelAgency.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void saveCustomer(final Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getById(Long id) {
        return customerRepository.getById(id);
    }

    public Customer changeName(Long id, String newName, String newSecondName) {
        Customer customer = customerRepository.getById(id);
        customer.setName(newName);
        customer.setSecondName(newSecondName);

        return customerRepository.save(customer);
    }

    public void deleteById(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}

package com.crud.travelAgency.scheduler;


import com.crud.travelAgency.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerCurrently {

    private final CustomerRepository customerRepository;

    @Scheduled(fixedDelay = 100000000)
    public void getCustomerCount() {

        long customer = customerRepository.count();

        if (customer == 1) {
            System.out.println("Currently in database id " + customer + " customer");
        } else {
            System.out.println("Currently in database id " + customer + " customers");
        }
    }
}

package com.crud.travelAgency.repository;

import com.crud.travelAgency.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {


    Optional<Booking> findById(Long id);
}

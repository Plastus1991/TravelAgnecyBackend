package com.crud.travelAgency.repository;

import com.crud.travelAgency.domain.CountCallMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountCallMethodRepository extends JpaRepository<CountCallMethod, Long> {
}

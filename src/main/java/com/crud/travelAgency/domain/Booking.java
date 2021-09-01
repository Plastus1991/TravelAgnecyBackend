package com.crud.travelAgency.domain;

import lombok.*;


import javax.persistence.*;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Booking")
public class Booking {

    @Id
    @GeneratedValue
    private  Long id;

    @Column(name = "BOOKING_NAME")
    private  String name;

    @Column(name = "Date_of_booking")
    private Date bookingDate;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "TRIP_ID")
    private Trip trip;

}

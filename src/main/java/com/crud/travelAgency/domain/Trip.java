package com.crud.travelAgency.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Trip")
public class Trip {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private double price;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "HOTEL_ID")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "TRANSPORT_ID")
    private Transport transport;

    @OneToMany(mappedBy = "trip",
    cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    private List<Booking> bookingList;

}

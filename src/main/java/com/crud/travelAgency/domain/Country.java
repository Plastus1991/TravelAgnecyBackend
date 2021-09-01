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
@Entity(name = "COUNTRY")
public class Country {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "countryName")
    private String name;

    @OneToMany(
            mappedBy = "country",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Hotel> hotelList;

    @OneToMany(
            mappedBy = "country",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Trip> tripList;

}

package com.crud.travelAgency.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
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

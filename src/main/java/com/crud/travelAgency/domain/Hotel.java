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
@Entity(name = "Hotel")
public class Hotel {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column(name = "Hotel_standard")
    private String standard;

    @Column
    private String menu;

    @Column
    private double price;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    @OneToMany(
            mappedBy = "hotel",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Trip> tripList;
}

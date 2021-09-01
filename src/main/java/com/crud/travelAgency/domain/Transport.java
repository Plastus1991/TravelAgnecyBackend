package com.crud.travelAgency.domain;


import com.sun.istack.NotNull;
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
@Entity(name = "TRANSPORT")
public class Transport {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String transportType;

    @Column
    private double price;

    @Column(name = "Transport_standard")
    private String standard;

    @OneToMany(mappedBy = "transport",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Trip> tripList;
}

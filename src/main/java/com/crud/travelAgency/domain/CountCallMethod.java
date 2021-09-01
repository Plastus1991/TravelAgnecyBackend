package com.crud.travelAgency.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "COUNT_CALL_METHOD")
public class CountCallMethod {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private int count;

    @Column
    private String methodName;
}

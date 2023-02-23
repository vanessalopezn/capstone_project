package com.perscholas.capstone.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.util.Collection;


@Getter
@Setter
@NoArgsConstructor
@Table(name = "state")
public class State {
    @Column(unique = true)
    private String state_code;

    @Column(nullable = false, length = 50)
    private String name;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "national_park_state",
            joinColumns = @JoinColumn(name = "state_code"),
            inverseJoinColumns = @JoinColumn(name = "national_park_id"))
    private Collection<NationalPark> national_parks;

}

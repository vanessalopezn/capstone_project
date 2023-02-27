package com.perscholas.capstone.model;

import javax.persistence.*;
import lombok.*;
import java.util.Collection;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "stateslist")
public class State {
    @Id
    @Column(name = "state_code", length = 2)
    private String state_code;

    @Column(nullable = false, length = 50)
    private String name;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "national_park_state",
            joinColumns = {@JoinColumn(name = "state_code")},
            inverseJoinColumns = {@JoinColumn(name = "national_park_id")})
    private Collection<NationalPark> national_parks;

}

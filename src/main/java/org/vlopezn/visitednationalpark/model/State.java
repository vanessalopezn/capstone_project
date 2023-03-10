package org.vlopezn.visitednationalpark.model;

import javax.persistence.*;
import lombok.*;

import java.util.List;

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
    private List<NationalPark> national_parks;

}

package com.perscholas.capstone.model;

import javax.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "national_park" )
public class NationalPark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long national_park_id;
    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 250)
    private String description;

    @Column(length = 250)
    private String link;


    @OneToMany(targetEntity = NationalParkVisit.class, cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, orphanRemoval = true)


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_np_visit",
            joinColumns = @JoinColumn(name = "national_park_id"),
            inverseJoinColumns = {@JoinColumn(name = "visit_id"), @JoinColumn(name = "user_id")}
            )
    private List<NationalParkVisit> visits;

}

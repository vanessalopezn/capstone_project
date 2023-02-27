package com.perscholas.capstone.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "national_park_visit")
public class NationalParkVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long visit_id;

    @Column(nullable = false)
    private Long national_park_id;

    @Column(nullable = false)
    private Date start_date;

    @Column(nullable = false)
    private Date end_date;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_visit",
            joinColumns ={ @JoinColumn(name = "visit_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<NationalParkVisit> visits;
}

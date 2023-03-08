package com.perscholas.capstone.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat (pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date start_date;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date end_date;

}

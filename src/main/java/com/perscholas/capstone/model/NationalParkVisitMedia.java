package com.perscholas.capstone.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "national_park_visit_media")
public class NationalParkVisitMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long media_id;

    @Column(nullable = false)
    private String name;

    private String description;
}

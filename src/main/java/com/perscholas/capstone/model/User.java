package com.perscholas.capstone.model;
import lombok.*;
import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false)
    private  String password;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;

}

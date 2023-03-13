package org.vlopezn.visitednationalpark.model;
import lombok.*;
import javax.persistence.*;
import java.util.List;

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
    private String firstName;

    @Column(nullable = false)
    private String lastName;


    @OneToMany(targetEntity = NationalParkVisit.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<NationalParkVisit> visits;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List <Role> roles;

}

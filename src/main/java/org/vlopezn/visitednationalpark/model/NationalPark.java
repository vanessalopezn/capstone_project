/**
 * @Author Vanessa Lopez Nunez
 * @Class NationalPark
 * NationalPark entity
 */
package org.vlopezn.visitednationalpark.model;

import javax.persistence.*;
import lombok.*;

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
    private String link;

}

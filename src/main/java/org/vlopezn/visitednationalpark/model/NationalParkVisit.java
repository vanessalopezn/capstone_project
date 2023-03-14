/**
 * @Author Vanessa Lopez Nunez
 * @Class NationalParkVisit
 * NationalParkVisit entity
 */
package org.vlopezn.visitednationalpark.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

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

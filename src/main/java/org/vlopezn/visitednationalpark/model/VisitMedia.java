/**
 * @Author Vanessa Lopez Nunez
 * @Class NationalParkMedia
 * NatonalParkMedia entity
 */
package org.vlopezn.visitednationalpark.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "visit_media")
public class VisitMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long media_id;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "visit_id")
    private NationalParkVisit parkVisit;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 250)
    private String description;
}
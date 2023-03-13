package org.vlopezn.visitednationalpark.repository;

import org.vlopezn.visitednationalpark.model.NationalParkVisit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NationalParkVisitRepository extends CrudRepository<NationalParkVisit, Long> {


    /**
     * Get an object the NationalParkVisit with the visits from specific park
     * @param id id from National park
     * @return
     */
    @Query( value = "SELECT visit_id, DATE_FORMAT(start_date, '%M %d %Y') as start_date, " +
            "DATE_FORMAT(end_date, '%M %d %Y') as end_date, national_park_id " +
            "FROM national_park_visi " +
            "WHERE national_park_id = :id", nativeQuery = true)
    NationalParkVisit findVisitByNationalParkId(@Param("id") Long id);


}

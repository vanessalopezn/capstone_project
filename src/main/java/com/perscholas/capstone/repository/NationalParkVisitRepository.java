package com.perscholas.capstone.repository;

import com.perscholas.capstone.model.NationalParkVisit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NationalParkVisitRepository extends CrudRepository<NationalParkVisit, Long> {


    /**
     * Get an object the NationalParkVisit with the visits from specific park
     * @param id id from National park
     * @return
     */
    @Query( value = "SELECT visit_id, start_date, end_date, national_park_id\n" +
            "FROM national_park_visit\n" +
            "WHERE national_park_id = :id", nativeQuery = true)
    NationalParkVisit findVisitByNationalParkId(@Param("id") Long id);
}

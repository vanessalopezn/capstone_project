package com.perscholas.capstone.repository;

import com.perscholas.capstone.model.NationalPark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NationalParkRepository extends JpaRepository<NationalPark, Long> {


    void saveNationalPark();

    /**
     * Get all national parks
     * @return list with NationalPark objects
     */
    List<NationalPark> findNationalParks();

    /**
     * Find a national park by id
     * @param id
     * @return a NationalPark object
     */
    NationalPark findNationalParkByNationalParkId(Long id);

    @Query(value = "SELECT n.national_park_id, n.name, n.description, n.link, s.code, s.name " +
            " FROM national_park n " +
            " INNER JOIN national_park_state np_s ON n.national_park_id = np_s.national_park_id " +
            " INNER JOIN states s ON s.code = np_s.state_code " +
            " WHERE n.national_park_id = :id)", nativeQuery = true)
    List<NationalPark> findNationalParkByState(@Param("id") Long id);
}

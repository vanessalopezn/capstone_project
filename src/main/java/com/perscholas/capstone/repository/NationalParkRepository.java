package com.perscholas.capstone.repository;

import com.perscholas.capstone.model.NationalPark;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NationalParkRepository extends CrudRepository<NationalPark, Long> {


    /**
     * Get all national parks
     * @return list with NationalPark objects
     */
    @Override
    List<NationalPark> findAll();

    @Query(value = "SELECT national_park_id, name, link FROM national_park WHERE national_park_id =:id", nativeQuery = true)
    NationalPark findNationalParkById(@Param("id") Long id);

    @Query(value = "SELECT sl.name, sl.state_code, np.name, np.national_park_id"
    + " FROM national_park_state nps"
    + " INNER JOIN national_park np ON nps.national_park_id = np.national_park_id"
    + " INNER JOIN stateslist sl ON nps.state_code = sl.state_code"
    + " WHERE nps.state_code = :code", nativeQuery = true)
    List<NationalPark> findNationalParkByState(@Param("code") String code);

}

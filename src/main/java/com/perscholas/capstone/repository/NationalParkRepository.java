package com.perscholas.capstone.repository;

import com.perscholas.capstone.model.NationalPark;
import org.springframework.data.repository.CrudRepository;
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
    Iterable<NationalPark> findAll();

    /**
     * Find a national park by id
     * @param
     * @return a NationalPark object
     */
    @Override
    Optional<NationalPark> findById(Long aLong);

    /*
    @Query(value = "SELECT n.national_park_id, n.name, n.description, n.link, s.code, s.name " +
            " FROM national_park n " +
            " INNER JOIN national_park_state np_s ON n.national_park_id = np_s.national_park_id " +
            " INNER JOIN states s ON s.code = np_s.state_code " +
            " WHERE n.national_park_id = :id)", nativeQuery = true)
    List<NationalPark> findNationalParkByState(@Param("id") Long id);
    */
}

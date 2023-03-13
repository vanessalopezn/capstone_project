package org.vlopezn.visitednationalpark.repository;

import org.vlopezn.visitednationalpark.model.NationalPark;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Query(value = "SELECT np.national_park_id, np.name, np.link"
    + " FROM national_park_state nps"
    + " INNER JOIN national_park np ON nps.national_park_id = np.national_park_id"
    + " WHERE nps.state_code = :code", nativeQuery = true)
    List<NationalPark> findNationalParkByState(@Param("code") String code);

}

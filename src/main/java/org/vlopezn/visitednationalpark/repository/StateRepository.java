/**
 * @Author Vanessa Lopez Nunez
 * @Class StateRepository
 * Some methods CRUD from States
 */
package org.vlopezn.visitednationalpark.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.vlopezn.visitednationalpark.model.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends CrudRepository<State, String> {

    List<State> findAll();

    @Query( value = "select  s.state_code, s.name \n" +
            "from stateslist s \n" +
            "inner join national_park_state p on s.state_code = p.state_code\n" +
            "where p.national_park_id = :park_id LIMIT 1", nativeQuery = true)
    State findSateByPark(@Param("park_id") Long park_id);

    @Query(value="select * from stateslist s " +
            "where (select count(*) from national_park_state p " +
            "where p.state_code = s.state_code) > 0 order by state_code", nativeQuery = true)
    List<State> findStatesWithParks();
}

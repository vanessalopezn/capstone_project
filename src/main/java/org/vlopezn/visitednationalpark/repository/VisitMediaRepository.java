/**
 * @Author Vanessa Lopez Nunez
 * @Class VisitMedia
 * CRUD methods to Visit media
 */
package org.vlopezn.visitednationalpark.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.vlopezn.visitednationalpark.model.VisitMedia;

import java.util.List;


public interface VisitMediaRepository extends CrudRepository<VisitMedia, Long> {

     @Query(value = "select visit_id, media_id, description, name from visit_media  " +
             " where visit_id = :visit_id", nativeQuery = true)
    List<VisitMedia> getVisitMediaByVisitId(@Param("visit_id") Long visitId);

}

/**
 * @Author Vanessa Lopez Nunez
 * @Class NationalParkVisitService
 * Visits to national park service to handle the data
 */
package org.vlopezn.visitednationalpark.service;

import org.vlopezn.visitednationalpark.model.NationalParkVisit;


public interface INationalParkVisitService {

    void saveNationalParkVisit(NationalParkVisit nationalParkVisit);

    void deleteNationalParkVisit(NationalParkVisit nationalParkVisit);

    NationalParkVisit findVisitByNationalParkId(Long id);

}

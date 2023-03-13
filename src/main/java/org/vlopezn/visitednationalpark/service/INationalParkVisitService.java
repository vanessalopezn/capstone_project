package org.vlopezn.visitednationalpark.service;

import org.vlopezn.visitednationalpark.model.NationalParkVisit;


public interface INationalParkVisitService {

    void saveNationalParkVisit(NationalParkVisit nationalParkVisit);

    void deleteNationalParkVisit(NationalParkVisit nationalParkVisit);

    NationalParkVisit findVisitByNationalParkId(Long id);

}

/**
 * @Author Vanessa Lopez Nunez
 * @Class NationalParkSVisiterviceImpl
 * This class connect to national park visit repository to manipulate the data.
 */
package org.vlopezn.visitednationalpark.service;

import org.vlopezn.visitednationalpark.model.NationalParkVisit;
import org.vlopezn.visitednationalpark.repository.NationalParkVisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NationalParkVisitServiceImpl implements INationalParkVisitService{
    @Autowired
    NationalParkVisitRepository parkVisitRepository;

    @Override
    public void saveNationalParkVisit(NationalParkVisit nationalParkVisit) {

        parkVisitRepository.save(nationalParkVisit);
    }

    @Override
    public void deleteNationalParkVisit(NationalParkVisit nationalParkVisit) {
        parkVisitRepository.delete(nationalParkVisit);
    }

    @Override
    public NationalParkVisit findVisitByNationalParkId(Long id) {
        return null;
    }

}

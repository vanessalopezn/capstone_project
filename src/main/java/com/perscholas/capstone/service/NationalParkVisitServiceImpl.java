package com.perscholas.capstone.service;

import com.perscholas.capstone.model.NationalParkVisit;
import com.perscholas.capstone.repository.NationalParkVisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NationalParkVisitServiceImpl implements INationalParkVisitService{
    @Autowired
    NationalParkVisitRepository parkVisitRepository;

    @Override
    public void saveNationalParkVisit(NationalParkVisit nationalParkVisit) {
        parkVisitRepository.save(nationalParkVisit);
    }

    /**
     *  Validate dates from  Visit National Park form.
     *  End date needs to be greater or equals than start date.
     * @param
     * @return
     */
/*    public String validationVisitParkDates(NationalParkVisit parkVisit){
        String error = "";
        Date sd = parkVisit.getStart_date();
        Date ed = parkVisit.getEnd_date();
        if (sd.compareTo(ed) > 0){
            error = "End date needs to be greater or equals than Start Date.";
        }

        return error;
    }
*/
    @Override
    public void deleteNationalParkVisit(NationalParkVisit nationalParkVisit) {
        parkVisitRepository.delete(nationalParkVisit);
    }

    @Override
    public NationalParkVisit findVisitByNationalParkId(Long id) {
        return null;
    }


}

package com.perscholas.capstone.service;

import com.perscholas.capstone.model.NationalParkVisit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface INationalParkVisitService {

    void saveNationalParkVisit(NationalParkVisit nationalParkVisit);

    void deleteNationalParkVisit(NationalParkVisit nationalParkVisit);

    NationalParkVisit findVisitByNationalParkId(Long id);



}

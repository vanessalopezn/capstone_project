package com.perscholas.capstone.service;

import com.perscholas.capstone.model.NationalPark;
import java.util.List;

public interface INationalPark {

    List<NationalPark> getAllNationalPark();

    NationalPark getNationalParkById(Long id);

    List<NationalPark> getNationalParkByState(String code);
}

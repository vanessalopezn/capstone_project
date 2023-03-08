package com.perscholas.capstone.service;

import com.perscholas.capstone.model.NationalPark;
import com.perscholas.capstone.repository.NationalParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationalParkServiceImpl implements INationalParkService {
    @Autowired
    NationalParkRepository parkRepository;

    @Override
    public List<NationalPark> getAllNationalPark() {
        return parkRepository.findAll();
    }

    @Override
    public NationalPark getNationalParkById(Long id) {
        return parkRepository.findNationalParkById(id);
    }

    @Override
    public List<NationalPark> getNationalParkByState(String code) {
        return parkRepository.findNationalParkByState(code);
    }
}

/**
 * @Author Vanessa Lopez Nunez
 * @Class NationalParkServiceImpl
 * This class connect to national park repository to manipulate the data.
 */
package org.vlopezn.visitednationalpark.service;

import org.vlopezn.visitednationalpark.model.NationalPark;
import org.vlopezn.visitednationalpark.repository.NationalParkRepository;
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

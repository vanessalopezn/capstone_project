/**
 * @Author Vanessa Lopez Nunez
 * @Class INationalParkService
 * National parks service to handle the information.
 */
package org.vlopezn.visitednationalpark.service;

import org.vlopezn.visitednationalpark.model.NationalPark;
import java.util.List;

public interface INationalParkService {

    List<NationalPark> getAllNationalPark();

    NationalPark getNationalParkById(Long id);

    List<NationalPark> getNationalParkByState(String code);
}

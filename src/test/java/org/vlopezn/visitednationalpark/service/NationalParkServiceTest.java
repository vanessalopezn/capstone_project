package org.vlopezn.visitednationalpark.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.vlopezn.visitednationalpark.VisitedNationalParkApplication;
import org.vlopezn.visitednationalpark.model.NationalPark;
import org.vlopezn.visitednationalpark.repository.NationalParkRepository;

@SpringBootTest(classes = VisitedNationalParkApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NationalParkServiceTest {

    @Autowired
    public INationalParkService nationalParkService;


    @Test
    @Order(1)
    public void getAllNationalPark(){
        Assertions.assertNotNull(nationalParkService.getAllNationalPark());
    }

    @ParameterizedTest
    @ValueSource(longs = {1,2,3,4,5,6,7,8,9})
    @Order(2)
    public void getNationalParkById(Long id){
        Assertions.assertNotNull( nationalParkService.getNationalParkById(id));
    }

    @ParameterizedTest
    @ValueSource(strings = {"AL","CA", "CO", "CT", "GA", "FL", "WA", "OR", "UT", "MT"})
    @Order(3)
    public void getNationalParkByState(String code){
        Assertions.assertNotNull(nationalParkService.getNationalParkByState(code));
    }
}

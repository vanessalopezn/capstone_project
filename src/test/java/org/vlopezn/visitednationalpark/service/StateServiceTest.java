package org.vlopezn.visitednationalpark.service;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.vlopezn.visitednationalpark.VisitedNationalParkApplication;
import org.vlopezn.visitednationalpark.model.State;

@SpringBootTest(classes = VisitedNationalParkApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StateServiceTest {

    @Autowired
    public IStatesService statesService;

    public State statel;


    public void findStatesByPark(){

        statesService.findStatesWithParks();
    }
}

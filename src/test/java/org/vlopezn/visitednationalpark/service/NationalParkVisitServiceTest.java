package org.vlopezn.visitednationalpark.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.vlopezn.visitednationalpark.VisitedNationalParkApplication;
import org.vlopezn.visitednationalpark.model.NationalParkVisit;
import org.vlopezn.visitednationalpark.model.User;
import org.vlopezn.visitednationalpark.repository.UserRepository;

import java.util.*;

@SpringBootTest(classes = VisitedNationalParkApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NationalParkVisitServiceTest {

    static User user;
    @Autowired
    public UserRepository userRepository;
    static NationalParkVisit nationalParkVisit;
    @Autowired
    public IUserService userService;

    @Autowired
    INationalParkVisitService visitService;

    @BeforeAll
    public static void init() {
        nationalParkVisit = new NationalParkVisit();
        nationalParkVisit.setNational_park_id(Long.parseLong("20"));
        Date sd = new GregorianCalendar(2018, Calendar.MARCH, 5).getTime();
        nationalParkVisit.setStart_date(sd);
        Date ed = new GregorianCalendar(2018, Calendar.MARCH, 7).getTime();
        nationalParkVisit.setEnd_date(ed);

    }

    @Test
    @Order(1)
    public void SaveVisitNationalPark() {
        visitService.saveNationalParkVisit(nationalParkVisit);
        Assertions.assertTrue( userRepository.count() > 0);
    }

    @Test
    @Order(2)
    public void addVisitUser() {
        user = userService.findUserByEmail("vlopez@test.com");
        List<NationalParkVisit> list = new ArrayList<>();
        list = user.getVisits();
        list.add(nationalParkVisit);
        user.setVisits(list);

        userService.saveUpdateUser(user);
        Assertions.assertTrue( userRepository.count() > 0);
    }
}
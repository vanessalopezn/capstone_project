package org.vlopezn.visitednationalpark.service;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.vlopezn.visitednationalpark.VisitedNationalParkApplication;
import org.vlopezn.visitednationalpark.model.Role;
import org.vlopezn.visitednationalpark.model.User;
import org.vlopezn.visitednationalpark.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = VisitedNationalParkApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTest {

    public static User user;
    public static Role role;
    public IUserService userService;
    public UserRepository userRepository;

    @BeforeAll
    public static void init(){
        user = new User();
        user.setFirstName("Ken");
        user.setLastName("Smith");
        user.setEmail("ksmith@test.com");
        user.setPassword("123456");
        role = new Role();
        role.setName("USER");
        List<Role> roleList = new ArrayList<>();
        roleList.add(role);
        user.setRoles(roleList);
    }

    @Test
    @Order(1)
    @Disabled
    public void findUserByEmailTest_whenNullPointerException()
    {
        Assertions.assertThrows(RuntimeException.class, () ->
                        userRepository.findUserByEmail(user.getEmail()).orElseThrow(() -> new RuntimeException("User not found")));
    }

    @Test
    @Order(2)
    public void saveUserTest(){
            userRepository.save(user);
            Assertions.assertTrue(userRepository.count() > 0);
    }

    public void findUserByEmailTest(){
        User newUser = new User();
        newUser = userService.findUserByEmail(user.getEmail());
        //Assertions.asser
    }

}

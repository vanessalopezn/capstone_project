package org.vlopezn.visitednationalpark.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.vlopezn.visitednationalpark.VisitedNationalParkApplication;
import org.vlopezn.visitednationalpark.dto.UserDTO;
import org.vlopezn.visitednationalpark.model.User;
import org.vlopezn.visitednationalpark.repository.UserRepository;

@SpringBootTest(classes = VisitedNationalParkApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTest {

    public static User user;
    public static UserDTO userDTO;
    @Autowired
    public IUserService userService;
    @Autowired
    public UserRepository userRepository;

    @BeforeAll
    public static void init(){
        userDTO = new UserDTO();
        userDTO.setFirstName("Ken");
        userDTO.setLastName("Smith");
        userDTO.setEmail("ksmith@test.com");
        userDTO.setPassword("123456");

    }

    @Test
    @Order(1)
    @Disabled
    public void findUserByEmailTest_whenNullPointerException()
    {
        Assertions.assertThrows(RuntimeException.class, () ->
                     userRepository.findUserByEmail(userDTO.getEmail()).orElseThrow(() -> new RuntimeException("User not found")));
    }

    @Test
    @Order(2)
    public void saveUserTest(){
            userService.saveUser(userDTO);
            Assertions.assertTrue(userRepository.count() > 0);
    }

    @Test
    @Order(3)
    public void findUserByEmailTest(){
        user = userService.findUserByEmail(userDTO.getEmail());
        Assertions.assertEquals(user.getEmail(), userDTO.getEmail());
    }

    @Test
    @Order(4)
    public void saveUpdateUserTest(){
        user.setPassword("123789");
        userService.saveUpdateUser(user);
        Assertions.assertTrue(userRepository.count() > 0);
    }

    @Test
    @Order(5)
    public void deleteUserTest(){

        userService.delete(user);
        User deleteUser;

        try{deleteUser= userService.findUserByEmail(user.getEmail());}
        catch (Exception e){deleteUser=null;}

        Assertions.assertNull(deleteUser);
    }

}

package com.perscholas.capstone.controller;

import com.perscholas.capstone.model.User;
import com.perscholas.capstone.dto.UserDTO;
import com.perscholas.capstone.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import javax.validation.Valid;

@Controller
@Slf4j
public class UserController {
    IUserService userDetailsService;

    @Autowired
    public UserController(IUserService userService) {
        this.userDetailsService = userService;
    }

    /**
     *
     * @param model
     * @return
     */
  //  @GetMapping("/login")
    /*public String loadLogin(Model model)
    {
        //model.addAttribute("user", new User());
        model.addAttribute("userDto", new UserDTO());
        return "login";
    }*/



    /**
     *
     * @param model
     * @return
     */
    /*@GetMapping("/createUser")
    public String createUser(Model model)
    {
        model.addAttribute("user", new User());

        return "User";
    }*/



    @PostMapping("/validate")
    public String loginvalidate(@ModelAttribute("user") User user, BindingResult errors, Model model){
        log.warn("validate user. ");
        User user1 = userDetailsService.findUserByEmail(user.getEmail().trim());

        if(user1!=null) {
           if( user1.getPassword().equals(user.getPassword().trim()) ) {
                return "redirect:/visit_park_list";

            }else{
               model.addAttribute("messagep", "Invalid password");
           }
        }else {
            model.addAttribute("message", "Invalid user");
        }

        return "login";
    }


/*******  Code from example LAB - 309.8.1***************/
@InitBinder
public void initBinder(WebDataBinder dataBinder) {
    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
}


    @GetMapping("/")
    private String redirectToLogin()
    {
        return "redirect:/login";
    }

    @GetMapping("/sign-up")
    public String signUp(Model model)
    {
        model.addAttribute("userDto", new UserDTO());
        return "sign-up";
    }
@PostMapping("/signup-process")
public String signupProcess(@Valid @ModelAttribute ("userDto") UserDTO userDTO, BindingResult bindingResult)
{

    if(bindingResult.hasErrors())
    {
        log.warn("Wrong attempt");
        return "sign-up";
    }
    userDetailsService.create(userDTO);
    return "confirmation";
}

    /**
     * In order to make code more readable it is good practice to
     * use special DTOs for login It also make controllers
     * less dependent from entities and separate validation from
     * jpa functionality
     * @return
     */
    @GetMapping("/login")
    public String getLoginPage(Model model)
    {
        log.error("Login failed");
        model.addAttribute("user", new User());

        return "login";
    }

    @RequestMapping("/home")
    public String getHome()
    {
        return "home";

    }

}

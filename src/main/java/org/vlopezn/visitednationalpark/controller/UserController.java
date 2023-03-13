/**
 * @Author Vanessa Lopez Nunez
 * @Class UserController
 * This class is to handle user operation
 */
package org.vlopezn.visitednationalpark.controller;

import org.vlopezn.visitednationalpark.dto.UserDTO;
import org.vlopezn.visitednationalpark.service.IUserService;
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


/*******  Code from example LAB - 309.8.1, to implement spring security***************/
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

    /**
     * Method to prepare sign up form.
     * User create account to sig in.
     * @param model
     * @return
     */
    @GetMapping("/sign-up")
    public String signUp(Model model)
    {
        model.addAttribute("userDto", new UserDTO());
        return "sign-up";
    }

    /**vanessalopezn
     * Method to process a request for the user to valid and save information.
     * @param userDTO
     * @param bindingResult
     * @return
     */
    @PostMapping("/signup-process")
public String signupProcess(@Valid @ModelAttribute ("userDto") UserDTO userDTO, BindingResult bindingResult)
{
    if(bindingResult.hasErrors())
    {
        log.warn("Wrong attempt");
        return "sign-up";
    }

    try {
        userDetailsService.saveUser(userDTO);
    }catch (Exception e){
        log.error("Doesn't save an User. " + e.getMessage());
        return "sign-up";
    }
    return "login";
}

    /** call from loginPage(), from filterChain(http) method, SecurityConfiguration class. vlopezn
     * In order to make code more readable it is good practice to
     * use special DTOs for login It also make controllers
     * less dependent from entities and separate validation from
     * jpa functionality
     * @return
     */
    @GetMapping("/login")
    public String getLoginPage()
    {
        log.warn("Loading login page");
        return "login";
    }

    /*********Adding by Vanessa Lope******/
    /**
     * This method is call when the aunthentication user fail.
     * failureUrl(), from filterChain(http) method, SecurityConfiguration class.
     * @param model
     * @return
     */
    @GetMapping("/login/{error}")
    public String getLoginPage(Model model)
    {
        log.warn("Loading login page, invalid user or password");
        model.addAttribute("message", "Invalid user or password");
        return "login";
    }

    /**
     * This method is to shown logout page
     * call from logoutSuccessUrl(), from filterChain(http) method, SecurityConfiguration class.
     * @param model
     * @return
     */
    @GetMapping("/logout")
    public String getLogoutPage(Model model)
    {
        log.warn("Loading logout page");
        return "log_out";
    }


}

package com.perscholas.capstone.dto;


import com.perscholas.capstone.validation.FieldMatch;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@FieldMatch.List( { @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")})
public class UserDTO {

    @Pattern(regexp = "[A-Za-z]+$", message = "Only alphabetic allowed")
    private String firstName;

    @Pattern(regexp = "[A-Za-z]+$", message = "Only alphabetic allowed")
    private String lastName;

    @Column(unique = true)
    @Email
    private String email;


    @NotEmpty(message = "Required")
    private String password;

    @NotEmpty(message = "Required")
    private String matchingPassword;

    public UserDTO(@Pattern(regexp = "[A-Za-z]+$", message = "Only alphabetic allowed") String firstName,
                   @Pattern(regexp = "[A-Za-z]+$", message = "Only alphabetic allowed") String lastName,
                   @Email String email,
                   @NotEmpty(message = "Required") String password,
                   @NotEmpty(message = "Required") String matchingPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.matchingPassword = matchingPassword;
    }


}


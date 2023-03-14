/**
 * Code from example LAB - 309.8.1
 */
package org.vlopezn.visitednationalpark.dto;


import org.vlopezn.visitednationalpark.validation.FieldMatch;
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
    @NotEmpty(message = "Introduce first name")
    private String firstName;

    @Pattern(regexp = "[A-Za-z]+$", message = "Only alphabetic allowed")
    @NotEmpty(message = "Introduce last name")
    private String lastName;

    @Column(unique = true)
    @Email
    @NotEmpty(message = "Introduce email")
    private String email;


    @NotEmpty(message = "Introduce password")
    private String password;

    @NotEmpty(message = "Introduce password ")
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


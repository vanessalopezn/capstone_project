/**
 * @Class SecurityConfiguration
 * Code from example LAB - 309.8.1
 */
package org.vlopezn.visitednationalpark.security;

import org.vlopezn.visitednationalpark.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Autowired
    UserServiceImpl userDetailsService;


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService); //set the custom user details service
        auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
        return auth;
    }

    //beans
    //bcrypt bean definition
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

    /**@vlopezn
     * This method I modified this code for the project purpouse.
     * antMartchers(), force to be aunthenticadet if you try access direct.
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/visit_park_list").authenticated()
                .antMatchers("/ national_park_list").authenticated()
                .antMatchers("/national_park").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .defaultSuccessUrl("/visit_park_list", true)
                .permitAll()
                .failureUrl("/login/error")
                .and()
                .logout().logoutSuccessUrl("/log_out").permitAll()
                .deleteCookies("JSESSIONID");
        return http.build();
    }

}

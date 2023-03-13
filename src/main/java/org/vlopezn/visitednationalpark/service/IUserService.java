package org.vlopezn.visitednationalpark.service;

import org.vlopezn.visitednationalpark.dto.UserDTO;
import org.vlopezn.visitednationalpark.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {


    public UserDetails loadUserByUsername(String userName);
    public void saveUser(UserDTO userDTO);
    public User findUserByEmail(String email);
    public User findUserByName(String name);

    public void saveUpdateUser(User user);
    public User findUserById(Long id);

    public void delete(User user);
}

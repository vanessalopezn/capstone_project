package org.vlopezn.visitednationalpark.service;

import org.vlopezn.visitednationalpark.dto.UserDTO;
import org.vlopezn.visitednationalpark.model.Role;
import org.vlopezn.visitednationalpark.model.User;
import org.vlopezn.visitednationalpark.repository.UserRepository;
import org.vlopezn.visitednationalpark.security.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) {
        User user = userRepository.findUserByEmail(userName.trim());

        log.debug(userName);
        if (user == null) {
            log.warn("Invalid username or password {}", userName);

            throw new UsernameNotFoundException("Invalid username or password.");
        }
        /* return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),   mapRolesToAuthorities(user.getRoles()));*/
        return new UserPrincipal(user, roleService.getRolesByUser(user.getUser_id()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }


    /**
     * Using model mapper helps to avoid extra coding
     * @param userDTO
     */
    @Transactional
    public void saveUser(UserDTO userDTO)
    {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        User user = modelMapper.map(userDTO, User.class);

        user.setPassword(encoder.encode(user.getPassword()));
        List<Role> list = user.getRoles();
        list.add(roleService.findRoleByRoleName("USER"));
        user.setRoles(list);
        userRepository.save(user);
    }
    /**
     * This method updates User information.
     **/
    @Override
    public void saveUpdateUser(User user) {
        userRepository.save(user);
    }

    /**    * In this example login and email has the same values @param email @return
     */
    public User findUserByEmail(String email)
    {
        return userRepository.findUserByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));;
    }

    public User findUserByName(String name)
    {
        return null;// userRepository.findUserByUserName(name);
    }

    @Override
    public User findUserById(Long id) {
       return userRepository.findUserById(id);
    }
}

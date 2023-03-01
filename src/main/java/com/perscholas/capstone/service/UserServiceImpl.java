package com.perscholas.capstone.service;

import com.perscholas.capstone.model.User;
import com.perscholas.capstone.repository.UserRepository;
import com.perscholas.capstone.service.IUser;

public class UserImpl implements IUser {

    UserRepository userRepository;
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

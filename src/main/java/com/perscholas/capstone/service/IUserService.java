package com.perscholas.capstone.service;

import com.perscholas.capstone.model.User;

public interface IUser {

    public User findUserByEmail(String email);

}

package com.perscholas.capstone.service;

import com.perscholas.capstone.model.State;
import com.perscholas.capstone.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatesServiceImpl implements IStatesService{
    @Autowired
    StateRepository stateRepository;

    @Override
    public List<State> getAllStates() {
        return stateRepository.findAll();
    }
}

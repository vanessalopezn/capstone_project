package org.vlopezn.visitednationalpark.service;

import org.vlopezn.visitednationalpark.model.State;
import org.vlopezn.visitednationalpark.repository.StateRepository;
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

    @Override
    public State getStateByPark(Long park_id) {
        return stateRepository.findSateByPark(park_id);
    }

    @Override
    public List<State> findStatesWithParks() {
        return stateRepository.findStatesWithParks();
    }
}

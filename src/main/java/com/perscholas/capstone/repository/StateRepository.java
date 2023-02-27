package com.perscholas.capstone.repository;

import com.perscholas.capstone.model.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends CrudRepository<State, String> {

    List<State> findAll();
}

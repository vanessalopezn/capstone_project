package com.perscholas.capstone.repository;

import com.perscholas.capstone.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, String> {

    List<State> findAll();
}

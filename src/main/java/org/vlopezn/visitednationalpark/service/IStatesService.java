/**
 * @Author Vanessa Lopez Nunez
 * @Class IStateService
 * State sevice to handle state data.
 */
package org.vlopezn.visitednationalpark.service;

import org.vlopezn.visitednationalpark.model.State;

import java.util.List;

public interface IStatesService {

    List<State> getAllStates();
    State getStateByPark(Long park_id);

    List<State> findStatesWithParks();
}

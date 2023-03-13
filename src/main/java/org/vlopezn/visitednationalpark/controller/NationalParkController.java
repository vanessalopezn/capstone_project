package org.vlopezn.visitednationalpark.controller;

import org.vlopezn.visitednationalpark.model.NationalPark;
import org.vlopezn.visitednationalpark.model.State;
import org.vlopezn.visitednationalpark.service.INationalParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.vlopezn.visitednationalpark.service.IStatesService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class NationalParkController {
    INationalParkService nationalParkService;
    IStatesService statesService;
    @Autowired
    public NationalParkController(INationalParkService nationalParkService, IStatesService statesService) {
        this.nationalParkService = nationalParkService;
        this.statesService = statesService;
    }

    @GetMapping("/national_park_list")
    public String getParkList(Model model){
        List<State> statesList = statesService.findStatesWithParks();
        HashMap<String, List> parkList = new HashMap<>();
        for (State s:statesList
             ) {
            String key = s.getState_code() + "-" + s.getName();
            List<NationalPark> nationalParks = nationalParkService.getNationalParkByState(s.getState_code());
            List<String[]> parks = new ArrayList<>();
            for (NationalPark np:nationalParks
                 ) {
                String[] parkdetail = new String[3];
                parkdetail[0] = np.getNational_park_id().toString();
                parkdetail[1] = np.getName();
                parkdetail[2] = np.getLink();
                parks.add(parkdetail);
            }
            parkList.put(key, parks);
        }

        model.addAttribute("nplist", parkList);

        return "national_park_list";
    }


}

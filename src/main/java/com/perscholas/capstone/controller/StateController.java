package com.perscholas.capstone.controller;

import com.perscholas.capstone.model.NationalPark;
import com.perscholas.capstone.model.NationalParkVisit;
import com.perscholas.capstone.model.State;
import com.perscholas.capstone.service.INationalParkService;
import com.perscholas.capstone.service.IStatesService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class StateController {
    IStatesService iStatesService;
    INationalParkService nationalParkService;

    @Autowired
    public StateController(IStatesService iStatesService, INationalParkService nationalParkService) {
        this.iStatesService = iStatesService;
        this.nationalParkService = nationalParkService;
    }



    @GetMapping("/loadVisitNParkForm")
    public String getStatesList(Model model){
        List<State> states = iStatesService.getAllStates();
        model.addAttribute("state", new State());
        model.addAttribute("statelist", states);
        model.addAttribute("npvisit", new NationalParkVisit());

        List<NationalPark> np;

        Hashtable<String, List> ht_parkbycodeList = new Hashtable<>();
        for (State s : states
             ) {
                np = s.getNational_parks();
                List<String[]> newList = new ArrayList<>();
            for (NationalPark park : np
                 ) {

                String[] arr =  new String[2];
                arr[0] = park.getNational_park_id().toString();
                arr[1] = park.getName();
                newList.add(arr);
            }

            ht_parkbycodeList.put(s.getState_code(), newList);
        }

        model.addAttribute("parklistbycode", ht_parkbycodeList);
        return "national_park";
    }
}

/**
 * @Author Vanessa Lopez Nunez
 * @Class UserController
 * Class to manage States information in a visit national park
 */
package org.vlopezn.visitednationalpark.controller;

import org.vlopezn.visitednationalpark.model.NationalPark;
import org.vlopezn.visitednationalpark.model.NationalParkVisit;
import org.vlopezn.visitednationalpark.model.State;
import org.vlopezn.visitednationalpark.service.INationalParkService;
import org.vlopezn.visitednationalpark.service.IStatesService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    /**
     *  This method is call to create new visit,  then show national_park form.
     * @param model
     * @return
     */
    @GetMapping("/loadVisitNParkForm")
    public String loadVisitForm(Model model){

        List<State> states = iStatesService.getAllStates();
        model.addAttribute("state", new State());
        model.addAttribute("statelist", states);
        model.addAttribute("npvisit", new NationalParkVisit());
        model.addAttribute("errorMsg", "");
        model.addAttribute("parklistbycode", fillListDatatParks(states));

        return "national_park";
    }

    /**
     * This method is call after try to save a visit and occur an error.
     *
     * @param model
     * @param msg
     * @return
     */
    @GetMapping("/loadVisitNParkForm/{msg}")
    public String loadVisitForm(Model model, @PathVariable("msg") String msg){

        if(msg.equals("error")){
            msg = "The visit doesn't save";
        }

        List<State> states = iStatesService.getAllStates();
        model.addAttribute("state", new State());
        model.addAttribute("statelist", states);
        model.addAttribute("npvisit", new NationalParkVisit());
        model.addAttribute("errorMsg", msg);
        model.addAttribute("parklistbycode", fillListDatatParks(states));

        return "national_park";
    }

    /**
     * Method to create object hashtable where: key is [state-code] and
     * List of arrays String[park-i, park-name] like a value.
     * This object is to generate dynamic select in national_park form.
     * @param states
     * @return
     */
    public Hashtable<String, List> fillListDatatParks(List<State> states){

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
        return ht_parkbycodeList;
    }

}


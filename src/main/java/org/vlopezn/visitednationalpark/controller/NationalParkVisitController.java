/**
 * @Author Vanessa Lopez Nunez
 * @Class NationalParkVisitController
 * Class to manage request for visits
 */
package org.vlopezn.visitednationalpark.controller;

import org.vlopezn.visitednationalpark.model.NationalPark;
import org.vlopezn.visitednationalpark.model.NationalParkVisit;
import org.vlopezn.visitednationalpark.model.State;
import org.vlopezn.visitednationalpark.model.User;
import org.vlopezn.visitednationalpark.service.INationalParkService;
import org.vlopezn.visitednationalpark.service.INationalParkVisitService;
import org.vlopezn.visitednationalpark.service.IStatesService;
import org.vlopezn.visitednationalpark.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@Slf4j
public class NationalParkVisitController {
    INationalParkVisitService nationalParkVisitService;
    INationalParkService nationalParkService;
    IStatesService statesService;
    IUserService userService ;
    @Autowired
    public NationalParkVisitController(INationalParkVisitService nationalParkVisitService, IUserService userService,
                                       INationalParkService nationalParkService, IStatesService iStatesService) {
        this.nationalParkVisitService = nationalParkVisitService;
        this.userService = userService;
        this.nationalParkService = nationalParkService;
        this.statesService = iStatesService;
    }

    /**
     * Method is call to save a visit.
     * @param npvisit NationalParkVisit object
     * @param authentication Aunthentication object to get username
     * @return List of visited nationalPark form.
     */
    @PostMapping("/saveVisitNp")
    public String saveVisitNp(@Valid @ModelAttribute ("npvisit") NationalParkVisit npvisit, Authentication authentication){
        try {
            //Save visit to visit_national_park table
            nationalParkVisitService.saveNationalParkVisit(npvisit);

            /**
             * Get user email, to get all User information.
             * Update the visits from user.
             */
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User user = userService.findUserByEmail(userDetails.getUsername());
            List<NationalParkVisit> visitList = user.getVisits();
            visitList.add(npvisit);
            user.setVisits(visitList);

            try {
                userService.saveUpdateUser(user);
                log.warn("Add visit to User:" + userDetails.getUsername());
            }catch (Exception e){
                log.error(e.getMessage());
            }
        }catch (Exception e) {
            log.error("Doesn't save a visit. " + e.getMessage());
            return "redirect:loadVisitNParkForm/error";
        }

        return "visit_park_list";
    }

    /**
     * This method is call to show visted national park list by state.
     * @param model add attributes to use in visit_park_list
     * @param authentication Aunthentication object
     * @return form visit_park_list
     */
    @GetMapping("visit_park_list")
    public String visitParkList(Model model, Authentication authentication){
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.findUserByEmail(userDetails.getUsername()); //user object

        List<NationalParkVisit> visitList = user.getVisits(); //get user visits
        HashMap<String, List> ht_visitsbycodeList = new HashMap<>();

        for (NationalParkVisit visit: visitList
             ) {
                List<String[]> visitDetailList = new ArrayList<>();
                String[] visitDetail = new String[4];
                NationalPark np = nationalParkService.getNationalParkById(visit.getNational_park_id());//Get park information
                visitDetail[0] = visit.getVisit_id().toString();
                visitDetail[1] = visit.getNational_park_id().toString();
                visitDetail[2] = np.getName();
                visitDetail[3] = format.format(visit.getStart_date()) + " - " + format.format(visit.getEnd_date());

                State state = statesService.getStateByPark(visit.getNational_park_id());
                String key = state.getState_code()+"-"+state.getName();

                if(ht_visitsbycodeList.get(key) == null){
                    visitDetailList.add(visitDetail);
                    ht_visitsbycodeList.put(key, visitDetailList);
                }else {
                    List<String[]> newList = ht_visitsbycodeList.get(key);
                    newList.add(visitDetail);
                    ht_visitsbycodeList.put(key, newList);
                }

        }
        model.addAttribute("visit_detail_list", ht_visitsbycodeList);

        return "visit_park_list";
    }

}

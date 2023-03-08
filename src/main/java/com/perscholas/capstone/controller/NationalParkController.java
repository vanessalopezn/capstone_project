package com.perscholas.capstone.controller;

import com.perscholas.capstone.model.NationalPark;
import com.perscholas.capstone.model.State;
import com.perscholas.capstone.service.INationalParkService;
import com.perscholas.capstone.validation.FieldMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NationalParkController {
    INationalParkService nationalParkService;

    @Autowired
    public NationalParkController(INationalParkService nationalParkService) {
        this.nationalParkService = nationalParkService;
    }

    @GetMapping("/all_national_park_list")
    public String getParkList(Model model){
        System.out.println("getParkList");
        //List<NationalPark> nationalParks = nationalParkService.getAllNationalPark();
        //model.addAttribute("nplist", nationalParks);

        return "all_national_park_list";
    }


}

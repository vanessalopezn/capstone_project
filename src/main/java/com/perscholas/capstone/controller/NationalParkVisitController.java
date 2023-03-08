package com.perscholas.capstone.controller;

import com.perscholas.capstone.model.NationalParkVisit;
import com.perscholas.capstone.service.INationalParkVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingErrorProcessor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class NationalParkVisitController {
    INationalParkVisitService nationalParkVisitService;
    @Autowired
    public NationalParkVisitController(INationalParkVisitService nationalParkVisitService) {
        this.nationalParkVisitService = nationalParkVisitService;
    }

    @PostMapping("/saveVisitNp")
    public String saveVisitNp(@Valid NationalParkVisit npvisit, BindingResult errors, Model model){
        System.out.println("saveVisit");
        nationalParkVisitService.saveNationalParkVisit(npvisit);

        return "visit_park_list";
    }

    @GetMapping("visit_park_list")
    public String visitParkList(Model model){


        return "visit_park_list";
    }



}

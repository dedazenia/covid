package ru.gorobets24.covid.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gorobets24.covid.models.LocationCases;
import ru.gorobets24.covid.services.CovidDataService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CovidDataService covidDataService;

    @GetMapping("/")
    public String home(Model model) {
       List<LocationCases> locationCases = covidDataService.getAllStats();
        model.addAttribute("LocationCases", locationCases);
        return "home";
    }
}


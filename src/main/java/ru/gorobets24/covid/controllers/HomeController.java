package ru.gorobets24.covid.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gorobets24.covid.services.CovidDataService;

@Controller
public class HomeController {

    @Autowired
    CovidDataService covidDataService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("LocationCases", covidDataService.getAllStats());
        return "home";
    }
}


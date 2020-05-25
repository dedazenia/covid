package ru.gorobets24.covid.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MainController {
    public String index(){
        return "index";
    }

}


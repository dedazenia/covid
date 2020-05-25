package ru.gorobets24.covid.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

   @RequestMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/1")
    public ResponseEntity<String> one(){
        return ResponseEntity.ok("works");
    }

}


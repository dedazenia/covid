package ru.gorobets24.covid.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

   @GetMapping("/")
    public String home(){
        return "home.html";
    }
    @GetMapping("/1")
    public ResponseEntity<String> one(){
        return ResponseEntity.ok("works");
    }

}


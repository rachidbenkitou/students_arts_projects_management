package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

/*

    @Autowired
    private EntretienService entretienService;

    @GetMapping("/")
    public String DefaultPage(Model model){
        List<Entretien> entretienList=entretienService.findAll();
        model.addAttribute("entretienList",entretienList);

        return "entretien/list-entretien";
    }*/
    @GetMapping ("/login")
    public String LoginPage(){
        return "loginP/login-page";
    }
}

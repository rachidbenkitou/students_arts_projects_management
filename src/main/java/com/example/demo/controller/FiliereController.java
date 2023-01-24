package com.example.demo.controller;

import com.example.demo.entity.Filiere;
import com.example.demo.service.serviceInt.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class FiliereController {
    @Autowired
    private FiliereService filiereService;



    @GetMapping("/list")
    public String listFilieres(Model theModel){
        //Get Filieres From Database

        List<Filiere> theFilieres=filiereService.findAll();

        //Add list of filieres to the Spring Model
        theModel.addAttribute("listFilieres",theFilieres);

        return "lists/list-filiere";
        //ateliers/list-ateliers

    }

    @GetMapping("/delete/{filiereId}")
    public String deleteEntretien(@PathVariable Long filiereId){

        filiereService.deleteById(filiereId);

        return "redirect:/filieres/list";
    }

    @GetMapping("/form")
    public String showFiliereForm(Model model){
        model.addAttribute("filiere", new Filiere());

        return "forms/form-filiere";
    }

    @GetMapping("/edit/{filiereId}")
    public String showEditForm(@PathVariable  Long filiereId ,Model model){
        Filiere filiere=filiereService.findById(filiereId);
        model.addAttribute("filiere",filiere);

        return "forms/form-filiere";
    }

    @PostMapping("save")
    public String saveFiliere(Filiere filiere){
        filiereService.save(filiere);
        return"redirect:/filieres/list";

    }


    @GetMapping("/search")
    public String searchByType(@RequestParam("name") String name, Model model){

        if(name.trim().isEmpty()){
            return "redirect:/filieres/list";
        }else {
            List<Filiere> filiereList=filiereService.searchBy(name);
            model.addAttribute("listFilieres",filiereList);
            return "lists/list-filiere";
        }
    }
}

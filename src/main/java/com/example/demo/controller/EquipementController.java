package com.example.demo.controller;


import com.example.demo.entity.Equipement;
import com.example.demo.entity.Filiere;
import com.example.demo.entity.Produit;
import com.example.demo.service.serviceInt.EquipementService;
import com.example.demo.service.serviceInt.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/equipements")
public class EquipementController {
    @Autowired
    private EquipementService equipementService;

    @Autowired
    private FiliereService filiereService;


    @GetMapping("/list")
    public String showEquipementList(Model model){

        List<Equipement> equipementList=equipementService.findAll();
        model.addAttribute("equipementList",equipementList);

        return "lists/list-equipement";

    }


    @GetMapping("/form")
    public String showFormForAdd(Model model){

        Equipement equipement=new Equipement();
        model.addAttribute("equipement",equipement);

        List<Filiere> filiereList=filiereService.findAll();
        model.addAttribute("filiereList",filiereList);
        return "forms/form-equipement";
    }



    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("equipement") @Validated Equipement equipement, BindingResult bindingResult){


        if(bindingResult.hasErrors()){
            return "forms/form-equipement";

        }
        else {
            equipementService.save(equipement);


            return "redirect:/equipements/list";

        }




    }

    @GetMapping("/delete/{equipementId}")
    public String deleteEquipement(@PathVariable Long equipementId){

        equipementService.deleteById(equipementId);
        return "redirect:/equipements/list";
    }



    @GetMapping("/edit/{equipementId}")
    public String showEditForm(@PathVariable  Long equipementId ,Model model){
        Equipement equipement=equipementService.findById(equipementId);
        model.addAttribute("equipement",equipement);

        List<Filiere> filiereList=filiereService.findAll();
        model.addAttribute("filiereList",filiereList);

        return "forms/form-equipement";
    }

    /*
    @GetMapping("/search")
    public String searchByType(@RequestParam("name") String name,Model model){

        if(name.trim().isEmpty()){
            return "redirect:/equipements/list";
        }else {
            List<Equipement> equipementList=equipementService.searchBy(name);

            model.addAttribute("equipementList",equipementList);

            return "lists/list-equipement";
        }
    }

    @GetMapping("/searchByDate")
    public String searchByDate(@RequestParam("date1") String date1,@RequestParam("date2") String date2,Model model){

        if(date1.trim().isEmpty() && date2.trim().isEmpty()){
            return "redirect:/equipements/list";
        }else {
            List<Equipement> equipementList=equipementService.searchByDate(date1,date2);

            model.addAttribute("equipementList",equipementList);

            return "lists/list-equipement";
        }
    }

     */


    @GetMapping("/searchByCab")
    public String searchByCab(@RequestParam("textt") String text,Model model){

        if(text.trim().isEmpty()){
            return "redirect:/equipements/list";
        }else {
            Long cab=Long.parseLong(text);
            List<Equipement> equipementList=equipementService.searchByCab(cab);

            model.addAttribute("equipementList",equipementList);

            return "lists/list-equipement";
        }
    }

    @GetMapping("/searchByNumeroMarche")
    public String searchByNumeroMarche(@RequestParam("textt") String numeroMarche,Model model){

        if(numeroMarche.trim().isEmpty()){
            return "redirect:/equipements/list";
        }else {
            List<Equipement> equipementList=equipementService.searchByNumeroMarche(numeroMarche);

            model.addAttribute("equipementList",equipementList);

            return "lists/list-equipement";
        }
    }

    @GetMapping("/searchByCourant")
    public String searchByCourant(@RequestParam("textt") String text,Model model){

        if(text.trim().isEmpty()){
            return "redirect:/equipements/list";
        }else {
            double courant=Double.parseDouble(text);
            List<Equipement> equipementList=equipementService.searchByCourant(courant);

            model.addAttribute("equipementList",equipementList);

            return "lists/list-equipement";
        }
    }

    @GetMapping("/searchByPuissance")
    public String searchByPuissance(@RequestParam("textt") String text,Model model){

        if(text.trim().isEmpty()){
            return "redirect:/equipements/list";
        }else {
            double puissance=Double.parseDouble(text);
            List<Equipement> equipementList=equipementService.searchByPuissance(puissance);

            model.addAttribute("equipementList",equipementList);

            return "lists/list-equipement";
        }
    }

    @GetMapping("/searchByTension")
    public String searchByTension(@RequestParam("textt") String text,Model model){

        if(text.trim().isEmpty()){
            return "redirect:/equipements/list";
        }else {
            double tension=Double.parseDouble(text);
            List<Equipement> equipementList=equipementService.searchByTension(tension);

            model.addAttribute("equipementList",equipementList);

            return "lists/list-equipement";
        }
    }

    @GetMapping("/searchByDateAcquisition")
    public String searchByDateAcquisition(@RequestParam("textt") String text,Model model){

        if(text.trim().isEmpty()){
            return "redirect:/equipements/list";
        }else {
            //double tension=Double.parseDouble(text);
            List<Equipement> equipementList=equipementService.searchByDateAcquisition(text);

            model.addAttribute("equipementList",equipementList);

            return "lists/list-equipement";
        }
    }

    @GetMapping("/searchByDateFabrication")
    public String searchByDateFabrication(@RequestParam("textt") String text,Model model){

        if(text.trim().isEmpty()){
            return "redirect:/equipements/list";
        }else {
            //double tension=Double.parseDouble(text);
            List<Equipement> equipementList=equipementService.searchByDateFabrication(text);

            model.addAttribute("equipementList",equipementList);

            return "lists/list-equipement";
        }
    }

    @GetMapping("/searchByDesignation")
    public String searchByDesignation(@RequestParam("textt") String text,Model model){

        if(text.trim().isEmpty()){
            return "redirect:/equipements/list";
        }else {
            //double tension=Double.parseDouble(text);
            List<Equipement> equipementList=equipementService.searchByDesignation(text);

            model.addAttribute("equipementList",equipementList);

            return "lists/list-equipement";
        }
    }

    @GetMapping("/searchByLocalisation")
    public String searchByLocalisation(@RequestParam("textt") String text,Model model){

        if(text.trim().isEmpty()){
            return "redirect:/equipements/list";
        }else {
            //double tension=Double.parseDouble(text);
            List<Equipement> equipementList=equipementService.searchByLocalisation(text);

            model.addAttribute("equipementList",equipementList);

            return "lists/list-equipement";
        }
    }

    @GetMapping("/searchByFiliere")
    public String searchByFiliere(@RequestParam("textt") String text,Model model){

        if(text.trim().isEmpty()){
            return "redirect:/equipements/list";
        }else {
            //double tension=Double.parseDouble(text);
            List<Equipement> equipementList=equipementService.searchByFiliere(text);

            model.addAttribute("equipementList",equipementList);

            return "lists/list-equipement";
        }
    }

    @GetMapping("/searchByMarque")
    public String searchByMarque(@RequestParam("textt") String text,Model model){

        if(text.trim().isEmpty()){
            return "redirect:/equipements/list";
        }else {
            //double tension=Double.parseDouble(text);
            List<Equipement> equipementList=equipementService.searchByMarque(text);

            model.addAttribute("equipementList",equipementList);

            return "lists/list-equipement";
        }
    }

}

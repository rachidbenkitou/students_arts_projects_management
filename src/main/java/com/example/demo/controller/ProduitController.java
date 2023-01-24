package com.example.demo.controller;


import com.example.demo.configuration.FileUploadUtil;
import com.example.demo.entity.Equipement;
import com.example.demo.entity.Filiere;
import com.example.demo.entity.Produit;
import com.example.demo.pdf.product.ProductVentrePdf;
import com.example.demo.service.serviceInt.FiliereService;
import com.example.demo.service.serviceInt.ProduitService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/produits")
@MultipartConfig(maxFileSize = 1024*1024*1024, maxRequestSize = 1024*1024*1024)
public class ProduitController {

    @Autowired
    private ProduitService produitService;



    @GetMapping("/list")
    public String showEntretiensList(Model model){

        List<Produit> produitList=produitService.findAll();
        model.addAttribute("produitList",produitList);

        return "lists/list-produit";

    }


    @GetMapping("/form")
    public String showFormForAdd(Model model){

        Produit produit=new Produit();
        model.addAttribute("produit",produit);



        return "forms/form-produit";
    }


    /*

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("produit") Produit produit, BindingResult bindingResult){


        if(bindingResult.hasErrors()){
            return "forms/form-produit";

        }
        else {
            produitService.save(produit);


            return "redirect:/produits/list";

        }




    }
*/

    /*
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("produit") @Validated Produit produit, BindingResult bindingResult
            ,@RequestParam("image") MultipartFile multipartFile) throws IOException{

        if(bindingResult.hasErrors()){
            return "forms/form-produit";

        }
        else {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            produit.setImage(fileName);
            Produit produit1= produitService.save(produit);
            try{

                //String uploadDir = "product-photos/" + produit1.getId_produit();
                String uploadDir = "C:\\application_web_gestion_entretiens_produits_mobilités\\produits-images\\" + produit1.getId();
                FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
            }catch (Exception e){
                System.out.println(e);
            }
            return "redirect:/produits/list";
        }
    }

     */
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("produit") @Validated Produit produit, BindingResult bindingResult
            ,@RequestParam("image") MultipartFile multipartFile) throws IOException{


            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            produit.setImage(fileName);
            Produit produit1= produitService.save(produit);
            try{

                //String uploadDir = "product-photos/" + produit1.getId_produit();
                String uploadDir = "C:\\application_web_gestion_entretiens_produits_mobilités\\produits-images\\" + produit1.getId();
                FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
            }catch (Exception e){
                System.out.println(e);
            }
            return "redirect:/produits/list";

    }



    @GetMapping("/edit/{entretienId}")
    public String showEditForm(@PathVariable Long entretienId , Model model){
        Produit produit=produitService.findById(entretienId);
        model.addAttribute("produit",produit);




        return "forms/form-produit";
    }


    @GetMapping("/delete/{entretienId}")
    public String deleteEntretien(@PathVariable Long entretienId){

        produitService.deleteById(entretienId);

        return "redirect:/produits/list";
    }


    @GetMapping("/searchByNumeroProduction")
    public String searchByNumeroProduction(@RequestParam("textt") String text,Model model){

        if(text.trim().isEmpty()){
            return "redirect:/produits/list";
        }else {
            Long numeroProduction=Long.parseLong(text);
            List<Produit> produitList=produitService.searchByNumeroProduction(numeroProduction);

            model.addAttribute("produitList",produitList);

            return "lists/list-produit";
        }
    }

    @GetMapping("/searchByNumeroDon")
    public String searchByNumeroDon(@RequestParam("textt") String text,Model model){

        if(text.trim().isEmpty()){
            return "redirect:/produits/list";
        }else {
            Long numeroDon=Long.parseLong(text);
            List<Produit> produitList=produitService.searchByNumeroDon(numeroDon);

            model.addAttribute("produitList",produitList);

            return "lists/list-produit";
        }
    }

    @GetMapping("/searchByNumeroAffectation")
    public String searchByNumeroAffectation(@RequestParam("textt") String numeroAffectation,Model model){

        if(numeroAffectation.trim().isEmpty()){
            return "redirect:/produits/list";
        }else {
            //Long numeroAffectation=Long.parseLong(text);
            List<Produit> produitList=produitService.searchByNumeroAffectation(numeroAffectation);

            model.addAttribute("produitList",produitList);

            return "lists/list-produit";
        }
    }

    @GetMapping("/searchByNumeroProcesVerbal")
    public String searchByNumeroProcesVerbal(@RequestParam("textt") String numeroProcesVerbal,Model model){

        if(numeroProcesVerbal.trim().isEmpty()){
            return "redirect:/produits/list";
        }else {
            //Long numeroProcesVerbal=Long.parseLong(text);
            List<Produit> produitList=produitService.searchByNumeroProcesVerbal(numeroProcesVerbal);

            model.addAttribute("produitList",produitList);

            return "lists/list-produit";
        }
    }

    @GetMapping("/searchByDateProcesVerbal")
    public String searchByDateProcesVerbal(@RequestParam("textt") String DateProcesVerbal,Model model){

        List<Produit> produitList=produitService.searchByDateProcesVerbal(DateProcesVerbal);

        model.addAttribute("produitList",produitList);

        return "lists/list-produit";
    }

    @GetMapping("/searchByDateAffectation")
    public String searchByDateAffectation(@RequestParam("textt") String DateAffectation,Model model){

        List<Produit> produitList=produitService.searchByDateAffectation(DateAffectation);

        model.addAttribute("produitList",produitList);

        return "lists/list-produit";
    }

    @GetMapping("/searchByDateDon")
    public String searchByDateDon(@RequestParam("textt") String DateDon,Model model){

        List<Produit> produitList=produitService.searchByDateDon(DateDon);

        model.addAttribute("produitList",produitList);

        return "lists/list-produit";
    }

    @GetMapping("/searchByNature")
    public String searchByNature(@RequestParam("textt") String nature,Model model){

        if(nature.trim().isEmpty()){
            return "redirect:/produits/list";
        }else {
            //Long numeroProcesVerbal=Long.parseLong(text);
            List<Produit> produitList=produitService.searchByNature(nature);

            model.addAttribute("produitList",produitList);

            return "lists/list-produit";
        }
    }

    @GetMapping("/searchByDecision")
    public String searchByDecision(@RequestParam("textt") String decision,Model model){

        if(decision.trim().isEmpty()){
            return "redirect:/produits/list";
        }else {
            //Long numeroProcesVerbal=Long.parseLong(text);
            List<Produit> produitList=produitService.searchByDecision(decision);

            model.addAttribute("produitList",produitList);

            return "lists/list-produit";
        }
    }


    @GetMapping("/searchByCode")
    public String  searchByCode(@RequestParam("textt") String code,Model model){

        if(code.trim().isEmpty()){
            return "redirect:/produits/list";
        }else {
            //Long numeroProcesVerbal=Long.parseLong(text);
            List<Produit> produitList=produitService.searchByCode(code);

            model.addAttribute("produitList",produitList);

            return "lists/list-produit";
        }
    }


    @GetMapping("/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=produits_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Produit> produitList = produitService.findAll();

        ProductVentrePdf exporter = new ProductVentrePdf(produitList);
        exporter.export(response);

    }

}




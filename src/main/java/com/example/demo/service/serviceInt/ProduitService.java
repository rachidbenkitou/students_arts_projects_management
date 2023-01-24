package com.example.demo.service.serviceInt;


import com.example.demo.entity.Produit;

import java.util.List;

public interface ProduitService {


    public List<Produit> findAll();
    public Produit save(Produit produit);

    public Produit findById(Long theId);

    public void deleteById(Long theId);


    public List<Produit> searchByNumeroProduction(Long text);

    public List<Produit> searchByNumeroDon(Long text);

    public List<Produit> searchByNumeroAffectation(String text);

    public List<Produit> searchByNumeroProcesVerbal(String text);

    public List<Produit> searchByDateProcesVerbal(String text);

    public List<Produit> searchByDateAffectation(String text);

    public List<Produit> searchByDateDon(String text);

    public List<Produit> searchByNature(String text);

    public List<Produit> searchByDecision(String text);

    public List<Produit> searchByCode(String text);




}

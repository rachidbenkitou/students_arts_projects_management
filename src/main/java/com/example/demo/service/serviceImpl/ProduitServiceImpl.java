package com.example.demo.service.serviceImpl;


import com.example.demo.dao.ProduitRepository;
import com.example.demo.entity.Produit;
import com.example.demo.service.serviceInt.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    @Override
    public Produit save(Produit produit) {
        Produit produit1=produitRepository.save(produit);
        return produit1;
    }

    @Override
    public Produit findById(Long theId) {
        Optional<Produit> result=produitRepository.findById(theId);

        Produit produit=null;
        if(result.isPresent()){
            produit=result.get();
        }
        else {
            throw  new RuntimeException("Le produit qui a Id :"+theId+"n'existe pas");
        }
        return produit;
    }

    @Override
    public void deleteById(Long theId) {
        produitRepository.deleteById(theId);

    }


    @Override
    public List<Produit> searchByNumeroProduction(Long text) {
        return produitRepository.searchByNumeroProduction(text);
    }

    @Override
    public List<Produit> searchByNumeroDon(Long text) {
        return produitRepository.searchByNumeroDon(text);
    }

    @Override
    public List<Produit> searchByNumeroAffectation(String text) {
        return produitRepository.searchByNumeroAffectation(text);
    }

    @Override
    public List<Produit> searchByNumeroProcesVerbal(String text) {
        return produitRepository.searchByNumeroProcesVerbal(text);
    }

    @Override
    public List<Produit> searchByDateProcesVerbal(String text) {
        return produitRepository.searchByDateProcesVerbal(text);
    }

    @Override
    public List<Produit> searchByDateAffectation(String text) {
        return produitRepository.searchByDateAffectation(text);
    }

    @Override
    public List<Produit> searchByDateDon(String text) {
        return produitRepository.searchByDateDon(text);
    }

    @Override
    public List<Produit> searchByNature(String text) {
        return produitRepository.searchByNature(text);
    }

    @Override
    public List<Produit> searchByDecision(String text) {
        return produitRepository.searchByDecision(text);
    }

    @Override
    public List<Produit> searchByCode(String text) {
        return produitRepository.searchByCode(text);
    }


}

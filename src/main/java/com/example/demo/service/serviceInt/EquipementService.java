package com.example.demo.service.serviceInt;



import com.example.demo.entity.Equipement;
import com.example.demo.entity.Produit;

import java.util.List;

public interface EquipementService {

    public List<Equipement> findAll();
    public void save(Equipement equipement);

    public Equipement findById(Long theId);

    public void deleteById(Long theId);

    public List<Equipement> searchByCab(Long text);

    public List<Equipement> searchByNumeroMarche(String text);

    public List<Equipement> searchByCourant(double text);

    public List<Equipement> searchByPuissance(double text);

    public List<Equipement> searchByTension(double text);

    public List<Equipement> searchByDateAcquisition(String text);

    public List<Equipement> searchByDateFabrication(String text);

    public List<Equipement> searchByDesignation(String text);

    public List<Equipement> searchByLocalisation(String text);

    public List<Equipement> searchByFiliere(String text);

    public List<Equipement> searchByMarque(String text);


}

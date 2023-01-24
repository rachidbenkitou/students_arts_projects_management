package com.example.demo.dao;


import com.example.demo.entity.Equipement;
import com.example.demo.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquipementRepository extends JpaRepository<Equipement,Long> {

    @Query("SELECT t FROM Equipement t WHERE t.cab = ?1")
    public List<Equipement> searchByCab(Long text);

    @Query("SELECT t FROM Equipement t WHERE t.numeroMarche= ?1")
    public List<Equipement> searchByNumeroMarche(String text);

    @Query("SELECT t FROM Equipement t WHERE t.courant= ?1")
    public List<Equipement> searchByCourant(double text);

    @Query("SELECT t FROM Equipement t WHERE t.puissance= ?1")
    public List<Equipement> searchByPuissance(double text);

    @Query("SELECT t FROM Equipement t WHERE t.tension= ?1")
    public List<Equipement> searchByTension(double text);

    @Query("SELECT t FROM Equipement t WHERE t.dateAcquisition= ?1")
    public List<Equipement> searchByDateAcquisition(String text);

    @Query("SELECT t FROM Equipement t WHERE t.dateFabriquation= ?1")
    public List<Equipement> searchByDateFabrication(String text);

    @Query("SELECT t FROM Equipement t WHERE t.localisation= ?1")
    public List<Equipement> searchByLocalisation(String text);

    @Query("SELECT t FROM Equipement t WHERE t.designation= ?1")
    public List<Equipement> searchByDesignation(String text);

    @Query("SELECT t FROM Equipement t WHERE t.filiere.nom= ?1")
    public List<Equipement> searchByFiliere(String text);

    @Query("SELECT t FROM Equipement t WHERE t.marque= ?1")
    public List<Equipement> searchByMarque(String text);
}

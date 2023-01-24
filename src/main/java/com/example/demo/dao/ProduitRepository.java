package com.example.demo.dao;


import com.example.demo.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Long> {


    @Query("SELECT t FROM Produit t WHERE t.numeroProduction = ?1")
    public List<Produit> searchByNumeroProduction(Long text);

    @Query("SELECT t FROM Produit t WHERE t.numeroDon = ?1")
    public List<Produit> searchByNumeroDon(Long text);

    @Query("SELECT t FROM Produit t WHERE t.numeroAffectation= ?1")
    public List<Produit> searchByNumeroAffectation(String text);

    @Query("SELECT t FROM Produit t WHERE t.numeroProcesVerbal= ?1")
    public List<Produit> searchByNumeroProcesVerbal(String text);

    @Query("SELECT t FROM Produit t WHERE t.dateProcesVerbal= ?1")
    public List<Produit> searchByDateProcesVerbal(String text);

    @Query("SELECT t FROM Produit t WHERE t.dateAffectation= ?1")
    public List<Produit> searchByDateAffectation(String text);

    @Query("SELECT t FROM Produit t WHERE t.dateDon= ?1")
    public List<Produit> searchByDateDon(String text);

    @Query("SELECT t FROM Produit t WHERE t.nature= ?1")
    public List<Produit> searchByNature(String text);

    @Query("SELECT t FROM Produit t WHERE t.decision= ?1")
    public List<Produit> searchByDecision(String text);

    @Query("SELECT t FROM Produit t WHERE t.code= ?1")
    public List<Produit> searchByCode(String text);

}

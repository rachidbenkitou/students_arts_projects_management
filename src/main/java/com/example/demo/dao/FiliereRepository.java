package com.example.demo.dao;

import com.example.demo.entity.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FiliereRepository extends JpaRepository<Filiere,Long> {
    @Query("SELECT t FROM Filiere t WHERE t.nom = ?1")
    public List<Filiere> findByNom_filiere(String name);
}

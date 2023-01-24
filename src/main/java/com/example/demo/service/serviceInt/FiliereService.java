package com.example.demo.service.serviceInt;

import com.example.demo.entity.Filiere;

import java.util.List;

public interface FiliereService {
    public List<Filiere> findAll();



    public void save(Filiere filiere);

    public Filiere findById(Long theId);

    public void deleteById(Long theId);

    public List<Filiere> searchBy(String name);
}

package com.example.demo.service.serviceImpl;


import com.example.demo.dao.EquipementRepository;
import com.example.demo.entity.Equipement;
import com.example.demo.service.serviceInt.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipementServiceImpl implements EquipementService {

    @Autowired
    private EquipementRepository equipementRepository;

    @Override
    public List<Equipement> findAll() {
        return equipementRepository.findAll();
    }

    @Override
    public void save(Equipement equipement) {
        equipementRepository.save(equipement);

    }

    @Override
    public Equipement findById(Long theId) {
        Optional<Equipement> result=equipementRepository.findById(theId);

        Equipement equipement=null;
        if(result.isPresent()){
           equipement=result.get();
        }
        else {
            throw  new RuntimeException("L'equipement qui a Id :"+theId+"n'existe pas");
        }
        return equipement;
    }

    @Override
    public void deleteById(Long theId) {
    equipementRepository.deleteById(theId);
    }

    @Override
    public List<Equipement> searchByCab(Long text) {
        return equipementRepository.searchByCab(text);
    }

    @Override
    public List<Equipement> searchByNumeroMarche(String text) {
        return equipementRepository.searchByNumeroMarche(text);
    }

    @Override
    public List<Equipement> searchByCourant(double text) {
        return equipementRepository.searchByCourant(text);
    }

    @Override
    public List<Equipement> searchByPuissance(double text) {
        return equipementRepository.searchByPuissance(text);
    }

    @Override
    public List<Equipement> searchByTension(double text) {
        return equipementRepository.searchByTension(text);
    }

    @Override
    public List<Equipement> searchByDateAcquisition(String text) {
        return equipementRepository.searchByDateAcquisition(text);
    }

    @Override
    public List<Equipement> searchByDateFabrication(String text) {
        return equipementRepository.searchByDateFabrication(text);
    }

    @Override
    public List<Equipement> searchByDesignation(String text) {
        return equipementRepository.searchByDesignation(text);
    }

    @Override
    public List<Equipement> searchByLocalisation(String text) {
        return equipementRepository.searchByLocalisation(text);
    }

    @Override
    public List<Equipement> searchByFiliere(String text) {
        return equipementRepository.searchByFiliere(text);
    }

    @Override
    public List<Equipement> searchByMarque(String text) {
        return equipementRepository.searchByMarque(text);
    }


}

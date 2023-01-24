package com.example.demo.service.serviceImpl;

import com.example.demo.dao.FiliereRepository;
import com.example.demo.entity.Filiere;
import com.example.demo.service.serviceInt.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FiliereServiceImpl implements FiliereService {
    @Autowired
    private FiliereRepository filiereRepository;

    @Override
    public List<Filiere> findAll() {
        return filiereRepository.findAll();
    }

    @Override
    public void save(Filiere filiere) {
        filiereRepository.save(filiere);
    }

    @Override
    public Filiere findById(Long theId) {
        Optional<Filiere> result=filiereRepository.findById(theId);

        Filiere filiere=null;
        if(result.isPresent()){
            filiere=result.get();
        }
        else {
            throw  new RuntimeException("La filiere qui a Id :"+theId+"n'existe pas");
        }
        return filiere;
    }

    @Override
    public void deleteById(Long theId) {

        filiereRepository.deleteById(theId);
    }

    @Override
    public List<Filiere> searchBy(String name) {
        return filiereRepository.findByNom_filiere(name);
    }
}

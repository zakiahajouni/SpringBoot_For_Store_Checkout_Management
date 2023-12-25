package com.caisse.caisseprojectinteg.service;

import com.caisse.caisseprojectinteg.entities.Categorie;
import com.caisse.caisseprojectinteg.repos.CategorieRepository;
import com.caisse.caisseprojectinteg.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class CategorieServiceImpl implements CategorieService {
    @Autowired
    CategorieRepository catRepository ;

    @Override
    public Categorie saveCategorie(Categorie p) {
        return catRepository.save(p) ;
    }

    @Override
    public Categorie updateCategorie(Categorie p) {
        return catRepository.save(p);
    }

    @Override
    public Categorie getCategorie(Long id) {
        return catRepository.findById(id).get();
    }

    @Override
    public List<Categorie> getAllCategories() {
        return catRepository.findAll();
    }

    @Override
    public List<Categorie> findBylibelleCat(String libelleCat) {
        return catRepository.findBylibelleCat(libelleCat);
    }

    @Override
    public void deleteCategorieById(Long id) {
        catRepository.deleteById(id);
    }

    @Override
    public Long count() {
        return catRepository.count();
    }








}

package com.caisse.caisseprojectinteg.service;

import com.caisse.caisseprojectinteg.entities.Categorie;

import java.util.List;

public interface CategorieService {

        Categorie saveCategorie(Categorie c);
        Categorie updateCategorie(Categorie c);
        Categorie getCategorie(Long id);
        List<Categorie> getAllCategories();
        List<Categorie> findBylibelleCat(String libelleCat);
        void deleteCategorieById(Long id);

        Long count();}

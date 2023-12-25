package com.caisse.caisseprojectinteg.repos;

import com.caisse.caisseprojectinteg.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


    public interface ProduitRepository extends JpaRepository<Produit, Long> {
        List<Produit> findBylibelle(String libelle);
        long count();







    }

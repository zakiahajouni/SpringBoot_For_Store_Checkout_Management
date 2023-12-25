package com.caisse.caisseprojectinteg.repos;

import com.caisse.caisseprojectinteg.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    List<Categorie> findBylibelleCat(String libelleCat);
    long count();
}

package com.caisse.caisseprojectinteg.service;

import com.caisse.caisseprojectinteg.entities.Produit;

import java.util.List;

public interface ProduitService {
    Produit saveProduit(Produit p);
    Produit updateProduit(Produit p);
    Produit getProduit(Long id);
    List<Produit> getAllProduits();
    List<Produit> findBylibelle(String libelle);

    Long count();
    //void updateProductQuantityAndCheckAvailability(Long productId, int newQuantity);
}

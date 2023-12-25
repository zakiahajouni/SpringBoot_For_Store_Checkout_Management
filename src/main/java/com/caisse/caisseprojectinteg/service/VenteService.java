package com.caisse.caisseprojectinteg.service;

import com.caisse.caisseprojectinteg.entities.Produit;
import com.caisse.caisseprojectinteg.entities.Vente;

import java.util.List;
import java.util.Map;

public interface VenteService {

    Vente saveVente(Vente v);

    Vente updateVente(Vente v);

    Vente getVente(Long id);

    List<Vente> getAllVentes();

    List<Vente> findByNumTicket(Long NumTicket);

    Vente addVenteWithProducts(Vente vente, List<Long> selectedProductIds, List<Integer> quantities);

    Long count();
    public Long getTotalSalesForMonth(int year, int month);
    public Produit findMostSoldProduct();
    List<Object[]> getVenteWithProduits(Long venteId);

}
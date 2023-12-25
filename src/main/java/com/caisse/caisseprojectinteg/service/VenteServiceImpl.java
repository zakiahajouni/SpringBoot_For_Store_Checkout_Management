package com.caisse.caisseprojectinteg.service;

import com.caisse.caisseprojectinteg.entities.Produit;
import com.caisse.caisseprojectinteg.entities.Vente;
import com.caisse.caisseprojectinteg.entities.VenteProduit;
import com.caisse.caisseprojectinteg.repos.ProduitRepository;
import com.caisse.caisseprojectinteg.repos.VenteProduitRepository;
import com.caisse.caisseprojectinteg.repos.VenteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service

public class VenteServiceImpl implements VenteService {
    @Autowired
    VenteRepository venteRepository ;
    @Autowired
    ProduitRepository produitRepository ;

    @Autowired
    VenteProduitRepository venteproduitRepository ;

    @Override
    public Vente saveVente(Vente v) {
        return venteRepository.save(v);
    }

    @Override
    public Vente updateVente(Vente v) {
        return venteRepository.save(v);
    }

    @Override
    public Vente getVente(Long id) {
        return venteRepository.findById(id).get();
    }

    @Override
    public List<Vente> getAllVentes() {
        return venteRepository.findAll();
    }

    @Override
    public List<Vente> findByNumTicket(Long NumTicket) {
        return venteRepository.findByNumTicket(NumTicket);
    }

    @Override
    public Vente addVenteWithProducts(Vente vente, List<Long> selectedProductIds, List<Integer> quantities) {
        // Save the Vente first to generate its ID
        Vente savedVente = venteRepository.save(vente);

        for (int i = 0; i < selectedProductIds.size(); i++) {
            Long productId = selectedProductIds.get(i);
            Produit produit = produitRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Produit not found: " + productId));

            VenteProduit venteProduit = new VenteProduit();
            venteProduit.setVente(savedVente);
            venteProduit.setProduit(produit);
            int quantity = quantities.get(i);
            venteProduit.setQuantite(quantity);

            venteproduitRepository.save(venteProduit);

            // Decrease the product quantity and update the product
            produit.setQuantite(produit.getQuantite() - quantity);


            if (produit.getQuantite() <= 0) {
                produit.setDisponibilite("Out of Stock");
                produit.setQuantite(0); // To ensure quantity doesn't go negative

            }


            produitRepository.save(produit);
        }

        return savedVente;
    }

    // @Override
    //public Vente addProduitToVente(long id, Produit p) {
    //   Vente v = venteRepository.findVenteByIdVente(id);

    // List<Produit> produits = v.getProduits();
    //produits.add(p);

    // v.setProduits(produits);

    //return venteRepository.save(v);
    // }

    @Override
    public Long count() {
        return venteRepository.count();
    }



    public Long getTotalSalesForMonth(int year, int month) {
        // Set up the calendar to the start of the month
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1, 0, 0, 0);
        Date startOfMonth = calendar.getTime();

        // Set up the calendar to the end of the month
        calendar.set(year, month, 1, 0, 0, 0);
        calendar.add(Calendar.DATE, -1);
        Date endOfMonth = calendar.getTime();

        // Fetch sales for the month
        List<Vente> monthlySales = venteRepository.findByDateVenteBetween(startOfMonth, endOfMonth);

        // Calculate total sales
        Long totalSales = 0L;
        for (Vente vente : monthlySales) {
            totalSales += vente.getTotal();
        }

        return totalSales;
    }


    public Produit findMostSoldProduct() {
        List<Object[]> salesData = venteproduitRepository.findTotalQuantitiesByProduct();

        if (!salesData.isEmpty()) {
            Long mostSoldProductId = (Long) salesData.get(0)[0];
            return produitRepository.findById(mostSoldProductId).orElse(null);
        }

        return null; // or handle the case when there are no sales
    }
    public List<Object[]> getVenteWithProduits(Long venteId) {
        return venteproduitRepository.findVenteWithProduits(venteId);
    }

}
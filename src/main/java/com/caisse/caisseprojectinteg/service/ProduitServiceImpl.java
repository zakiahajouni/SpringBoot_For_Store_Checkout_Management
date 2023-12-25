package com.caisse.caisseprojectinteg.service;

import com.caisse.caisseprojectinteg.entities.Produit;
import com.caisse.caisseprojectinteg.repos.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



    @Service
    public class ProduitServiceImpl implements ProduitService{

        @Autowired
        ProduitRepository prodRepository ;

        @Override
        public Produit saveProduit(Produit p) {



            return prodRepository.save(p) ;
        }

        @Override
        public Produit updateProduit(Produit p) {
            return prodRepository.save(p);
        }

        @Override
        public Produit getProduit(Long id) {
            return prodRepository.findById(id).get();
        }

        @Override
        public List<Produit> getAllProduits() {
            return prodRepository.findAll();
        }

        @Override
        public List<Produit> findBylibelle(String libelle) {
            return prodRepository.findBylibelle(libelle);

        }
        @Override
        public Long count() {
            return prodRepository.count();
        }
        //@Override
        //public void updateProductQuantityAndCheckAvailability(Long productId, int newQuantity) {
        //Produit produit = prodRepository.findById(productId)
        //.orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
        //produit.setQuantite(newQuantity);
        //produit.checkAndUpdateDisponibilite();
        //prodRepository.save(produit);
        //}

}

package com.caisse.caisseprojectinteg.RestControllers;

import com.caisse.caisseprojectinteg.entities.Produit;
import com.caisse.caisseprojectinteg.service.ProduitService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/prod")
@CrossOrigin
public class ProduitRestController {

    @Autowired

    ProduitService prodService ;

    @RequestMapping(path="all",method = RequestMethod.GET)
    public List<Produit> getAllProduits()
    {

        return prodService.getAllProduits();
    }

    @RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
    public Produit getMotorById(@PathVariable("id") Long id)
    {
        return prodService.getProduit(id);

    }
    @RequestMapping(path="/addprod",method = RequestMethod.POST)
    public Produit createProduit(@RequestBody Produit prod) {
        return prodService.saveProduit(prod);
    }



    @RequestMapping(value = "/updateproduit/{id}", method = RequestMethod.PUT)
    public Produit updateMotor(@PathVariable Long id, @RequestBody Produit produit) {
        produit.setIdProduit(id);
        return prodService.updateProduit(produit);
    }


    @RequestMapping(value="/findbylib/{lib}",method = RequestMethod.GET)
    public List<Produit> getProduitsByLibelle(@PathVariable("lib") String libelle) {
        return prodService.findBylibelle(libelle);
    }

    @RequestMapping(path="/count",method = RequestMethod.GET)
    public Long count() {
        return prodService.count();
    }



    //@RequestMapping("/produit/{id}/updateQuantity")
    //public ResponseEntity<Void> updateProductQuantity(@PathVariable Long id, @RequestParam int newQuantity) {
    //prodService.updateProductQuantityAndCheckAvailability(id, newQuantity);
    //return ResponseEntity.ok().build();
    //}
}
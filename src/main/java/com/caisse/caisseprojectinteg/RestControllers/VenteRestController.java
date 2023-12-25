package com.caisse.caisseprojectinteg.RestControllers;

import com.caisse.caisseprojectinteg.entities.Produit;
import com.caisse.caisseprojectinteg.entities.Vente;
import com.caisse.caisseprojectinteg.service.VenteService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/vente")
@CrossOrigin
public class VenteRestController {

    @Autowired

    VenteService venteService ;

    @RequestMapping(path="all",method = RequestMethod.GET)
    public List<Vente> getAllVentes()
    {

        return venteService.getAllVentes();
    }

    @RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
    public Vente getVenteById(@PathVariable("id") Long id)
    {
        return venteService.getVente(id);

    }
    @RequestMapping(path="/addvente",method = RequestMethod.POST)
    public Vente createVente(@RequestBody Vente vente) {
        return venteService.saveVente(vente);
    }



    @RequestMapping(path="/updatevente/{id}",method = RequestMethod.PUT)
    public Vente updateVente(@RequestBody Vente vente) {
        return venteService.updateVente(vente);
    }


    @RequestMapping(value="/findbynumticket/{numticket}",method = RequestMethod.GET)
    public List<Vente> getVentesByNumTicket(@PathVariable("numticket") Long numticket) {
        return venteService.findByNumTicket(numticket);
    }

    @RequestMapping(path="/countVente",method = RequestMethod.GET)
    public Long count() {
        return venteService.count();
    }

    //@RequestMapping(path="addProduitTovente/{id}",method=RequestMethod.POST)
    //public Vente addProduitTovente(@PathVariable long id,@RequestBody Produit p) {
    //  return venteService.addProduitToVente(id, p);
    //}


    @RequestMapping(path="/addVenteWithProducts", method = RequestMethod.POST)
    public Vente addVenteWithProducts(@RequestBody Map<String, Object> payload) {
        ObjectMapper objectMapper = new ObjectMapper();

        Vente vente = objectMapper.convertValue(payload.get("vente"), Vente.class);

        List<Long> selectedProductIds = objectMapper.convertValue(payload.get("selectedProductIds"), new TypeReference<List<Long>>() {});

        List<Integer> quantities = objectMapper.convertValue(payload.get("quantities"), new TypeReference<List<Integer>>() {});





        return venteService.addVenteWithProducts(vente, selectedProductIds, quantities);
    }







    @RequestMapping(path = "/totalSales", method = RequestMethod.GET)
    public Long getTotalSalesForMonth(@RequestParam int year, @RequestParam int month) {
        return venteService.getTotalSalesForMonth(year, month);
    }

@RequestMapping(path = "/mostSoldProduct", method = RequestMethod.GET)
public Produit getMostSoldProduct() {
        return venteService.findMostSoldProduct();
    }



    @RequestMapping(path = "/venteWithProduits/{venteId}" , method = RequestMethod.GET)
    public List<Object[]> getVenteWithProduits(@PathVariable Long venteId) {
        return venteService.getVenteWithProduits(venteId);
    }

}
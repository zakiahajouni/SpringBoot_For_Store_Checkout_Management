package com.caisse.caisseprojectinteg.RestControllers;

import com.caisse.caisseprojectinteg.entities.Categorie;
import com.caisse.caisseprojectinteg.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/api/categorie")
    @CrossOrigin
    public class CategorieRestController {

        @Autowired

        CategorieService catService;

        @RequestMapping(path = "all", method = RequestMethod.GET)
        public List<Categorie> getAllCategories() {

            return catService.getAllCategories();

        }


        @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
        public Categorie getCategoriesById(@PathVariable("id") Long id) {
            return catService.getCategorie(id);

        }


        @RequestMapping(path = "/addcat", method = RequestMethod.POST)
        public Categorie createCategorie(@RequestBody Categorie cat) {
            return catService.saveCategorie(cat);
        }


        @RequestMapping(value = "/updatecat/{id}", method = RequestMethod.PUT)
        public Categorie updateCategorie(@PathVariable Long id, @RequestBody Categorie cat) {
            // Set the id for the updated employe
            cat.setIdCategorie(id);
            return catService.updateCategorie(cat);
        }


        @RequestMapping(value = "/findbylib/{lib}", method = RequestMethod.GET)
        public List<Categorie> getCategoriesByLibelle(@PathVariable("lib") String libelle) {
            return catService.findBylibelleCat(libelle);
        }


        @RequestMapping(path = "/count", method = RequestMethod.GET)
        public Long count() {
            return catService.count();
        }


        @RequestMapping(value = "/delcat/{id}", method = RequestMethod.DELETE)
        public void deleteCategorie(@PathVariable("id") Long id) {
            catService.deleteCategorieById(id);
        }
    }



package com.caisse.caisseprojectinteg.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idCategorie;
    private String libelleCat;
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "categorie")
    private List<Produit> produits;


}
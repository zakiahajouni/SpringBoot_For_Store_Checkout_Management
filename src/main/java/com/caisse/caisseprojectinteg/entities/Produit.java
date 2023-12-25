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
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String libelle;
    private String code;
    private Double prix;
    private int quantite;
    private String disponibilite;

    @ManyToOne
    private Categorie categorie;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<VenteProduit> venteProduits;
}

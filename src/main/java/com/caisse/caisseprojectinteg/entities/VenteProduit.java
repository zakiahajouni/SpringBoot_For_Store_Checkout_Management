package com.caisse.caisseprojectinteg.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
@Entity
@Table(name = "vente_produit")
public class VenteProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "idVente")
    private Vente vente;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idProduit")
    private Produit produit;

    @Column(name = "quantity")
    private int quantite;
    public void setVente(Vente vente) {
        this.vente = vente;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

}
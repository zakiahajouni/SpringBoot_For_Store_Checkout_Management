package com.caisse.caisseprojectinteg.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploye;
    private String nomEmploye;
    @Column(unique = true) // This annotation enforces the uniqueness of the mail field
    private String mail;
    private String password;
    private Date datenaissance;
    private String adresse;
    private String role;
    private Long tel ;
    private Date dateofjoin;

    @JsonIgnore
    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vente> ventes;


}

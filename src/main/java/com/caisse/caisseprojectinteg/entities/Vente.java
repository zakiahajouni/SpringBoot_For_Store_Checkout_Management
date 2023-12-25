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
public class Vente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVente;
    @Column(unique = true)
    private Long numTicket;
    private Long total;
    private Date dateVente;
    @JsonIgnore
    @OneToMany(mappedBy = "vente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<VenteProduit> venteProduits;

    @ManyToOne
    private Employe employe;
}
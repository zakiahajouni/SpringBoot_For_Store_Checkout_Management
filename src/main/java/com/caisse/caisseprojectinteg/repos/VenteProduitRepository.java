package com.caisse.caisseprojectinteg.repos;

import com.caisse.caisseprojectinteg.entities.VenteProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface VenteProduitRepository extends JpaRepository<VenteProduit, Long> {

        Optional<VenteProduit> findByVenteIdVenteAndProduitIdProduit(Long venteId, Long produitId);
    @Query("SELECT vp.produit.idProduit, SUM(vp.quantite) as totalQuantity FROM VenteProduit vp GROUP BY vp.produit.idProduit ORDER BY totalQuantity DESC")
    List<Object[]> findTotalQuantitiesByProduct();
    @Query("SELECT v, vp.produit, vp.quantite FROM Vente v JOIN v.venteProduits vp WHERE v.idVente = :venteId")
    List<Object[]> findVenteWithProduits(Long venteId);

}
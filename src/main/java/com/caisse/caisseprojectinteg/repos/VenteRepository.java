package com.caisse.caisseprojectinteg.repos;

import com.caisse.caisseprojectinteg.entities.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


public interface VenteRepository extends JpaRepository<Vente, Long> {


    List<Vente> findByNumTicket(Long NumTicket);
    long count();

    @Query("select v from Vente v where v.idVente = ?1")
    Vente findVenteByIdVente(Long id);
    List<Vente> findByDateVenteBetween(Date startDate, Date endDate);


    @Query("SELECT v.employe.idEmploye, COUNT(v) as totalSales FROM Vente v GROUP BY v.employe.idEmploye ORDER BY totalSales DESC")
    List<Object[]> findTotalSalesByEmployee();

}

package com.caisse.caisseprojectinteg.repos;

import com.caisse.caisseprojectinteg.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface EmployeRepository extends JpaRepository<Employe, Long> {


        List<Employe> findBymail(String mail);
    }



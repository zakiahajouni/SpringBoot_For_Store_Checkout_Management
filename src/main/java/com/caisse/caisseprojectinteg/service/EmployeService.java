package com.caisse.caisseprojectinteg.service;

import com.caisse.caisseprojectinteg.entities.Employe;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Optional;

public interface EmployeService {


    Employe addEmploye(Employe employe);
    void deleteEmploye(Long id);
    Employe updateEmploye(Employe employe);
    Employe findEmployeById(Long id);
    List<Employe> getAllEmployes();
    Optional<Employe> login(String email, String password);

    Employe getEmployeById(Long id);
     Employe findTopSellingEmployee();


    void logout(HttpServletRequest request);
}

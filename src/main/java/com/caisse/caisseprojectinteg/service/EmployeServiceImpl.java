package com.caisse.caisseprojectinteg.service;

import com.caisse.caisseprojectinteg.entities.Employe;
import com.caisse.caisseprojectinteg.repos.EmployeRepository;
import com.caisse.caisseprojectinteg.repos.VenteRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeServiceImpl implements EmployeService {

    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private VenteRepository venteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public Employe addEmploye(Employe employe) {
        employe.setPassword(passwordEncoder.encode(employe.getPassword()));
        return employeRepository.save(employe);
    }

    @Override
    public void deleteEmploye(Long id) {
        employeRepository.deleteById(id);

    }

    @Override
    public Employe updateEmploye(Employe employe) {
        employe.setPassword(passwordEncoder.encode(employe.getPassword()));
        return employeRepository.save(employe);
    }

    @Override
    public Employe findEmployeById(Long id) {
        return null;
    }


    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }


    @Override
    public Optional<Employe> login(String email, String password) {
        // Fetch all employees with the given email
        List<Employe> employees = employeRepository.findBymail(email);

        // Iterate over the employees and check if the passwords match
        for (Employe employee : employees) {
            if (passwordEncoder.matches(password, employee.getPassword())) {
                // If a match is found, return the employee wrapped in an Optional
                return Optional.of(employee);
            }
        }

        // If no match is found, return an empty Optional
        return Optional.empty();
}

    @Override
    public Employe getEmployeById(Long id) {
        return employeRepository.findById(id).get();
    }


    @Override
    public void logout(HttpServletRequest request) {
        // Implement the logout logic here based on your authentication mechanism.

        // For session-based authentication, you can clear the user's session.
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }



    public Employe findTopSellingEmployee() {
        List<Object[]> salesData = venteRepository.findTotalSalesByEmployee();

        if (!salesData.isEmpty()) {
            Long topSellerId = (Long) salesData.get(0)[0];
            return employeRepository.findById(topSellerId).orElse(null);
        }

        return null; // or handle the case when there are no sales
    }









}

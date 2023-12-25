package com.caisse.caisseprojectinteg.RestControllers;

import com.caisse.caisseprojectinteg.entities.Employe;
import com.caisse.caisseprojectinteg.service.EmployeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employes")
@CrossOrigin
public class EmployeRestController {

    @Autowired
    private EmployeService employeService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Employe addEmploye(@RequestBody Employe employe) {
        return employeService.addEmploye(employe);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteEmploye(@PathVariable Long id) {
        employeService.deleteEmploye(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Employe updateEmploye(@PathVariable Long id, @RequestBody Employe updatedEmploye) {
        // Set the id for the updated employe
        updatedEmploye.setIdEmploye(id);
        return employeService.updateEmploye(updatedEmploye);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Employe> getAllEmployes() {
        return employeService.getAllEmployes();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestParam("mail") String mail, @RequestParam("password") String password) {
        Optional<Employe> employeeOptional = employeService.login(mail, password);

        if (employeeOptional.isPresent()) {
            Employe employee = employeeOptional.get();
            // Assuming you will perform additional checks here if needed
            return ResponseEntity.ok().body(employee);
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        // Implement the logout logic here based on your authentication mechanism.
        // This is a simplified example.

        // For session-based authentication, invalidate the session.
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            return ResponseEntity.ok("Logout successful");
        }


        return ResponseEntity.ok("Logout successful");
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Employe getEmploye(@PathVariable Long id) {
        return employeService.getEmployeById(id);
    }

@RequestMapping(value = "getTopSellingEmployee", method = RequestMethod.GET)
    public Employe getTopSellingEmployee() {
        return employeService.findTopSellingEmployee();
    }
}


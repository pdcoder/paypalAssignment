package com.paypal.bfs.test.employeeserv.impl;

import java.util.Optional;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employeee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

    @Autowired EmployeeService employeeService;


    @Override
    public ResponseEntity employeeGetById(String id) {
        Optional<Employeee> employee;
        try {
            employee = employeeService.getEmployeeById(id);
            if (!employee.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body("No Employees Present");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpcted error occured");
        }
        return new ResponseEntity<Employeee>(employee.get(), HttpStatus.OK);
    }

    @Override public ResponseEntity<Employeee> createEmployee(@RequestBody Employeee employee) {
        Employeee emp = employeeService.createEmployee(employee);
        if(emp==null) {
            return new ResponseEntity("Emplpoyee creation failed", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Employeee>(employeeService.createEmployee(employee), HttpStatus.OK);
    }
}

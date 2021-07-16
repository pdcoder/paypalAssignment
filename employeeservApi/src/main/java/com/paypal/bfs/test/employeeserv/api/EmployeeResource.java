package com.paypal.bfs.test.employeeserv.api;

import com.paypal.bfs.test.employeeserv.api.model.Employeee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Interface for employee resource operations.
 */
public interface EmployeeResource {


    /**
     * Retrieves the {@link Employeee} resource by id.
     *
     * @param id employee id.
     * @return {@link Employeee} resource.
     */
    @RequestMapping("/v1/bfs/employees/{id}") ResponseEntity employeeGetById(@PathVariable("id") String id);

    // ----------------------------------------------------------
    // TODO - add a new operation for creating employee resource.
    // ----------------------------------------------------------
    @RequestMapping(method = RequestMethod.POST, path = "/v1/bfs/employees/create")
    ResponseEntity<Employeee> createEmployee(Employeee employee);
}

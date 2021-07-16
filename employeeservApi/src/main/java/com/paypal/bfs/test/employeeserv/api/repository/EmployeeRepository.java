package com.paypal.bfs.test.employeeserv.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.paypal.bfs.test.employeeserv.api.model.Employeee;

public interface EmployeeRepository extends CrudRepository<Employeee, Integer> {
}
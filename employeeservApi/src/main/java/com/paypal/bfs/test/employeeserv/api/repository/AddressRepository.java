package com.paypal.bfs.test.employeeserv.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.paypal.bfs.test.employeeserv.api.model.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}

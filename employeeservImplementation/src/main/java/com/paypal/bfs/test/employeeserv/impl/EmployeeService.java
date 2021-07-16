package com.paypal.bfs.test.employeeserv.impl;

import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paypal.bfs.test.employeeserv.api.exceptions.ValidationException;
import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employeee;
import com.paypal.bfs.test.employeeserv.api.repository.AddressRepository;
import com.paypal.bfs.test.employeeserv.api.repository.EmployeeRepository;

@Component
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired AddressRepository addressRepository;

	public Optional<Employeee> getEmployeeById(String id) {
		return employeeRepository.findById(Integer.valueOf(id));
	}

	public Employeee createEmployee(Employeee employeee) {
		try {
			Address address = new Address(employeee.getAddress());
			if(!isAddressValid(address)) {
				throw new ValidationException("Address not valid");
			}
			employeee.setAddress(address);
			employeeRepository.save(employeee);
			return employeee;
		} catch (ValidationException validationException) {
			System.out.println("Validation error occured");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some error occured");
			return null;
		}
	}

	private boolean isAddressValid(Address address) {
		if(StringUtils.isEmpty(address.getCity()) || StringUtils.isEmpty(address.getCountry()) ||
				StringUtils.isEmpty(address.getLine1()) || StringUtils.isEmpty(address.getState()) ||
				StringUtils.isEmpty(address.getZipcode())) {
			return false;
		}
		return true;
	}

}
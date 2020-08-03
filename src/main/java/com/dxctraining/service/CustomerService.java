package com.dxctraining.service;
import java.util.List;

import com.dxctraining.entities.Customer;

public interface CustomerService {
	Customer findById(int id);

	List<Customer> findAll();

	Customer updateName(int id, String newName);

	void add(Customer customer);

	Customer update(Customer customer);

	void delete(int id);
}

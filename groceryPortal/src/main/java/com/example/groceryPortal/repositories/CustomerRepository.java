package com.example.groceryPortal.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.groceryPortal.entities.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	public Customer findById(int id);
}

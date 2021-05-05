package com.example.groceryPortal.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.groceryPortal.entities.Customers;


public interface CustomersRepository extends CrudRepository<Customers, Integer> {
	public Customers findById(int id);
}

package com.example.groceryPortal.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.groceryPortal.entities.Sales;


public interface SalesRepository extends CrudRepository<Sales, Integer> {
	public Sales findById(int id);
}

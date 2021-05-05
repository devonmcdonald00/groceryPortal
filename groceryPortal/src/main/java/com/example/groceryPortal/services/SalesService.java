package com.example.groceryPortal.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.groceryPortal.entities.Sales;
import com.example.groceryPortal.repositories.SalesRepository;


@Service
public class SalesService {
    @Autowired
    private SalesRepository salesRepository;

	public Iterable<Sales> GetAllSales()
	{
	   return salesRepository.findAll();
	}
	
    public Sales GetSaleById(int id) {
    	Sales sale = salesRepository.findById(id);
    	return sale;
    }
    
    public Sales EditSale(Sales sale) {
    	
    	//TODO: Not doing any error checking
    	
    	return salesRepository.save(sale);
    }
}
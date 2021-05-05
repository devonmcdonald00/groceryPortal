package com.example.groceryPortal.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.groceryPortal.entities.Customers;
import com.example.groceryPortal.repositories.CustomersRepository;


@Service
public class CustomersService {
    @Autowired
    private CustomersRepository customersRepository;

	public Iterable<Customers> GetAllCustomers()
	{
	   return customersRepository.findAll();
	}
	
    public Customers GetCustomerById(int id) {
    	System.out.println(id);
    	Customers customer = customersRepository.findById(id);
    	return customer;
    }
    public Customers EditCustomer(Customers customer) {
    	
    	//TODO: Not doing any error checking
    	
    	return customersRepository.save(customer);
    }
}

package com.example.groceryPortal.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.groceryPortal.entities.Customer;
import com.example.groceryPortal.repositories.CustomerRepository;


@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

	public Iterable<Customer> GetAllCustomers()
	{
	   return customerRepository.findAll();
	}
	
    public Customer GetCustomerById(int id) {
    	Customer customer = customerRepository.findById(id);
    	return customer;
    }
}

package com.example.groceryPortal.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.groceryPortal.entities.User_Privileges;
import com.example.groceryPortal.services.UserPrivilegeService;
import com.example.groceryPortal.services.SalesService;
import com.example.groceryPortal.entities.Sales;


@Controller
public class LoginController {
	
    @Autowired
    private UserPrivilegeService UserPrivilegeService;
	@Autowired
    private SalesService SalesService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String welcomePage(ModelMap model) {
    	return showLogin(model);
    }
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLogin(ModelMap model)
    {
    	model.addAttribute("message", "Welcome!");
    	return("login");
    }
    
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String handleLogin(
    		@RequestParam(value = "username", required = true) String username,
    		@RequestParam(value = "password", required = true) String password,

    		ModelMap model) { 	
    	User_Privileges user;
    	try {
    	
    		
    		user = UserPrivilegeService.GetUserByName(username);
    	}
    	catch(Exception ex) {
    		model.addAttribute("message", "ERROR: Unknown user!");
    		return("login");
    	}
    	if (UserPrivilegeService.ConfirmUserPassword(user, password)) {
    		//TODO: Check user and password
    		//model.addAttribute("user", user);
    		if(UserPrivilegeService.isAdmin(user)) {
    			model.addAttribute("message", "Success you are admin!");
    			return("edit");
    		}
    		else {
    			model.addAttribute("message", "Hello");
    			return showViewCustomersAndOrders(model);
    		}
    	}
    	else {
    		model.addAttribute("message", "Invalid Password, Try again!");
    		return("login");
    	}
    }
    
    @RequestMapping(value="/view", method = RequestMethod.GET)
    public String showViewCustomersAndOrders(ModelMap model)
    {
    	model.addAttribute("message", "You are not an admin... select an option to view the sales or customers");
    	return("view");
    }
    
    @RequestMapping(value="/view", method=RequestMethod.POST)
    public String handleView(@RequestParam(value = "button", required=false) String button, ModelMap model) {
    	if(button.equals("view customers")) {
    		model.addAttribute("message", "VIEW CUSTOMERS");
    		return ("view-customers");
    	}
    	else if (button.equals("view sales")){
    		model.addAttribute("message", "VIEW SALES");
    		return ("view-sales");
    	}
    	else if(button.equals("login")) {
    		return ("login");
    	}
    	else {
    		model.addAttribute("message", "Please select which table you would like to view");
    		return ("view");
    	}
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public String handleEdit(@RequestParam(value = "button", required=false) String button, ModelMap model) {
    	if(button.equals("edit customers")) {
    		model.addAttribute("message", "EDIT CUSTOMERS");
    		return ("edit-customers");
    	}
    	else if (button.equals("edit sales")){
    		model.addAttribute("message", "EDIT SALES");
    		return ("edit-sales");
    	}
    	else if(button.equals("login")) {
    		return ("login");
    	}
    	else {
    		model.addAttribute("message", "Please select which table you would like to edit");
    		return ("edit");
    	}
    }
    
    @RequestMapping(value="/edit-sales", method=RequestMethod.POST)
    public String handleEditSales(@RequestParam(value = "button", required=false) String button, @RequestParam(value = "saleId", required=false) int saleId, @RequestParam(value = "product", required=false) String product, @RequestParam(value = "name", required=false) String name, @RequestParam(value = "total", required=false) Float total, ModelMap model) {
    	if(button.equals("submit query")) {
    		Sales sale = SalesService.GetSaleById(saleId);
    		model.addAttribute("sale", sale);
    		return ("edit-sales");
    	}
    	else if (button.equals("submit edit")){
    		Sales sale = SalesService.GetSaleById(saleId);
    		model.addAttribute("sale", sale);
    		sale.setName(name);
    		sale.setProduct(product);
    		sale.setTotal(total);
    		SalesService.EditSale(sale);
    		return ("edit-sales");
    	}
    	else if(button.equals("login")) {
    		return ("login");
    	}
    	else {
    		model.addAttribute("message", "Please select which table you would like to edit");
    		return ("edit");
    	}
    }
}

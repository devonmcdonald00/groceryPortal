package com.example.groceryPortal.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sales {
	@Id
	private int id;
	private String product;
	private String customer_name;
	private Float total;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getName() {
		return customer_name;
	}
	public void setName(String name) {
		this.customer_name = name;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}

	
	
}

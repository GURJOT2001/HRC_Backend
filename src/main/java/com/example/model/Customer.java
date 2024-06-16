package com.example.model;

public class Customer {
	
	private int cust_number;
	private String name_customer;
	
	public int getCust_number() {
		return cust_number;
	}
	public void setCust_number(int cust_number) {
		this.cust_number = cust_number;
	}
	public String getName_customer() {
		return name_customer;
	}
	public void setName_customer(String name_customer) {
		this.name_customer = name_customer;
	}
	
	@Override
	public String toString() {
		return "Customer [cust_number=" + cust_number + ", name_customer=" + name_customer + "]";
	}
}

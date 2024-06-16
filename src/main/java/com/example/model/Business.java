package com.example.model;

public class Business {
	
	private String business_code;
	private String business_name;
	
	public String getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	
	@Override
	public String toString() {
		return "Business [business_code=" + business_code + ", business_name=" + business_name + "]";
	}
}

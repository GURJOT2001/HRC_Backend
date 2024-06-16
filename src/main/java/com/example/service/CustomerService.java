package com.example.service;

import com.example.model.WinterInternship;
import java.util.List;
import java.util.Map;

public interface CustomerService {
	
	WinterInternship saveCustomer(WinterInternship customer) throws Exception;
	List<WinterInternship> getAllCustomers() throws Exception;
	WinterInternship getCustomerById(int id) throws Exception;
	WinterInternship updateCustomer(WinterInternship customer, int id) throws Exception;
	void deleteCustomer(int id) throws Exception;
	WinterInternship getCustomerByAdvanceSearch(WinterInternship customer) throws Exception;
	Map<String, Integer> analyticsView() throws Exception;
}

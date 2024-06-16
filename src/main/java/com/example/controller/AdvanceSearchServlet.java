package com.example.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.example.model.WinterInternship;
import com.example.service.CustomerService;
import com.example.service.CustomerServiceImpl;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/customer/advanceSearch"})
public class AdvanceSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1;
	
	private CustomerService customerService = new CustomerServiceImpl();
	private Gson gson = new Gson();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BufferedReader reader = req.getReader();
		StringBuffer buffer = new StringBuffer();
		String line;
		
		while((line = reader.readLine()) != null)
			buffer.append(line);
		
		WinterInternship userDetails = gson.fromJson(buffer.toString(), WinterInternship.class);
		try {
			WinterInternship customer = customerService.getCustomerByAdvanceSearch(userDetails);
			resp.setContentType("application/json");
			PrintWriter out = resp.getWriter();
			String respData = gson.toJson(customer);
			out.println(respData);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

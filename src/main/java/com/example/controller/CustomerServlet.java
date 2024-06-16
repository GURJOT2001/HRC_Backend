package com.example.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.example.model.WinterInternship;
import com.example.service.CustomerService;
import com.example.service.CustomerServiceImpl;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/customer/*"})
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerService customerService = new CustomerServiceImpl();
	private Gson gson = new Gson();
	
	public CustomerServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BufferedReader reader = req.getReader();
		StringBuffer buffer = new StringBuffer();
		String line;
		
		while((line = reader.readLine()) != null)
			buffer.append(line);
		
		WinterInternship userDetails = gson.fromJson(buffer.toString(), WinterInternship.class);
		try {
			customerService.saveCustomer(userDetails);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		String respData = "";
		if(req.getParameter("id") != null) {
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				WinterInternship user = customerService.getCustomerById(id);
				respData = gson.toJson(user);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				List<WinterInternship> allCustomers = customerService.getAllCustomers();
				respData = gson.toJson(allCustomers);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		out.println(respData);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		BufferedReader reader = req.getReader();
		StringBuffer buffer = new StringBuffer();
		String line;
		
		while((line = reader.readLine()) != null)
			buffer.append(line);
		
		resp.setContentType("application/json");
		WinterInternship userDetails = gson.fromJson(buffer.toString(), WinterInternship.class);
		try {
			customerService.updateCustomer(userDetails, id);
			PrintWriter out = resp.getWriter();
			out.println(resp.getStatus());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] idList = req.getParameterValues("id");
		
		try {
			for(String id: idList)
				customerService.deleteCustomer(Integer.parseInt(id));
			PrintWriter out = resp.getWriter();
			out.println(resp.getStatus());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

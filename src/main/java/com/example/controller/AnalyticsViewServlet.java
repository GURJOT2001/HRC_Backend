package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Map;

import com.example.service.CustomerService;
import com.example.service.CustomerServiceImpl;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/customer/analyticsView"})
public class AnalyticsViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1;
	
	private Gson gson = new Gson();
	private CustomerService customerService = new CustomerServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		try {
			Map<String, Integer> numberOfValues = customerService.analyticsView();
			String respData = gson.toJson(numberOfValues);
			out.println(respData);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

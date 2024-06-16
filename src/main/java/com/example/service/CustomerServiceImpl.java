package com.example.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.connection.InitConnection;
import com.example.model.WinterInternship;
import java.util.*;

public class CustomerServiceImpl implements CustomerService {
	
	public WinterInternship saveCustomer(WinterInternship customer) throws Exception {
		Connection con = InitConnection.initializeConnection();
		String query = "INSERT INTO winter_internship (business_code, cust_number, clear_date, buisness_year, doc_id, posting_date, "
				+ "document_create_date, due_in_date, invoice_currency, document_type, posting_id, total_open_amount, baseline_create_date, "
				+ "cust_payment_terms, invoice_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement st = con.prepareStatement(query);
		
		st.setString(1, customer.getBusiness_code());
		st.setInt(2, customer.getCust_number());
		st.setDate(3, Date.valueOf(customer.getClear_date()));
		st.setString(4, customer.getBusiness_year());
		st.setString(5, customer.getDoc_id());
		st.setDate(6, Date.valueOf(customer.getPosting_date()));
		st.setDate(7, Date.valueOf(customer.getDocument_create_date()));
		st.setDate(8, Date.valueOf(customer.getDue_in_date()));
		st.setString(9, customer.getInvoice_currency());
		st.setString(10, customer.getDocument_type());
		st.setInt(11, customer.getPosting_id());
		st.setDouble(12, customer.getTotal_open_amount());
		st.setDate(13, Date.valueOf(customer.getBaseline_create_date()));
		st.setString(14, customer.getCust_payment_terms());
		st.setInt(15, customer.getInvoice_id());
		st.addBatch();
		
		st.execute();
		st.close();
		con.close();
		return customer;
	}
	
	public List<WinterInternship> getAllCustomers() throws Exception {
		Connection con = InitConnection.initializeConnection();
		
		String query = "SELECT sl_no, business_code, cust_number, clear_date, buisness_year, doc_id, posting_date, document_create_date, "
				+ "due_in_date, invoice_currency, document_type, posting_id, total_open_amount, baseline_create_date, cust_payment_terms, "
				+ "invoice_id, aging_bucket FROM winter_internship;";
		PreparedStatement st = con.prepareStatement(query);
		ResultSet rs = st.executeQuery();
		List<WinterInternship> allCustomers = new ArrayList<>();
		while(rs.next()) {
			WinterInternship customer = new WinterInternship();
			
			customer.setSl_no(rs.getInt(1));
			customer.setBusiness_code(rs.getString(2));
			customer.setCust_number(rs.getInt(3));
			customer.setClear_date(rs.getString(4));
			customer.setBusiness_year(rs.getString(5).substring(0, 4));
			customer.setDoc_id(rs.getString(6));
			customer.setPosting_date(rs.getString(7));
			customer.setDocument_create_date(rs.getString(8));
			customer.setDue_in_date(rs.getString(9));
			customer.setInvoice_currency(rs.getString(10));
			customer.setDocument_type(rs.getString(11));
			customer.setPosting_id(rs.getInt(12));
			customer.setTotal_open_amount(rs.getDouble(13));
			customer.setBaseline_create_date(rs.getString(14));
			customer.setCust_payment_terms(rs.getString(15));
			customer.setInvoice_id(rs.getInt(16));
			if(rs.getString(17) == null)
				customer.setAging_bucket("N/A");
			else
				customer.setAging_bucket(rs.getString(17));
			
			allCustomers.add(customer);
		}
		return allCustomers;
	}
	
	public WinterInternship getCustomerById(int id) throws Exception {
		
		Connection con = InitConnection.initializeConnection();
		
		String query = "SELECT business_code, cust_number, clear_date, buisness_year, doc_id, posting_date, document_create_date, "
				+ "due_in_date, invoice_currency, document_type, posting_id, total_open_amount, baseline_create_date, cust_payment_terms, "
				+ "invoice_id, aging_bucket FROM winter_internship WHERE sl_no = ?;";
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, id);
		st.addBatch();
		ResultSet rs = st.executeQuery();
		rs.next();
		WinterInternship customer = new WinterInternship();
		
		customer.setSl_no(id);
		customer.setBusiness_code(rs.getString(1));
		customer.setCust_number(rs.getInt(2));
		customer.setClear_date(rs.getString(3));
		customer.setBusiness_year(rs.getString(4).substring(0, 4));
		customer.setDoc_id(rs.getString(5));
		customer.setPosting_date(rs.getString(6));
		customer.setDocument_create_date(rs.getString(7));
		customer.setDue_in_date(rs.getString(8));
		customer.setInvoice_currency(rs.getString(9));
		customer.setDocument_type(rs.getString(10));
		customer.setPosting_id(rs.getInt(11));
		customer.setTotal_open_amount(rs.getDouble(12));
		customer.setBaseline_create_date(rs.getString(13));
		customer.setCust_payment_terms(rs.getString(14));
		customer.setInvoice_id(rs.getInt(15));
		if(rs.getString(16) == null)
			customer.setAging_bucket("N/A");
		else
			customer.setAging_bucket(rs.getString(16));
		
		return customer;
	}
	
	public WinterInternship updateCustomer(WinterInternship customer, int id) throws Exception {
		Connection con = InitConnection.initializeConnection();
		String query = "UPDATE winter_internship SET invoice_currency = ?, cust_payment_terms = ? WHERE sl_no = ?;";
		PreparedStatement st = con.prepareStatement(query);
		
		customer.setSl_no(id);
		
		st.setString(1, customer.getInvoice_currency());
		st.setString(2, customer.getCust_payment_terms());
		st.setInt(3, customer.getSl_no());
		st.addBatch();
		
		st.executeUpdate();
		st.close();
		con.close();
		
		return customer;
	}
	
	public void deleteCustomer(int id) throws Exception {
		
		Connection con = InitConnection.initializeConnection();
		
		String query = "DELETE FROM winter_internship where sl_no = ?;";
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, id);
		st.addBatch();
		
		st.executeUpdate();
		st.close();
		con.close();
	}
	
	public WinterInternship getCustomerByAdvanceSearch(WinterInternship details) throws Exception {
		Connection con = InitConnection.initializeConnection();
		
		String query = "SELECT sl_no, business_code, cust_number, clear_date, buisness_year, doc_id, posting_date, document_create_date, "
				+ "due_in_date, invoice_currency, document_type, posting_id, total_open_amount, baseline_create_date, cust_payment_terms, "
				+ "invoice_id, aging_bucket FROM winter_internship "
				+ "WHERE doc_id = ? AND cust_number = ? AND invoice_id = ? AND buisness_year = ?;";
		
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, details.getDoc_id());
		st.setInt(2, details.getCust_number());
		st.setInt(3, details.getInvoice_id());
		st.setString(4, details.getBusiness_year());
		st.addBatch();
		
		ResultSet rs = st.executeQuery();
		rs.next();
		
		WinterInternship customer = new WinterInternship();
		
		customer.setSl_no(rs.getInt(1));
		customer.setBusiness_code(rs.getString(2));
		customer.setCust_number(rs.getInt(3));
		customer.setClear_date(rs.getString(4));
		customer.setBusiness_year(rs.getString(5).substring(0, 4));
		customer.setDoc_id(rs.getString(6));
		customer.setPosting_date(rs.getString(7));
		customer.setDocument_create_date(rs.getString(8));
		customer.setDue_in_date(rs.getString(9));
		customer.setInvoice_currency(rs.getString(10));
		customer.setDocument_type(rs.getString(11));
		customer.setPosting_id(rs.getInt(12));
		customer.setTotal_open_amount(rs.getDouble(13));
		customer.setBaseline_create_date(rs.getString(14));
		customer.setCust_payment_terms(rs.getString(15));
		customer.setInvoice_id(rs.getInt(16));
		if(rs.getString(17) == null)
			customer.setAging_bucket("N/A");
		else
			customer.setAging_bucket(rs.getString(17));
		
		return customer;
	}
public Map<String, Integer> analyticsView() throws Exception {
		
		Connection con = InitConnection.initializeConnection();
		
		String usdQuery = "SELECT COUNT(*) FROM winter_internship WHERE invoice_currency = 'USD'";
		String cadQuery = "SELECT COUNT(*) FROM winter_internship WHERE invoice_currency = 'CAD'";
		
		PreparedStatement st1 = con.prepareStatement(usdQuery);
		PreparedStatement st2 = con.prepareStatement(cadQuery);
		st1.addBatch();
		st2.addBatch();
		
		ResultSet rs1 = st1.executeQuery();
		ResultSet rs2 = st2.executeQuery();
		
		rs1.next();
		rs2.next();
		
		Map<String, Integer> values = new HashMap<>();
		values.put("USD", rs1.getInt(1));
		values.put("CAD", rs2.getInt(1));
		
		st1.close();
		st1.close();
		
		con.close();
		
		return values;
	}
}

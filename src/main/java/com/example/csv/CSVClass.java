package com.example.csv;

import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.example.connection.InitConnection;
import com.opencsv.*;

public class CSVClass {
	
	private static Customers getOneCustomer(String[] row) {
		Customers customer = new Customers();
		customer.setKey_0(Integer.parseInt(row[0]));
		customer.setBusiness_code(row[1]);
		customer.setCust_number(row[2]);
		customer.setName_customer(row[3]);
		customer.setClear_date(row[4]);
		customer.setBusiness_year(row[5]);
		customer.setDoc_id(Double.parseDouble(row[6]));
		customer.setPosting_date(row[7]);
		customer.setDue_in_date(row[8]);
		customer.setBaseline_create(row[9]);
		customer.setCust_payment_terms(row[10]);
		customer.setConverted_usd(Double.parseDouble(row[11]));
		customer.setAvg_delay(Integer.parseInt(row[12]));
		customer.setAging_bucket(row[13]);
		
		return customer;
	}
	
	private static List<Customers> getCustomerDetails(FileReader fileReader) throws Exception {
		CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
		List<String[]> data = csvReader.readAll();
		List<Customers> customers = new ArrayList<Customers>();
		for(String[] row: data) {
			Customers customer = getOneCustomer(row);
			customers.add(customer);
		}
		return customers;
	}
	public void service() {
		try {
			FileReader fileReader = new FileReader("F:\\Final.csv");
	      	List<Customers> customerList = getCustomerDetails(fileReader);
	      	
	      	String query = "INSERT INTO users VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
	      	
	      	Connection con = InitConnection.initializeConnection();
	      	PreparedStatement st = con.prepareStatement(query);
	      	
	      	for(Customers cust: customerList) {
	      		st.setInt(1, cust.getKey_0());
	      		st.setString(2, cust.getBusiness_code());
	      		st.setString(3, cust.getCust_number());
	      		st.setString(4, cust.getName_customer());
	      		st.setTimestamp(5, Timestamp.valueOf(cust.getClear_date()));
	      		st.setString(6, cust.getBusiness_year());
	      		st.setDouble(7, cust.getDoc_id());
	      		st.setDate(8, Date.valueOf(cust.getPosting_date()));
	      		st.setDate(9, Date.valueOf(cust.getDue_in_date()));
	      		st.setDate(10, Date.valueOf(cust.getBaseline_create()));
	      		st.setString(11, cust.getCust_payment_terms());
	      		st.setDouble(12, cust.getConverted_usd());
	      		st.setInt(13, cust.getAvg_delay());
	      		st.setString(14, cust.getAging_bucket());
	      		st.addBatch();
	      	};
	      	st.executeBatch();
	      	st.close();
	      	con.close();
	      	System.out.println("Successfully executed");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}


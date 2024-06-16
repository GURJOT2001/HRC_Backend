package com.example.csv;

public class Customers {
	
	private int key_0;
	private String business_code;
	private String cust_number;
	private String name_customer;
	private String clear_date;
	private String business_year;
	private double doc_id;
	private String posting_date;
	private String due_in_date;
	private String baseline_create;
	private String cust_payment_terms;
	private double converted_usd;
	private int avg_delay;
	private String aging_bucket;

	public int getKey_0() {
		return key_0;
	}
	public void setKey_0(int key_0) {
		this.key_0 = key_0;
	}
	public String getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}
	public String getCust_number() {
		return cust_number;
	}
	public void setCust_number(String cust_number) {
		this.cust_number = cust_number;
	}
	public String getName_customer() {
		return name_customer;
	}
	public void setName_customer(String name_customer) {
		this.name_customer = name_customer;
	}
	public String getClear_date() {
		return clear_date;
	}
	public void setClear_date(String clear_date) {
		this.clear_date = clear_date;
	}
	public String getBusiness_year() {
		return business_year;
	}
	public void setBusiness_year(String business_year) {
		this.business_year = business_year;
	}
	public double getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(double doc_id) {
		this.doc_id = doc_id;
	}
	public String getPosting_date() {
		return posting_date;
	}
	public void setPosting_date(String posting_date) {
		this.posting_date = posting_date;
	}
	public String getDue_in_date() {
		return due_in_date;
	}
	public void setDue_in_date(String due_in_date) {
		this.due_in_date = due_in_date;
	}
	public String getBaseline_create() {
		return baseline_create;
	}
	public void setBaseline_create(String baseline_create) {
		this.baseline_create = baseline_create;
	}
	public String getCust_payment_terms() {
		return cust_payment_terms;
	}
	public void setCust_payment_terms(String cust_payment_terms) {
		this.cust_payment_terms = cust_payment_terms;
	}
	public double getConverted_usd() {
		return converted_usd;
	}
	public void setConverted_usd(double converted_usd) {
		this.converted_usd = converted_usd;
	}
	public int getAvg_delay() {
		return avg_delay;
	}
	public void setAvg_delay(int avg_delay) {
		this.avg_delay = avg_delay;
	}
	public String getAging_bucket() {
		return aging_bucket;
	}
	public void setAging_bucket(String aging_bucket) {
		this.aging_bucket = aging_bucket;
	}
	@Override
	public String toString() {
		return "Customers [key_0=" + key_0 + ", business_code=" + business_code + ", cust_number=" + cust_number
				+ ", name_customer=" + name_customer + ", clear_date=" + clear_date + ", business_year=" + business_year
				+ ", doc_id=" + doc_id + ", posting_date=" + posting_date + ", due_in_date=" + due_in_date
				+ ", baseline_create=" + baseline_create + ", cust_payment_terms=" + cust_payment_terms
				+ ", converted_usd=" + converted_usd + ", avg_delay=" + avg_delay + ", aging_bucket=" + aging_bucket
				+ "]";
	}
}

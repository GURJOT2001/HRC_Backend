package com.example.model;

public class User {
	
	private int ID;
	private String first_name;
	private String last_name;
	private int age;
	private String dob;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [ID=" + ID + ", first_name=" + first_name + ", last_name=" + last_name + ", age=" + age + ", dob=" + dob + "]";
	}	
}

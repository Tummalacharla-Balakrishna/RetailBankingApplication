package com.casestudy.retailbank.bean;

public class CustomerPOJO {
	
	private int cust_id;
	private int cust_ss_id;
	private String cust_name;
	private int age;
	private String addr;
	private String state;
	private String city;
	
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public int getCust_ss_id() {
		return cust_ss_id;
	}
	public void setCust_ss_id(int cust_ss_id) {
		this.cust_ss_id = cust_ss_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}

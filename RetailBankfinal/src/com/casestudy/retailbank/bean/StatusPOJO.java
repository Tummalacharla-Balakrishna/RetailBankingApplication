package com.casestudy.retailbank.bean;

public class StatusPOJO {
	
	private int acc_id;
	private int cust_id;
	private int cust_ss_id;
	private String status;
	private String acc_type;
	private String message;
	private String last_updated;
	
	public int getAcc_id() {
		return acc_id;
	}
	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}
	
	
}

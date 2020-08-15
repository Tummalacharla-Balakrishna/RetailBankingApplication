package com.casestudy.retailbank.service;

import java.sql.SQLException;
import java.util.List;

import com.casestudy.retailbank.bean.CustomerPOJO;
import com.casestudy.retailbank.bean.StatusPOJO;
import com.casestudy.retailbank.dao.CustomerDao;

public class CustomerService {

	CustomerDao custDao = new CustomerDao();

	
	//Create Customer Method
	public Integer CreateCustomer(CustomerPOJO customer) throws SQLException, ClassNotFoundException {

		return custDao.CreateCustomer(customer);

	}
	
	//Method to Get list of all customers
	public List<CustomerPOJO> GetCustomerList() throws SQLException, ClassNotFoundException {
		//System.out.println("inside update service");

		return custDao.GetCustomerList();

	}

	//Delete customer method
	public Integer DeleteCustomer(int cust_id, int cust_ssn_id, String cust_name, int age, String addr)
			throws SQLException, ClassNotFoundException {

		return custDao.DeleteCustomer(cust_id, cust_ssn_id, cust_name, age, addr);

	}

	
	//Search customer by Customer ID method
	public CustomerPOJO searchCustomerByCID(int cust_id) {
		CustomerPOJO customer = custDao.searchCustomerByCID(cust_id);
		return customer;
	}

	public Integer UpdateCustomer(int cust_id, String cust_name, String addr, int age)
			throws SQLException, ClassNotFoundException {

		return custDao.UpdateCustomer(cust_id, cust_name, addr, age);

	}

	public CustomerPOJO searchCustomerBySSNID(int ssnid) {

		CustomerPOJO customer = custDao.searchCustomerBySSNID(ssnid);
		return customer;
	}


	public List<StatusPOJO> ViewAllCustomerStatus() {

		List<StatusPOJO> cust_status_arr = custDao.ViewAllCustomerStatus();
		return cust_status_arr;
	}

}

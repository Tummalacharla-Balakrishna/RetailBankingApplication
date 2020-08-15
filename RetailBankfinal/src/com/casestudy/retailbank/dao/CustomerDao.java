package com.casestudy.retailbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.casestudy.retailbank.bean.CustomerPOJO;
import com.casestudy.retailbank.bean.StatusPOJO;
import com.casestudy.retailbank.util.DBConnectionUtil;

public class CustomerDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet result = null;
	Statement stmt = null;
	String query = null;

	public Integer CreateCustomer(CustomerPOJO customer) throws SQLException, ClassNotFoundException {
		con = DBConnectionUtil.getConnection();

		Integer CustomerID = null;

		ps = con.prepareStatement(
				"insert into tb_customer(cust_ssn_id, cust_name, age, addr, state, city) VALUES(?, ?, ?, ?, ?, ? )");

		ps.setInt(1, customer.getCust_ss_id());
		ps.setString(2, customer.getCust_name());
		ps.setInt(3, customer.getAge());
		ps.setString(4, customer.getAddr());
		ps.setString(5, customer.getState());
		ps.setString(6, customer.getCity());

		int rowstatus = ps.executeUpdate();

		query = "SELECT MAX(cust_id) FROM tb_customer";
		stmt = con.createStatement();
		result = stmt.executeQuery(query);
		while (result.next()) {
			CustomerID = (Integer) result.getInt(1);
		}

		return CustomerID;

	}

	public List<CustomerPOJO> GetCustomerList() throws SQLException, ClassNotFoundException {
		con = DBConnectionUtil.getConnection();
		List<CustomerPOJO> cust_id_list = new ArrayList<>();
		String query = null;
		query = "Select * from tb_customer order by cust_id";
		ps = con.prepareStatement(query);
		try {

			stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(query);
			// System.out.println("query execute");

			while (result.next()) {
				CustomerPOJO customer = new CustomerPOJO();
				customer.setCust_id(result.getInt("cust_id"));
				customer.setCust_ss_id(result.getInt("cust_ssn_id"));
				customer.setCust_name(result.getString("cust_name"));
				customer.setAge(result.getInt("age"));
				customer.setAddr(result.getString("addr"));
				customer.setState(result.getString("state"));
				customer.setCity(result.getString("city"));

				cust_id_list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cust_id_list;

	}

	public CustomerPOJO searchCustomerBySSNID(int ssnid) {

		CustomerPOJO customer = null;
		con = DBConnectionUtil.getConnection();
		query = "select * from tb_customer where cust_ssn_id=?";
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, ssnid);
			result = ps.executeQuery();

			if (result.next()) {
				customer = new CustomerPOJO();
				customer.setCust_id(result.getInt(1));
				customer.setCust_ss_id(result.getInt(2));
				customer.setCust_name(result.getString(3));
				customer.setAge(result.getInt(4));
				customer.setAddr(result.getString(5));
				customer.setState(result.getString(6));
				customer.setCity(result.getString(7));
			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return customer;
	}

	public CustomerPOJO searchCustomerByCID(int cust_id) {

		CustomerPOJO customer = null;
		con = DBConnectionUtil.getConnection();
		query = "select * from tb_customer where cust_id=?";
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, cust_id);
			result = ps.executeQuery();
			System.out.println(cust_id);
			if (result.next()) {
				customer = new CustomerPOJO();
				customer.setCust_id(result.getInt(1));
				customer.setCust_ss_id(result.getInt(2));
				customer.setCust_name(result.getString(3));
				customer.setAge(result.getInt(4));
				customer.setAddr(result.getString(5));
				customer.setState(result.getString(6));
				customer.setCity(result.getString(7));
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer;
	}

	public Integer UpdateCustomer(int cust_id, String cust_name, String addr, int age)
			throws SQLException, ClassNotFoundException {
		CustomerPOJO customer = new CustomerPOJO();
		Integer CustomerID = null;
		con = DBConnectionUtil.getConnection();
		String query = "UPDATE tb_customer SET cust_name = ?, addr = ?, age = ? where cust_id = ?";
		PreparedStatement pstm = con.prepareStatement(query);
		System.out.println(customer.getCust_name());
		pstm.setString(1, cust_name);
		pstm.setString(2, addr);
		pstm.setInt(3, age);
		pstm.setInt(4, cust_id);
		int rowstatus = pstm.executeUpdate();
		if (rowstatus > 0) {
			CustomerID = cust_id;
		} else {
			CustomerID = 0;
		}

		return CustomerID;

	}

	public Integer DeleteCustomer(int cust_id, int cust_ssn_id, String cust_name, int age, String addr)
			throws SQLException, ClassNotFoundException {
		Integer CustomerID = null;
		con = DBConnectionUtil.getConnection();
		String query = "delete from tb_customer where cust_id=? AND cust_ssn_id = ? AND cust_name = ? AND age = ? AND addr = ?;";
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setInt(1, cust_id);
		pstm.setInt(2, cust_ssn_id);
		pstm.setString(3, cust_name);
		pstm.setInt(4, age);
		pstm.setString(5, addr);
		int rowstatus = pstm.executeUpdate();

		if (rowstatus > 0) {
			CustomerID = cust_id;
		} else {
			CustomerID = 0;
		}

		return CustomerID;

	}

	public List<StatusPOJO> ViewAllCustomerStatus() {

		List<StatusPOJO> cust_status_arr = new ArrayList<>();
		StatusPOJO cust_status = null;
		con = DBConnectionUtil.getConnection();
		query = "SELECT cust_id, cust_ssn_id, status, message, last_updated FROM tb_customer_status";
		try {
			ps = con.prepareStatement(query);
			result = ps.executeQuery();
			while (result.next()) {
				cust_status = new StatusPOJO();
				cust_status.setCust_id(result.getInt(1));
				cust_status.setCust_ss_id(result.getInt(2));
				cust_status.setStatus(result.getString(3));
				cust_status.setMessage(result.getString(4));
				cust_status.setLast_updated(result.getString(5));
				cust_status_arr.add(cust_status);
			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return cust_status_arr;
	}
}

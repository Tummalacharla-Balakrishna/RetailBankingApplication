package com.casestudy.retailbank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.casestudy.retailbank.bean.CustomerPOJO;
import com.casestudy.retailbank.service.CustomerService;

/**
 * Servlet implementation class CustomerSearchByCID
 */
@WebServlet("/CustomerSearchByCID")
public class CustomerSearchByCID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerSearchByCID() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int cust_id = Integer.parseInt(request.getParameter("cust_id"));
		System.out.println(cust_id);
		CustomerService cust_service = new CustomerService();
		CustomerPOJO customer = cust_service.searchCustomerByCID(cust_id);
		HashMap<String, Object> map = new HashMap<>();
		System.out.println("hello"+customer);
		if(customer != null) {
			map.put("cust_ssn_id", customer.getCust_ss_id());
			map.put("name", customer.getCust_name());
			map.put("age", customer.getAge());
			map.put("addr", customer.getAddr());
			write(response, map);
		}
		else {

			request.setAttribute("message", "<p class='alert alert-danger text-center'> CustomerID not exists.</p>");
			RequestDispatcher rd = request.getRequestDispatcher("DeleteCustomer.jsp");
			rd.forward(request, response);
		}

	}

	private void write(HttpServletResponse response, HashMap<String, Object> map) throws IOException {
		// TODO Auto-generated method stub

		response.setContentType("application/json");
		response.setCharacterEncoding("ISO-8859-1");
		response.getWriter().write(new Gson().toJson(map));
	}

}

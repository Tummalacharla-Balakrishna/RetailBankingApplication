package com.casestudy.retailbank.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.casestudy.retailbank.bean.AccountPOJO;
import com.casestudy.retailbank.service.AccountService;

//import com.google.gson.Gson;
/**
 * Servlet implementation class AccTypeSearch
 */
@WebServlet("/AccTypeSearch")
public class AccTypeSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccTypeSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("servlet call");
		int acc_id=Integer.parseInt(request.getParameter("aid"));
		System.out.println(acc_id);
		AccountService accountService=new AccountService();
		
		String accountType=new String();
		try {
			accountType = accountService.searchAccountTypeByAID(acc_id);
			System.out.println(accountType +" in controller" );
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		write(response,accountType);
		
		//doGet(request, response);
	}
	private void write(HttpServletResponse response, String accountType) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(accountType +" in writer" );
		response.setContentType("application/html");
		response.setCharacterEncoding("ISO-8859-1");
		response.getWriter().write(accountType);
	}

}

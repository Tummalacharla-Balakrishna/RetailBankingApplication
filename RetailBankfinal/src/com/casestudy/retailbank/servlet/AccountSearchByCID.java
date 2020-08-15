package com.casestudy.retailbank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.casestudy.retailbank.bean.AccountPOJO;
import com.casestudy.retailbank.service.AccountService;
import com.google.gson.Gson;


@WebServlet("/AccountSearchByCID")
public class AccountSearchByCID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		int acc_id=Integer.parseInt(request.getParameter("aid"));
		//System.out.println("i got :"+acc_id);
		//out.print("hii"+acc_id);
		AccountService accountService=new AccountService();
		AccountPOJO account=accountService.searchAccountByAID(acc_id);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("status", account.getAcc_type());
		map.put("balance",account.getBalance());
		
		write(response,map);
		
	}
	
	private void write(HttpServletResponse response, HashMap<String, Object> map) throws IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("application/json");
		response.setCharacterEncoding("ISO-8859-1");
		response.getWriter().write(new Gson().toJson(map));
	}

}

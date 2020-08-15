package com.casestudy.retailbank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.casestudy.retailbank.service.AccountServiceByTransaction;
import com.casestudy.retailbank.bean.CustomerTransactions;

/**
 * Servlet implementation class AccountServiceByTransactions
 */
@WebServlet("/AccountControllerByTransactions")
public class AccountControllerByTransactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountControllerByTransactions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out=response.getWriter();
		String action = request.getParameter("ViewStatementByTransaction");
		
		try {
			if(action.equals("ViewStatementByTransaction")) {
				int accId = Integer.parseInt(request.getParameter("AccountID"));
				String chooseType = request.getParameter("chooseOne");
				//System.out.println(accId+" "+chooseType);
				if(chooseType.equals("opt1")) {
					int count = Integer.parseInt(request.getParameter("TransactionCount"));
					//System.out.println(""+count);
					ArrayList<CustomerTransactions> list = new ArrayList<CustomerTransactions>();
					list = AccountServiceByTransaction.getTransactionDetails(accId, count);
					if(list !=null && list.size()>0) {
						
						request.setAttribute("transactionDetails", list);
						request.getRequestDispatcher("ViewStatementByTransactions.jsp").forward(request, response);
					}
					else {
						request.setAttribute("error", "Invalid AccountId");
						request.getRequestDispatcher("ViewStatementByTransactions.jsp").forward(request, response);
						//request.setAttribute("result", "No Such AccoundID found");
						//request.getRequestDispatcher("ViewStatementByTransactions.jsp").forward(request, response);
						//out.println("<h1 style='color:red'>No Such AccoundID found<h1>");
					}
				}else if(chooseType.equals("opt2")) {
					ArrayList<CustomerTransactions> list = new ArrayList<CustomerTransactions>();
					list = AccountServiceByTransaction.getTransactionDetails(accId);
					if(list !=null && list.size()>0) {	
						request.setAttribute("transactionDetails", list);
						request.getRequestDispatcher("ViewStatementByTransactions.jsp").forward(request, response);
					}
					else {
						request.setAttribute("error", "Invalid AccountId");
						request.getRequestDispatcher("ViewStatementByTransactions.jsp").forward(request, response);
						//out.println("<h1 style='color:red'>No Such AccoundID found<h1>");
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

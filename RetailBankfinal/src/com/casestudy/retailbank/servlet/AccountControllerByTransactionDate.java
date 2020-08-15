package com.casestudy.retailbank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.casestudy.retailbank.bean.CustomerTransactions;
import com.casestudy.retailbank.service.AccountServiceByTransaction;

/**
 * Servlet implementation class AccountControllerByTransactionDate
 */
@WebServlet("/AccountControllerByTransactionDate")
public class AccountControllerByTransactionDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountControllerByTransactionDate() {
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
		String action = request.getParameter("ViewStatementByTransactionDate");
		ArrayList<CustomerTransactions> list = null;
		//String hide_show = request.getParameter("hide_show");
		if(action.equals("ViewStatementByTransactionDate")) {
			int accId = Integer.parseInt(request.getParameter("AccountID"));
			String startDate = request.getParameter("StartDate");
			String endDate = request.getParameter("EndDate");
			 list = new ArrayList<CustomerTransactions>();
			list = AccountServiceByTransaction.getTransactionDetailsByDate(accId,startDate,endDate);
			if(list != null && list.size() != 0) {
				//request.setAttribute("hide_show", "makeVisible");
				request.setAttribute("transactionDetails", list);				
				request.getRequestDispatcher("ViewStatementByDate.jsp").forward(request, response);
			}else {
				request.setAttribute("error", "Invalid AccountId or No Transactions");
				request.getRequestDispatcher("ViewStatementByDate.jsp").forward(request, response);
			}
		}
	}

}

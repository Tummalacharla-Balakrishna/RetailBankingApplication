package com.casestudy.retailbank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.casestudy.retailbank.bean.AccountSearchPOJO;
import com.casestudy.retailbank.service.AccountServiceSearch;

/**
 * Servlet implementation class AccountControllerSearch
 */
@WebServlet("/AccountControllerSearch")
public class AccountControllerSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountControllerSearch() {
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
		
		String accountID = request.getParameter( "AccountID");
		String customerID = request.getParameter("CustomerID");
		
		ArrayList<AccountSearchPOJO> list = null;
		
		if(accountID != null && accountID.length() == 9 ) {
			//System.out.println("accountId :"+accountID);
			list = new ArrayList<AccountSearchPOJO>();
			list = AccountServiceSearch.searchAccount(Integer.parseInt(accountID),"acc_id");
			if(list != null && list.size() != 0 ) {
				request.setAttribute("searchAccount", list);
				request.getRequestDispatcher("SearchAccount.jsp").forward(request, response);
			}
			else {
				request.setAttribute("accerror", "Invalid AccountId");
				request.getRequestDispatcher("SearchAccount.jsp").forward(request, response);
			}
		}else  if(customerID != null && customerID.length() == 9){
			//System.out.println("accountId :"+customerID);
			list = new ArrayList<AccountSearchPOJO>();
			list = AccountServiceSearch.searchAccount(Integer.parseInt(customerID),"cust_id");
			if(list != null && list.size() != 0 ) {
				request.setAttribute("searchAccount", list);
				request.getRequestDispatcher("SearchAccount.jsp").forward(request, response);
			}
			else {
				request.setAttribute("custerror", "Invalid CusttomerId");
				request.getRequestDispatcher("SearchAccount.jsp").forward(request, response);
			}
		}else {
			response.sendRedirect("SearchAccount.jsp");
		}
	}

}

package com.casestudy.retailbank.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.casestudy.retailbank.bean.DepositPOJO;
import com.casestudy.retailbank.service.AccountServiceDeposit;

/**
 * Servlet implementation class AccountControllerDeposit
 */
@WebServlet("/AccountControllerDeposit")
public class AccountControllerDeposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountControllerDeposit() {
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
		String accId = request.getParameter("AccountID");
		String custId = request.getParameter("CustomerID");
		String accType = request.getParameter("AccountType");
		 double balance = Double.parseDouble(request.getParameter("Balance"));
		 double depositBalance = Double.parseDouble(request.getParameter("DepositAmount"));
		 ArrayList<DepositPOJO> depositStatus = null;
		 
		 depositStatus = new ArrayList<DepositPOJO>();
		 depositStatus = AccountServiceDeposit.depositStatus(Integer.parseInt(accId),Integer.parseInt(custId),accType,depositBalance);
		 if(depositStatus != null && depositStatus.size() > 0) {
				
				request.setAttribute("CustomerID", custId);
				request.setAttribute("AccountID", accId);
				request.setAttribute("AccountType", accType);
				for(DepositPOJO w : depositStatus) {
					balance = w.getAmount();
				}
				request.setAttribute("Balance", balance);
				
				request.setAttribute("res", "Deposit Successful");
				depositStatus.clear();
				request.getRequestDispatcher("DepositMoney.jsp").forward(request, response);
			}else {
			
				request.setAttribute("CustomerID", custId);
				request.setAttribute("AccountID", accId);
				request.setAttribute("AccountType", accType);
				request.setAttribute("Balance", balance);
				request.setAttribute("res", "Deposit Unsuccessful");
				
				request.getRequestDispatcher("DepositMoney.jsp").forward(request, response);
			}
	}

}

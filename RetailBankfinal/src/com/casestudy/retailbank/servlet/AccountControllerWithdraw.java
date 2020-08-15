package com.casestudy.retailbank.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.casestudy.retailbank.bean.WithdrawPOJO;
import com.casestudy.retailbank.service.AccountServiceWithdraw;

/**
 * Servlet implementation class AccountControllerWithdraw
 */
@WebServlet("/AccountControllerWithdraw")
public class AccountControllerWithdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountControllerWithdraw() {
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
		String accId = request.getParameter("AccountID");
		String custId = request.getParameter("CustomerID");
		String accType = request.getParameter("AccountType");
		 double balance = Double.parseDouble(request.getParameter("Balance"));
		 double withdrawBalance = Double.parseDouble(request.getParameter("WithdrawAmount"));
		 ArrayList<WithdrawPOJO> withdrawStatus = null;
		 
		 withdrawStatus = new ArrayList<WithdrawPOJO>();
		 withdrawStatus = AccountServiceWithdraw.withdrawStatus(Integer.parseInt(accId),Integer.parseInt(custId),accType,withdrawBalance);
		 if(withdrawStatus != null && withdrawStatus.size() > 0) {
				
				request.setAttribute("CustomerID", custId);
				request.setAttribute("AccountID", accId);
				request.setAttribute("AccountType", accType);
				for(WithdrawPOJO w : withdrawStatus) {
					balance = w.getAmount();
				}
				request.setAttribute("Balance", balance);
				
				request.setAttribute("res", "Withdraw Successful");
				withdrawStatus.clear();
				request.getRequestDispatcher("WithdrawAmount.jsp").forward(request, response);
			}else {
			
				request.setAttribute("CustomerID", custId);
				request.setAttribute("AccountID", accId);
				request.setAttribute("AccountType", accType);
				request.setAttribute("Balance", balance);
				request.setAttribute("res", "Withdraw Unsuccessful");
				System.out.println("456");
				request.getRequestDispatcher("WithdrawAmount.jsp").forward(request, response);
			}
	}

}

package com.casestudy.retailbank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.casestudy.retailbank.service.AccountServiceTransfer;

/**
 * Servlet implementation class AccountControllerTransferMoney
 */
@WebServlet("/AccountControllerTransferMoney")
public class AccountControllerTransferMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountControllerTransferMoney() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out=response.getWriter();
		String accId = request.getParameter("CustomerID").toLowerCase();
		String custid = request.getParameter("AccountId");
		String srcType = request.getParameter("src").toLowerCase();
		String destType = request.getParameter("dest");
		double amount = Double.parseDouble(request.getParameter("TransferAmount"));
		
		
		System.out.println(accId);
		System.out.println(custid);
		System.out.println(srcType);
		System.out.println(destType);
		System.out.println(amount);
		boolean flag = AccountServiceTransfer.transferStatus(Integer.parseInt(accId), srcType, destType, amount,Integer.parseInt(custid));
		
		if(!flag) {
			request.setAttribute("transferStatus", "Transaction Unsuccessful");
			request.setAttribute("CustomerID", accId);
			request.setAttribute("AccountId", custid);
			request.getRequestDispatcher("TransferMoney.jsp?id="+accId).forward(request, response);
		}else {
			request.setAttribute("transferStatus", "Transaction Successful");
			request.setAttribute("CustomerID", accId);
			request.setAttribute("AccountId", custid);
			request.getRequestDispatcher("TransferMoney.jsp").forward(request, response);
		}
		
		
	}

}
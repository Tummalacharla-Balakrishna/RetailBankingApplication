package com.casestudy.retailbank.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.casestudy.retailbank.bean.AccountPOJO;
import com.casestudy.retailbank.service.AccountService;

/**
 * Servlet implementation class AccountController
 */
@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountController() {
        super();
        // TODO Auto-generated constructor stub
       // ArrayList a = new ArrayList();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*System.out.println("servlet");
		AccountService service = new AccountService();
		String delAcc = request.getParameter("deleteAccount");
		System.out.println(delAcc);
		try{
			if(delAcc!=null && delAcc.equals("deleteAccount"))
			{
				//AccountPOJO account = new AccountPOJO();
				ArrayList<Integer> accountIdList;
			
				accountIdList = service.getAllAccountId();
				if(accountIdList!=null)
				{
					request.setAttribute("accountIdList", accountIdList);
					RequestDispatcher rd = request.getRequestDispatcher("DeleteAccount.jsp");
					rd.forward(request, response);
				}
			}
			else
			{
System.out.println("else");
			}
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}*/
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("servlet1");
		AccountService service = new AccountService();
		String source = request.getParameter("source");
		
		if(source!=null && source.equals("createAccount"))
		{
			AccountPOJO account = new AccountPOJO();
			account.setCust_id(Integer.parseInt(request.getParameter("CustomerID")));
			account.setAcc_type(request.getParameter("AccountType"));
			account.setBalance(Double.parseDouble(request.getParameter("DepositAmount")));
		
			System.out.println("Customer Details:\n"+account);
		
			try{
				//boolean flag = service.createAccount(account);
				boolean status= service.createAccount(account);
				
				if(status==true)
				{
					request.setAttribute("status", status);
				}
				RequestDispatcher rd = request.getRequestDispatcher("CreateAccount.jsp");
				rd.forward(request, response);
			}
			catch(ClassNotFoundException | SQLException e)
			{
				request.setAttribute("status", false);
				RequestDispatcher rd = request.getRequestDispatcher("CreateAccount.jsp");
				rd.forward(request, response);
				e.printStackTrace();
			}
		}
		
		/*----------logic for Accountdelete-----------------------*/
		
		if(source!=null && source.equals("deleteAccount"))
		{
		
		int accountId = Integer.parseInt(request.getParameter("AccountId"));
		String accountType=request.getParameter("AccountType");
		
		System.out.println(accountId+" "+accountType);
		try{
			if(source!=null && source.equals("deleteAccount"))
			{
				//AccountPOJO account = new AccountPOJO();
				//ArrayList<Integer> accountIdList;
			
				boolean status = service.deleteAccount(accountId,accountType);
				System.out.println("status"+status);
				
				request.setAttribute("status", status);
					
				
				RequestDispatcher rd = request.getRequestDispatcher("DeleteAccount.jsp");
				rd.forward(request, response);
			}
		}
		catch(ClassNotFoundException | SQLException e)
		{
			
			request.setAttribute("status", false);
			RequestDispatcher rd = request.getRequestDispatcher("DeleteAccount.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
		
		//doGet(request, response);
	}
	}

}

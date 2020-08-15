package com.casestudy.retailbank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.casestudy.retailbank.bean.AccountPOJO;
import com.casestudy.retailbank.bean.CustomerPOJO;
import com.casestudy.retailbank.bean.StatusPOJO;
import com.casestudy.retailbank.service.AccountService;
import com.casestudy.retailbank.service.CustomerService;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController") 
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CustomerController() {
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
		CustomerService service = new CustomerService();
		try {
			// System.out.println("Inside update try");
			List<CustomerPOJO> cust_id_list = service.GetCustomerList();
			request.setAttribute("cust_id_list", cust_id_list);

			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateCustomer.jsp");
			dispatcher.forward(request, response);
			// System.out.println("update try executed");

			for (int i = 0; i < cust_id_list.size(); i++) {
				// System.out.println(cust_id_list.get(i).getCust_id());
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		CustomerService service = new CustomerService();
		String source = request.getParameter("source");
		CustomerPOJO customer = new CustomerPOJO();
		if (source.equals("CreateCustomer")) {
			customer.setCust_ss_id(Integer.parseInt(request.getParameter("CustomerSSNID")));
			customer.setCust_name(request.getParameter("Name"));
			customer.setAge(Integer.parseInt(request.getParameter("age")));
			customer.setAddr(request.getParameter("Address"));
			customer.setState(request.getParameter("state"));
			customer.setCity(request.getParameter("city"));

			try {
				Integer CustomerID = service.CreateCustomer(customer);
				if (CustomerID != null) {
					request.setAttribute("CustomerID", CustomerID);
					request.setAttribute("message",
							"<p class='alert alert-success text-center'>Customer Created Successfully.<br>Customer ID: "
									+ CustomerID + "</p>");
				}
				RequestDispatcher rd = request.getRequestDispatcher("CreateCustomer.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException e) {
				request.setAttribute("CustomerID", null);
				request.setAttribute("message", "<p class='alert alert-danger text-center'>Something went wrong.<p>");
				RequestDispatcher rd = request.getRequestDispatcher("CreateCustomer.jsp");
				rd.forward(request, response);
				e.printStackTrace();
			} catch (SQLException e) {
				request.setAttribute("CustomerID", null);
				request.setAttribute("message",
						"<p class='alert alert-danger text-center'>Given Customer SSNID Already Exists!<p>");
				RequestDispatcher rd = request.getRequestDispatcher("CreateCustomer.jsp");
				rd.forward(request, response);
				e.printStackTrace();
			}
		}

		if (source.equals("UpdateCustomer")) {
			
			customer.setCust_id(Integer.parseInt(request.getParameter("cust_id")));
			customer.setCust_name(request.getParameter("NewName"));
			System.out.println(request.getParameter("NewName"));
			customer.setAddr(request.getParameter("NewAddress"));
			customer.setAge(Integer.parseInt(request.getParameter("NewAge")));
			Integer CustomerID = null;
			try {
				CustomerID = service.UpdateCustomer(customer.getCust_id(), customer.getCust_name(), customer.getAddr(), customer.getAge());
				if(CustomerID != null) {
					if (CustomerID != null) {
						request.setAttribute("CustomerID", CustomerID);
						request.setAttribute("message", "<p class='alert alert-success text-center'>Customer ID "
								+ CustomerID + " details updated Successfully.</p>");
					
				}
					if (CustomerID == 0) {
						request.setAttribute("message",
								"<p class='alert alert-danger text-center'>Given Customer does not Exists!<p>");
					}
					RequestDispatcher rd = request.getRequestDispatcher("UpdateCustomer.jsp");
					rd.forward(request, response);
			}
			
			
			
			} catch (ClassNotFoundException e) {
				request.setAttribute("CustomerID", null);
				request.setAttribute("message", "<p class='alert alert-danger text-center'>Something went wrong.<p>");
				RequestDispatcher rd = request.getRequestDispatcher("UpdateCustomer.jsp");
				rd.forward(request, response);
				e.printStackTrace();
			} catch (SQLException e) {
				request.setAttribute("CustomerID", null);
				request.setAttribute("message", "<p class='alert alert-danger text-center'>Something went wrong!<p>");
				RequestDispatcher rd = request.getRequestDispatcher("UpdateCustomer.jsp");
				rd.forward(request, response);
				e.printStackTrace();
			}
		}

		if (source.equals("deleteCustomer")) {
			System.out.println(request.getParameter("CustomerSSNID"));
			customer.setCust_id(Integer.parseInt(request.getParameter("CustomerId")));						
			customer.setCust_name(request.getParameter("Name"));			
			customer.setAddr(request.getParameter("Address"));
			customer.setCust_ss_id(Integer.parseInt(request.getParameter("CustomerSSNID")));
			customer.setAge(Integer.parseInt(request.getParameter("age")));
			Integer CustomerID = null;
			try {
				CustomerID = service.DeleteCustomer(customer.getCust_id(), customer.getCust_ss_id(),
						customer.getCust_name(), customer.getAge(), customer.getAddr());
				if (CustomerID != null) {
					request.setAttribute("CustomerID", CustomerID);
					request.setAttribute("message", "<p class='alert alert-success text-center'>Customer ID "
							+ CustomerID + " Deleted Successfully.</p>");
				}
				if (CustomerID == 0) {
					request.setAttribute("message",
							"<p class='alert alert-danger text-center'>Given Customer does not Exists!<p>");
				}
				RequestDispatcher rd = request.getRequestDispatcher("DeleteCustomer.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException e) {
				request.setAttribute("CustomerID", null);
				request.setAttribute("message", "<p class='alert alert-danger text-center'>Something went wrong.<p>");
				RequestDispatcher rd = request.getRequestDispatcher("DeleteCustomer.jsp");
				rd.forward(request, response);
				e.printStackTrace();
			} catch (SQLException e) {
				request.setAttribute("CustomerID", null);
				request.setAttribute("message", "<p class='alert alert-danger text-center'>Something went wrong!<p>");
				RequestDispatcher rd = request.getRequestDispatcher("DeleteCustomer.jsp");
				rd.forward(request, response);
				e.printStackTrace();
			}

		}
		
		//SEARCH CUSTOMER
		if(source.equals("search_cust"))
		{
			String ssn=request.getParameter("CustomerSSNID");
			
			if(ssn==null || ssn.trim().equals("") || ssn.isEmpty()) {
				
				//Search According to Customer Id
				String cid=request.getParameter("CustomerID");
				if(cid!=null)
				{
					int cust_id=Integer.parseInt(cid);
					CustomerService custService=new CustomerService();
					CustomerPOJO cust=custService.searchCustomerByCID(cust_id);
				
					if(cust!=null) {
						request.setAttribute("customer", cust);
						request.getRequestDispatcher("CustomerDetails.jsp").forward(request, response);
					}
					else {
						
						 out.println("<script type=\"text/javascript\">");
						 out.println("alert('CustomerID does not exists...Please provide valid CustomerID');");
						 out.println("location='CustomerSearch.jsp';");
						 out.println("</script>");
					}
				}
							
			}
			else {
				
				//Search According to Customer Id
				int ssnid=Integer.parseInt(ssn);
				CustomerService custService=new CustomerService();
				CustomerPOJO cust=custService.searchCustomerBySSNID(ssnid);
			
				if(cust!=null) {
					request.setAttribute("customer", cust);
					request.getRequestDispatcher("CustomerDetails.jsp").forward(request, response);
				}
				else {
				
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Please provide valid Customer SSNID');");
					out.println("location='CustomerSearch.jsp';");
					out.println("</script>");
				}
			}
			return;
		}
		
		//SEARCH ACCOUNT DETAILS
		else if(source.equals("search_account"))
		{
			String aid=request.getParameter("AccountID");
			if(aid==null || aid.trim().equals("") || aid.isEmpty())
			{
				//Search According to Customer Id
				int cust_id=Integer.parseInt(request.getParameter("CustomerID"));
				if(cust_id!=0)
				{
					//System.out.println("by  CustomerID Id");
					AccountService accountService=new AccountService();
					List<AccountPOJO> list_account=null;//new ArrayList<>();
					list_account=accountService.searchAccountByCID(cust_id);
					
					if(!list_account.isEmpty()) {
						request.setAttribute("search", "by_cust_id");
						request.setAttribute("list_account", list_account);
						request.getRequestDispatcher("AccountDetails.jsp").forward(request, response);
					}
					else {
					
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Please provide valid CustomerID');");
						out.println("location='SearchAccount.jsp';");
						out.println("</script>");
					}
				}
			}
			else
			{
				//Search According to Account Id
				int acc_id=Integer.parseInt(aid);
				if(acc_id!=0)
				{
					//System.out.println("by  Account Id");
					AccountService accountService=new AccountService();
					AccountPOJO account=accountService.searchAccountByAID(acc_id);
					
					if(account!=null) {
						request.setAttribute("search", "by_acc_id");
						request.setAttribute("account", account);
						request.getRequestDispatcher("AccountDetails.jsp").forward(request, response);
					}
					else {
					
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Please provide valid AccountID');");
						out.println("location='SearchAccount.jsp';");
						out.println("</script>");
					}
				}
			}
		}
		
		else if(source.equals("customer_status"))
		{
			//System.out.println("i got in statsus"+source);
			CustomerService custService=new CustomerService();
			List<StatusPOJO> cust_status_arr=custService.ViewAllCustomerStatus();
			
			if(!cust_status_arr.isEmpty())
			{
				request.setAttribute("cust_status_arr", cust_status_arr);
				request.getRequestDispatcher("CustomerStatus.jsp").forward(request, response);
			}
			else {
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Something went wrong');");
				out.println("location='CustomerStatus.jsp.jsp';");
				out.println("</script>");
			}
		}
		
		else if(source.equals("account_status"))
		{
			AccountService custService=new AccountService();
			List<StatusPOJO> acc_status_arr=custService.ViewAllAccountStatus();
			
			if(!acc_status_arr.isEmpty())
			{
				request.setAttribute("acc_status_arr", acc_status_arr);
				request.getRequestDispatcher("AccountStatus.jsp").forward(request, response);
			}
			else {
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Something went wrong');");
				out.println("location='AccountStatus.jsp';");
				out.println("</script>");
			}
		}
	}
}

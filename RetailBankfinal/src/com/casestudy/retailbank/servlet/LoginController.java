package com.casestudy.retailbank.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.casestudy.retailbank.service.LoginService;
import com.casestudy.retailbank.util.SessionChecker;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.setAttribute("message", "Logged out Successfully");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		HttpSession session = request.getSession(false);
		
		if(action == null)
		{
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		
		if((!action.equals("login")) && (!SessionChecker.isValidSession(session))) {
			request.setAttribute("message", "Invalid Session. Please Login again");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		if(action.equals("login"))
		{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			LoginService logservice = new LoginService();			
			boolean isValid = logservice.validateLogin(username, password);
			
			if(isValid)
			{
				HttpSession newSession = request.getSession(true);
				newSession.setAttribute("username", username);
				request.getRequestDispatcher("CreateCustomer.jsp").forward(request,  response);
			}
			else
			{
				request.setAttribute("message", "Invalid Login Credentials.");
				request.getRequestDispatcher("login.jsp").forward(request,  response);
			}
		}
		
		
		//doGet(request, response);
	}

}

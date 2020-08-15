<%@page import="com.casestudy.retailbank.util.SessionChecker"%>
<% if(!SessionChecker.isValidSession(session)) 
	{
		request.setAttribute("message", "Invalid Session. Please login again.");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		return;
	}
	%>
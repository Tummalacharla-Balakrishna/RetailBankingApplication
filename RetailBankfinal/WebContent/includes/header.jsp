<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<div class="jumbotron nav-header">
		<a href="#"><span class="left">FedChoice</span> <span class="right">Bank</span></a>
		
		<nav class="navbar">
		  <div class="container-fluid">
		    <ul class="nav navbar-nav navbar-list">
		      <li><a href="index.jsp">Home</a></li>
		      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Customer Managment <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a href="CreateCustomer.jsp">Create Customer</a></li>
		          <li><a href="CustomerController">Update Customer</a></li>
		          <li><a href="DeleteCustomer.jsp">Delete Customer</a></li>
		          <li><a href="CustomerSearch.jsp">Search Customer</a></li>
		        </ul>
		      </li>
		      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Account Managment <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a href="CreateAccount.jsp">Create Account</a></li>
		          <li><a href="DeleteAccount.jsp">Delete Account</a></li>
		          <li><a href="SearchAccount.jsp">Search Account</a></li>		         
		        </ul>
		      </li>
		      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Status Details <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <!-- 
		         <li><a href="AccountStatus.jsp">Account Status</a></li>
		         <li><a href="CustomerStatus.jsp">Customer Status</a></li>
		         -->
		        
				<form method="post" action="CustomerController" >
		         	<input type=hidden name="source" value="customer_status">
		          	<li><input type="submit" value="Customer Status" class="submitLink"></li>
		        </form>
		          
		         <form method="post" action="CustomerController" >
		          	<input type="hidden" name="source" value="account_status">
		          	<li><input type="submit" value="Account Status" class="submitLink"></li>
		         </form>
		         
		        </ul>
		      </li>
		      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Account Operations <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a id="DepositMoney" href="SearchAccount.jsp"">Deposit Money</a></li>
		          <li><a id="WithdrawAmount" href="SearchAccount.jsp">Withdraw Money</a></li>
		          <li><a id="TransferMoney" href="SearchAccount.jsp">Transfer Money</a></li>
		          <li><a id="" href="ViewStatementByDate.jsp">View Statement by Date</a></li>
		          <li><a id="" href="ViewStatementByTransactions.jsp">View Statement by Transactions</a></li>
		        </ul>
		      </li>
		      <%String username = (String)session.getAttribute("username"); %>
		      <%if(username == null){ %>
		      	<li><a href="login.jsp">Login</a></li>
		      	<% } %>
		      	<%if(username != null){ %>
		      <li><a href="LoginController">Logout</a></li>
		      <% } %>
		    </ul>
		  </div>
		</nav>
	</div>

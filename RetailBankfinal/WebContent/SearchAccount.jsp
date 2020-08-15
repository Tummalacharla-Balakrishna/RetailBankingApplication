<jsp:include page="SessionCheck.jsp"></jsp:include>
<%@page import="java.util.ArrayList" %>
<%@page import="com.casestudy.retailbank.bean.AccountSearchPOJO" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.io.FileWriter" %>
<% ArrayList<AccountSearchPOJO> searchList = (ArrayList)request.getAttribute("searchAccount"); %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Search Account</title>
<%@ include file = "includes/head.jsp" %>
</head>
<body>
<%@ include file = "includes/header.jsp" %>

<div class="container">
            <div class="row">
                <div class="col-md-6 col-sm-12 col-md-offset-3">
                    <h1 class="text-center">Search Account</h1>                                  
                    <form name="form" onsubmit="searchAccountValidation()" action="AccountControllerSearch" method="post" class="createAccount m-top">
                    
                        <div class="col-md-6">
                            <label for="#AccountID" class="pull-left">Account ID<span class="text-danger"> *</span></label>
                           
                        </div>
                        <div class="col-md-6">
                            <input type="text" name="AccountID" class="form-inline pull-right form-group form-control" id="AccountID" >
                        </div>
                        <div class="col-sm-12 col-sm-offset-6">
                        	
                        	<p style="color:#FF0000"><%
	                        	if(request.getAttribute("accerror") != null){
	                        		out.println("Invalid AccountId");
	                        	}
                        	%></p>
                        
                        </div>
                        <br><br><br>
                        <center><strong>OR</strong></center>
                        <br><br>  
                        <div class="col-md-6">
                            <label for="#CustomerID" class="pull-left">Enter Customer ID<span class="text-danger"> *</span></label>
                           
                        </div>
                        <div class="col-md-6">
                            <input type="text" name="CustomerID" class="form-inline pull-right form-group form-control" id="CustomerID">
                        </div> 
                        <div class="col-sm-12 col-sm-offset-6">
                        	
                        	<p style="color:#FF0000"><%
	                        	if(request.getAttribute("custerror") != null){
	                        		out.println("Invalid CustomerId");
	                        	}
                        	%></p>
                        
                        </div>
                        <div class="col-md-offset-4 col-md-4 col-sm-6">
                        	<input type="submit" value="View" class="form-inline pull-right form-group form-control button-primary text-center">
                        </div>                     
                    </form>
                </div>
             </div>
        </div>
        
        <div class="container" id="display">
			<table class="table">
				<thead>
					<th>AccountID</th>
					<th>CustomerID</th>
					<th>Amount</th>
					<th>Type</th>
					<th>Update</th>
					<th>Withdraw</th>
					<th>Transfer</th>
				</thead>
				<tbody>
				<%
				// Iterating through subjectList
				
				if(request.getAttribute("searchAccount") != null)  // Null check for the object
				{
					
					for(AccountSearchPOJO list : searchList){
						request.setAttribute("searchList", list);
					%>
					<tr><td><%=list.getAccId()%></td>
						<td><%=list.getCustId()%></td>
						<td><%=list.getAmount()%></td>
						<td><%=list.getType()%></td>
						<td><a href=<%=list.getUpdate()+"?accid="%><%= list.getAccId()+"&custid=" %><%=list.getCustId()+"&acctype="%><%=list.getType()+"&balance="%><%=list.getAmount()%>   >Deposit</a></td>
						<td><a href=<%=list.getDelete()+"?accid="%><%= list.getAccId()+"&custid=" %><%=list.getCustId()+"&acctype="%><%=list.getType()+"&balance="%><%=list.getAmount()%>  >Withdraw</a></td>
						<td><a href=<%=list.getTransfer()+"?id="%><%= list.getCustId()+"&accid=" %><%=list.getAccId() %> >Transfer</a></td>
					</tr>
					<%
					}
				}
				%>
				</tbody>
			</table>
		</div>
	

<%@ include file = "includes/footer.jsp" %>
</body>
</html>
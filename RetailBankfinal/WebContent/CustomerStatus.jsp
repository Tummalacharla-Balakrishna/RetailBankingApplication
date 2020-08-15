<jsp:include page="SessionCheck.jsp"></jsp:include>
<!DOCTYPE html>
<html>
    <head>
        <title>Customer Status</title>
        <%@ include file = "includes/head.jsp" %>
    </head>
    <body>
    <%@page import="com.casestudy.retailbank.bean.StatusPOJO"
    		import="java.util.List" 
     %>
    	<!-- @require header -->
    	<%@ include file = "includes/header.jsp" %>
        <div class="container">
        <h1 class="text-center">Customer Status</h1>
            <div class="row">
                <table class="table table-bordered table-responsive text-center m-top">
                    <thead class="text-center table-head">
                        <tr>
                            <th class="text-center">Customer ID</th>
                            <th class="text-center">Customer SSN ID</th>
                            <th class="text-center">Status</th>
                            <th class="text-center">Message</th>
                            <th class="text-center">Last Updated</th>
                            <th class="text-center">Operations</th>
                            <th class="text-center">View Profile</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                    List<StatusPOJO> cust_status_arr=(List<StatusPOJO>)request.getAttribute("cust_status_arr");
                    StatusPOJO cust_status=null;
                    for(int i=0;i<cust_status_arr.size();i++)
                    {
                    	cust_status=cust_status_arr.get(i);
                    
                    %>
                        <tr>
                            <td><%=cust_status.getCust_id() %></td>
                            <td><%=cust_status.getCust_ss_id() %></td>
                            <td><%=cust_status.getStatus() %></td>
                            <td><%=cust_status.getMessage() %></td>
                            <td><%=cust_status.getLast_updated() %></td>
                            
                            <td>
                            <form method="post" action="CustomerController" >
		         				<input type=hidden name="source" value="customer_status">
		          				<input type="submit" value="Refresh">
		        			</form>
		          			</td>
		          			
		        			<td>
                            <form method="post" action="CustomerController" >
                            	<input type=hidden name="CustomerID" value="<%=cust_status.getCust_id() %>">
		         				<input type=hidden name="source" value="search_cust">
		          				<input type="submit" value="View Details">
		        			</form>
		          			</td>
                            
                           <!-- <td><a href="#">Refresh</a></td>
                            <td><a href="#">View Details</a></td>-->
                        </tr>
                        <%
                    }
                        %>
                   
                    </tbody>
                </table>
            </div>
        </div>
        <!-- @require footer -->
        <%@ include file = "includes/footer.jsp" %>
    </body>
</html>

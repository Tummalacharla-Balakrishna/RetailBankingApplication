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
        <h1 class="text-center">Account Status</h1>
            <div class="row">
                <table class="table table-bordered table-responsive text-center m-top">
                    <thead class="text-center table-head">
                        <tr>
                            <th class="text-center">Customer ID</th>
                            <th class="text-center">Account ID</th>
                            <th class="text-center">Account Type</th>
                            <th class="text-center">Account Status</th>
                            <th class="text-center">Message</th>
                            <th class="text-center">Last Updated</th>
                            <th class="text-center">Operations</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    <%
                    List<StatusPOJO> acc_status_arr=(List<StatusPOJO>)request.getAttribute("acc_status_arr");
                    StatusPOJO acc_status=null;
                    for(int i=0;i<acc_status_arr.size();i++)
                    {
                    	acc_status=acc_status_arr.get(i);
                    
                    %>
                        <tr>
                            <td><%=acc_status.getCust_id() %></td>
                            <td><%=acc_status.getAcc_id() %></td>
                            <td><%=acc_status.getAcc_type() %></td>
                            <td><%=acc_status.getStatus() %></td>
                            <td><%=acc_status.getMessage() %></td>
                            <td><%=acc_status.getLast_updated() %></td>
                            
                            <td>
                            <form method="post" action="CustomerController" >
		         				<input type=hidden name="source" value="account_status">
		          				<input type="submit" value="Refresh">
		        			</form>
		          			</td>
		          			
                          <!-- <td><a href="#">Refresh</a></td>-->                            
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

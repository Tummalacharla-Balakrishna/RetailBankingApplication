<%@page import="java.util.ArrayList" %>
<%@page import="com.casestudy.retailbank.bean.CustomerTransactions" %>
<%@page import="java.util.Iterator"%>
<jsp:include page="SessionCheck.jsp"></jsp:include>
<% ArrayList<CustomerTransactions> statusList = (ArrayList) request.getAttribute("transactionDetails"); %>

<!DOCTYPE html>
<html>
    <head>
        <title>View Statement By Transactions</title>
        <%@ include file = "includes/head.jsp" %>
        <script src="js_lib/jquery-3.3.1.slim.min.js" ></script>
        <script src="js_lib/jspdf.min.js" ></script>
        <script src="js_lib/jspdf.plugin.autotable.min.js" ></script>
        <script src="js_lib/tableHTMLExport.js" ></script>
    </head>
    <body onload="initialize()">

        <!-- @require header -->
		<%@ include file = "includes/header.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <h1 class="text-center">Account Statement</h1>                                  
                    <form name="form" action="AccountControllerByTransactions" method="post" class="createAccount m-top">
                    	<input type="hidden" name="ViewStatementByTransaction" value="ViewStatementByTransaction">
                        <div class="col-md-3">
                            <label for="#AccountID" >Account Id : </label>
                        </div>
                        <div class="col-md-6">
                            <input type="number" name="AccountID" class="form-inline pull-right form-group form-control" id="AccountID" onblur="validateAccountId()" required>
                        </div>
                        <p style="color:#FF0000"><%
							if(request.getAttribute("error") != null){
								String err=(String)request.getAttribute("error");
								out.println(err);
							}
							%>
						</p>	
                        <div class="col-md-12">
                            <div class="radio">
                            	<label style="font-weight:bold"><input type="radio" value="opt1"  name="chooseOne"  id="byNumber" checked>Last Number of Transactions</label>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="radio">
                            	<label style="font-weight:bold"><input type="radio" value="opt2"  name="chooseOne"  id="start_end" >Start-End Dates</label>
                            </div>
                        </div>
                         <div class="col-md-5">
                            <label for="#Transactions" class="pull-left">Number of Transactions</label>
                        </div>
                         <div class="col-md-2">
                            <select class="form-inline pull-right form-group form-control" name="TransactionCount" id="Transaction" required>
                                <option> 1</option>                               
                               
                            </select>
                        </div>
                         <div class="col-md-4 col-md-offset-3 ">
                        	<input type="submit" value="Submit" class="form-inline pull-right form-group form-control button-primary">
                        </div>
						                        
                   </form>
                </div>
            </div>
        </div>
		<div class="container">
			<table class="table" id="table-show-hide">
				<thead>
					<th>TransactionId</th>
					<th>Description</th>
					<th>Date</th>
					<th>Amount</th>
					<th>AccountId</th>
				</thead>
				<tbody>
				<%
				// Iterating through subjectList
				
				if(request.getAttribute("transactionDetails") != null)  // Null check for the object
				{
					Iterator<CustomerTransactions> iterator = statusList.iterator();  // Iterator interface
					
					while(iterator.hasNext())  // iterate through all the data until the last record
					{
						CustomerTransactions statusDetails = iterator.next(); //assign individual employee record to the employee class object
					%>
					<tr><td><%=statusDetails.getId()%></td>
						<td><%=statusDetails.getType()%></td>
						<td><%=statusDetails.getDate()%></td>
						<td><%=statusDetails.getAmount()%></td>
						<td><%=statusDetails.getAccId() %></td>
					</tr>
					<%
					}
				}
				%>
				</tbody>
			</table>
		</div>		
		


        <!-- @require footer -->
        <%@ include file = "includes/footer.jsp" %>
        
    </body>
</html>

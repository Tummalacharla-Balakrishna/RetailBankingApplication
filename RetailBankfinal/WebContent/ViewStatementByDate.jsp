<%@page import="java.util.ArrayList" %>
<%@page import="com.casestudy.retailbank.bean.CustomerTransactions" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.io.FileWriter" %>
<jsp:include page="SessionCheck.jsp"></jsp:include>
<% ArrayList<CustomerTransactions> statusList = (ArrayList) request.getAttribute("transactionDetails"); %>
<!DOCTYPE html>
<html>
    <head>
        <title>View Statement By Date</title>
        <%@ include file = "includes/head.jsp" %>
        <script src="js_lib/jquery-3.3.1.slim.min.js" ></script>
        <script src="js_lib/jspdf.min.js" ></script>
        <script src="js_lib/jspdf.plugin.autotable.min.js" ></script>
        <script src="js_lib/tableHTMLExport.js" ></script>
    </head>
    <body>

        <!-- @require header -->
		<%@ include file = "includes/header.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-sm-12 col-md-offset-3">
                    <h1 class="text-center">Account Statement</h1>                                  
                    <form name="form" action="AccountControllerByTransactionDate" method="post" class="createAccount m-top">
                    	<input type="hidden" name="ViewStatementByTransactionDate" value="ViewStatementByTransactionDate">
                        <div class="col-md-6 col-md-4">
                            <label for="#AccountID" >Account Id <span class="text-danger"> *</span> </label>
                        </div>
                        <div class="col-md-6 col-md-6">
                            <input type="number" name="AccountID" class="form-inline pull-right form-group form-control" id="AccountID" onblur="validateAccountId()" required>
                        </div>
						<p style="color:#FF0000"><%
							if(request.getAttribute("error") != null){
								out.println(""+(String)request.getAttribute("error"));
							}
							
							%>
						</p>	                        
                        <div class="col-md-6 col-md-4">
                            <label for="#StartDate" >Start Date <span class="text-danger"> *</span> </label>
                        </div>
                        <div class="col-md-6 col-md-6">
                            <input type="date" name="StartDate" class="form-inline pull-right form-group form-control" id="StartDate" required>
                        </div>
                        
                        <div class="col-md-6 col-md-4">
                            <label for="#EndDate" >End Date <span class="text-danger"> *</span> </label>
                        </div>
                        <div class="col-md-6 col-md-6">
                            <input type="date" name="EndDate" class="form-inline pull-right form-group form-control" id="EndDate"  required>
                        </div>
                        <div class="col-md-6 col-md-offset-4">
                        	<input type="submit" value="Submit" class="form-inline pull-right form-group form-control button-primary">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="container" id="display">
			<table class="table" id="example">
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
			<div class="row">
				<div class="col-md-4 col-md-offset-3">
					<input type="button" id="pdf" onclick="downloadPdf()" value="Download As PDF File">
	        	</div>
	        	<div class="col-md-4">
					<input type="button" id="csv" onclick="downloadCsv()" value="Download As Excel File">
	        	</div>
			</div>
		</div>	
		        <!-- @require footer -->
        <%@ include file = "includes/footer.jsp" %>
        
    </body>
</html>

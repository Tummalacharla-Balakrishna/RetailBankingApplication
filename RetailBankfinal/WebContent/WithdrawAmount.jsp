<jsp:include page="SessionCheck.jsp"></jsp:include>
<!DOCTYPE html>
<html>
    <head>
        <title>Withdraw Amount</title>
        <%@ include file = "includes/head.jsp" %>
    </head>
    <body>

        <!-- @require header -->
		<%@ include file = "includes/header.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-sm-12 col-md-offset-3">
                    <h1 class="text-center">Withdraw Amount</h1>
                    </br></br>
                    <form method="post" action="AccountControllerWithdraw" class="WithdrawAmount">
                    
                        <div class="col-md-6 col-sm-6">
                            <label for="#CustomerID" class="pull-left">Customer ID</label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                        	<input type="text" name="CustomerID" value=<% if(request.getParameter("custid")!= null){
                        		out.println(""+request.getParameter("custid"));
                        	}else{
                        		out.println(""+request.getAttribute("CustomerID"));
                        	} %> class="form-inline pull-right form-group form-control" id="CustomerID" readonly>
                        </div>
                        </br></br>
                         <div class="col-md-6 col-sm-6">
                            <label for="#AccountID" class="pull-left">Account ID</label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                        	<input type="text" name="AccountID" value=<% if(request.getParameter("accid")!= null){
                        		out.println(""+request.getParameter("accid"));
                        	}else{
                        		out.println(""+request.getAttribute("AccountID"));
                        	} %> class="form-inline pull-right form-group form-control" id="AccountID" readonly>
                        </div>
                        </br></br>
                         <div class="col-md-6 col-sm-6">
                            <label for="#AccountType" class="pull-left">Account Type</label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                        	<input type="text" name="AccountType" value=<% if(request.getParameter("acctype")!= null){
                        		out.println(""+request.getParameter("acctype"));
                        	}else{
                        		out.println(""+request.getAttribute("AccountType"));
                        	} %> class="form-inline pull-right form-group form-control" id="#AccountType" readonly>
                        </div>
                        </br></br>
                         <div class="col-md-6 col-sm-6">
                            <label for="#Balance" class="pull-left">Balance</label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                        	<input type="text" name="Balance" value=<% if(request.getParameter("balance")!= null){
                        		out.println(""+request.getParameter("balance"));
                        	}else{
                        		out.println(""+request.getAttribute("Balance"));
                        	} %> class="form-inline pull-right form-group form-control" id="Balance" readonly>
                            
                        </div>
                       	<div class="col-sm-12 col-sm-offset-6">
                            <p style="color:#FF0000"><%
                            	if(request.getAttribute("res") != null){
                            		out.println(""+(String)request.getAttribute("res"));
                            	}
                            %></p>
                        </div>
                        </br></br>
                        
                         <div class="col-md-6 col-sm-6">
                            <label for="#WithdrawAmont" class="pull-left">Withdraw Amount</label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <input type="number" name="WithdrawAmount" class="form-inline pull-right form-group form-control" id="WithdrawAmount" required>
                        </div>
                         
                         <div class="col-md-6 col-sm-6">
                        	<input  type="submit" value="Submit" class="form-inline pull-right form-group form-control button-primary">
                        </div>
                      
                    </form>
                </div>
            </div>
        </div>

		
        <!-- @require footer -->
        <%@ include file = "includes/footer.jsp" %>
        
    </body>
</html>
<jsp:include page="SessionCheck.jsp"></jsp:include>
<%@page import="java.sql.*"%>
<%@page import="java.util.ArrayList"%>

<%@page import="com.casestudy.retailbank.bean.AccountSearchPOJO" %>
<%@page import="com.casestudy.retailbank.util.DBConnectionUtil" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Transfer Money</title>
        <%@ include file = "includes/head.jsp" %>
    </head>
    <body>

        <!-- @require header -->
		<%@ include file = "includes/header.jsp" %>
        <div class="container">
           <div class="row">
                <div class="col-md-6 col-sm-12 col-md-offset-3">
                    <h1 class="text-center">Transfer Money</h1>
                   </br></br>
                    <form name="myform" action="AccountControllerTransferMoney" method="post" class="Transfer Money">
                    	<input type="hidden" name="TransferMoney" value="TransferMoney">
                    	<input type="hidden" name ="AccountId" value=<% if(request.getParameter("accid")!= null){
                    			out.println(""+(String)request.getParameter("accid"));
                    		}else{
                    			out.println(""+(String)request.getAttribute("AccountId"));
                    		}
                    	
                    	%> >
                        <div class="col-md-6 col-sm-6">
                            <label for="#CustomerID" class="pull-left">Customer ID</label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <input type="text" value=<% if(request.getParameter("id") != null){
                            	out.println(request.getParameter("id"));
                            }else{
                            	out.println(request.getAttribute("CustomerID"));
                            	
                            } %> name="CustomerID" class="form-inline pull-right form-group form-control" id="CustomerID"  required readonly>
                        </div>
                        
                        <div class="col-md-6 col-sm-6">
                            <label for="#Source" class="pull-left">Source Account Type</label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <select name="src" class="form-inline pull-right form-group form-control" id="Source" required>
                                <option disabled selected value> </option>
                                <option> Current</option>
                                <option> Saving</option>
                               
                            </select>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <label for="#Taget" class="pull-left">Target Account Type</label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <select name="dest" class="form-inline pull-right form-group form-control" id="Target" required>
                            <option disabled selected value> </option>
                                <option> Current</option>
                                <option> Saving</option>
                               
                             </select>
                        </div>
                        
                         <div class="col-md-6 col-sm-6">
                            <label for="#TransferAmount" class="pull-left">Transfer Amount</label>
                        </div>
                        
                       
                        <div class="col-md-6 col-sm-6">
                            <input type="number" name="TransferAmount" class="form-inline pull-right form-group form-control" id="TransferAmount" required>
                        </div>
                        <div class="col-md-6 col-sm-6 col-sm-offset-6">
                            <p style="color:#FF0000"><%
                            	if(request.getAttribute("transferStatus") != null){
                            		out.println(""+(String)request.getAttribute("transferStatus"));

                            	}
                            %></p>
                        </div>
                         <div class="col-md-6 col-sm-6">
                        	<input type="submit" value="Transfer" class="form-inline pull-right form-group form-control button-primary">
                        </div>
                      
                    </form>
                </div>
            </div>
        </div>



        <!-- @require footer -->
        <%@ include file = "includes/footer.jsp" %>
        
    </body>
</html>
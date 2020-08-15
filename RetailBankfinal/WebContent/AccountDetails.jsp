<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="SessionCheck.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Details</title>
<meta charset="UTF-8">
        <%@ include file = "includes/head.jsp" %>
</head>
<body>
 <%@page import="com.casestudy.retailbank.bean.AccountPOJO"
 		 import="java.util.List"
  %>
 
        <!-- @require header -->
        <%@ include file = "includes/header.jsp" %>
        
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-sm-12 col-md-offset-3">
                    <h1 class="text-center">Account Details</h1>
                    <form action="" method="post" class="m-top">
                    
                    <%
 	
    				String search=(String)request.getAttribute("search");
                    if(search.equals("by_acc_id"))
                    {
						AccountPOJO account=new AccountPOJO();
    					account=(AccountPOJO)request.getAttribute("account");
 					%>
 
                     <div class="col-md-6 col-sm-6">
                            <label for="#CustomerID" class="pull-left">Customer ID</label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <label  name="CustomerID" class="form-inline pull-right form-group form-control" id="CustomerID">
                            <%=account.getCust_id() %></label>
                        </div>
                    	<div class="col-md-6 col-sm-6">
                            <label for="#AccountID" class="pull-left">Account ID</label>
                        </div>
                         <div class="col-md-6 col-sm-6">
                            <select class="form-inline pull-right form-group form-control" id="AccountID" >
                                <option><%=account.getAcc_id() %></option>
                             <!--    <option>State 2</option>
                                <option>State 3</option>
                                <option>State 4</option>
                                <option>State 5</option>
                                <option>State 6</option>-->
                            </select>
                        </div>
                       
                        <div class="col-md-6 col-sm-6">
                            <label for="#Balance" class="pull-left">Account Balance</label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <label name="Balance" class="form-inline pull-right form-group form-control" id="Balance" >
                            <%=account.getBalance() %></label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <label for="#Type" class="pull-left">Account Type</label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <label name="Type" class="form-inline pull-right form-group form-control" id="Type">
                           <%=account.getAcc_type()  %></label>
                        </div>
                 <%
                    }
                    else if(search.equals("by_cust_id"))
                    {
                    	List<AccountPOJO> list_account=(List<AccountPOJO>)request.getAttribute("list_account");
                    	AccountPOJO account=list_account.get(0);
                    	%>
                    	
                    	<div class="col-md-6 col-sm-6">
                            <label for="#CustomerID" class="pull-left">Customer ID</label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <label  name="CustomerID" class="form-inline pull-right form-group form-control" id="CustomerID">
                            <%=account.getCust_id() %></label>
                        </div>
                    	<div class="col-md-6 col-sm-6">
                            <label for="#AccountID" class="pull-left">Account ID</label>
                        </div>
                         <div class="col-md-6 col-sm-6">
                            <select class="form-inline pull-right form-group form-control" id="AccountID" >
                            <%
                            	for(int i=0;i<list_account.size();i++)
                            	{
                            
                            %>
                                <option><%=list_account.get(i).getAcc_id() %></option>
                             <%  } 
                             %>
                            </select>
                        </div>
                       
                        <div class="col-md-6 col-sm-6">
                            <label for="#Balance" class="pull-left">Account Balance</label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <label name="Balance" class="form-inline pull-right form-group form-control" id="Balance" >
                            <%=account.getBalance() %></label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <label for="#Type" class="pull-left">Account Type</label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <label name="Type" class="form-inline pull-right form-group form-control" id="Type">
                           <%=account.getAcc_type()  %></label>
                        </div>
                    	
                <%
                    }
                 
                 %>
                       <div class="col-md-offset-4 col-md-6 col-sm-4">

                        	<input type="submit" value="Deposit" class="form-inline pull-right form-group form-control button-primary text-center">
                        </div>  
                     <div class="col-md-offset-4 col-md-6 col-sm-4">
                        	
                        	<input type="submit" value="Withdraw" class="form-inline pull-right form-group form-control button-primary text-center">
                       </div>  
                       <div class="col-md-offset-4 col-md-6 col-sm-6">

                        	<input type="submit" value="Transfer" class="form-inline pull-right form-group form-control button-primary text-center">
                        </div>  
                       
  			         </form>
                </div>
            </div>
        </div>

        <!-- @require footer -->
        <%@ include file = "includes/footer.jsp" %>
        
    </body>

</html>

<script >
$(document).ready(function() {
	$('#AccountID').change(function() {
		var aid=$("#AccountID").val();
		$.ajax({
			url : 'AccountSearchByCID',
			data : {
				
				aid:aid
			},
			type:'post',
			success : function(response) {
				
				$('#Type').text(response.status);
				$('#Balance').text(response.balance);
			}
			
		});
	});
});

		

</script>
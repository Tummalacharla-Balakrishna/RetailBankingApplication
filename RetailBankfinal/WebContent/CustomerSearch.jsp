<jsp:include page="SessionCheck.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="SessionCheck.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<title>Search Customer</title>
<%@ include file = "includes/head.jsp" %>
</head>
<body>
<%@ include file = "includes/header.jsp" %>

<div class="container">
            <div class="row">
                <div class="col-md-6 col-sm-12 col-md-offset-3">
                    <h1 class="text-center">Search Customer</h1>                                  
                    <form name="form" onsubmit="return customerSearchValidation()" action="CustomerController" method="post" class="createAccount m-top">
                    
                        <div class="col-md-6 col-sm-6">
                            <label for="#CustomerSSNID" class="pull-left">Enter SSN ID<span class="text-danger"> *</span></label>
                           
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <input type="text" name="CustomerSSNID" class="form-inline pull-right form-group form-control" id="CustomerSSNID" >
                        </div>
                        <br><br><br>
                        <center><strong>OR</strong></center>
                        <br><br>  
                        <div class="col-md-6 col-sm-6">
                            <label for="#CustomerID" class="pull-left">Enter Customer ID<span class="text-danger"> *</span></label>
                           
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <input type="number" name="CustomerID" class="form-inline pull-right form-group form-control" id="CustomerID" >
                        </div> 
                        <div class="col-md-offset-4 col-md-4 col-sm-6">
				<input type="hidden" name="source" value="search_cust">
                        	<input type="submit" value="View" class="form-inline pull-right form-group form-control button-primary text-center">
                        </div>                     
                    </form>
                </div>
             </div>
        </div>

<%@ include file = "includes/footer.jsp" %>
</body>
</html>

<jsp:include page="SessionCheck.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Details</title>
<meta charset="UTF-8">
<%@ include file="includes/head.jsp"%>
</head>
<body>
	<%@page import="com.casestudy.retailbank.bean.CustomerPOJO"%>
	<%
        CustomerPOJO customer=new CustomerPOJO();
        
        customer=(CustomerPOJO)request.getAttribute("customer");
 %>

	<!-- @require header -->
	<%@ include file="includes/header.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-6 col-sm-12 col-md-offset-3">
				<h1 class="text-center">Customer Details</h1>
				<form action="" method="" class="m-top">
					<div class="col-md-6 col-sm-6">
						<label for="#CustomerSSNID" class="pull-left">Customer ID</label>
					</div>
					<div class="col-md-6 col-sm-6">
						<label name="CustomerSSNID" class="pull-left form-group"
							id="CustomerSSNID"> <%out.print(customer.getCust_id()); %></label>
					</div>
					<div class="col-md-6 col-sm-6">
						<label for="#CustomerSSNID" class="pull-left">Customer
							SSNID</label>
					</div>
					<div class="col-md-6 col-sm-6">
						<label name="CustomerSSNID" class="pull-left form-group"
							id="CustomerSSNID"> <%=customer.getCust_ss_id() %></label>
					</div>
					<div class="col-md-6 col-sm-6">
						<label for="#Name" class="pull-left">Name</label>
					</div>
					<div class="col-md-6 col-sm-6">
						<label name="Name" class="pull-left form-group" id="Name">
							<%=customer.getCust_name() %></label>
					</div>
					<div class="col-md-6 col-sm-6">
						<label for="#Age" class="pull-left">Age</label>
					</div>
					<div class="col-md-6 col-sm-6">
						<label name="age" class="pull-left form-group" id="Age"> <%=customer.getAge() %>
							Years
						</label>
					</div>
					<div class="col-md-6 col-sm-6">
						<label for="#Address" class="pull-left">Address</label>
					</div>
					<div class="col-md-6 col-sm-6">
						<label name="Address" class="pull-left form-group" id="Address">
							<%=customer.getAddr() %></label>
					</div>
					<div class="col-md-6 col-sm-6">
						<label for="#State" class="pull-left">State</label>
					</div>
					<div class="col-md-6 col-sm-6">
						<label name="State" class="pull-left form-group" id="State">
							<%=customer.getState() %>
						</label>
					</div>
					<div class="col-md-6 col-sm-6">
						<label for="#City" class="pull-left">City</label>
					</div>
					<div class="col-md-6 col-sm-6">
						<label class="pull-left form-group" id="City" name="City">
							<%=customer.getCity() %>
						</label>
					</div>


					<div class="col-md-6 col-sm-6">
						<input type="button" value="Back"
							class="form-inline pull-right form-group form-control button-primary"
							onclick="window.location = 'CustomerSearch.jsp'" />

					</div>

				</form>
			</div>
		</div>
	</div>



	<!-- @require footer -->
	<%@ include file="includes/footer.jsp"%>

</body>

</html>
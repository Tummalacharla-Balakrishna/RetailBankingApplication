<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Create a Customer</title>
        <%@ include file = "includes/head.jsp" %>
    </head>
    <body>
		<% String errMessage = (String)request.getAttribute("message"); %>
        <!-- @require header -->
        <%@ include file = "includes/header.jsp" %>
        <jsp:include page="SessionCheck.jsp"></jsp:include>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-sm-12 col-md-offset-3">
                    <h1 class="text-center">Create Customer</h1>
                    <form name="form" onsubmit="return createCustomerValidate(event);" action="CustomerController" method="post" class="m-top">
                    	<%
                    		Integer CustomerID = (Integer)request.getAttribute("CustomerID");
                    	if(errMessage != null) { 
                			 out.println(errMessage);
                		 } %>
                    
                    	<input type="hidden" name="source" value="CreateCustomer">
                        <div class="col-md-6 col-sm-6">
                            <label for="#CustomerSSNID" class="pull-left">Customer SSNID<span class="text-danger"> *</span></label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <input type="text" name="CustomerSSNID" class="form-inline pull-right form-group form-control" id="CustomerSSNID" required>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <label for="#Name" class="pull-left">Name<span class="text-danger"> *</span></label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <input type="text" name="Name" class="form-inline pull-right form-group form-control" id="Name" required>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <label for="#Age" class="pull-left">Age<span class="text-danger"> *</span></label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <input type="number" name="age" class="form-inline pull-right form-group form-control" id="Age" required>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <label for="#Address" class="pull-left">Address<span class="text-danger"> *</span></label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <input type="text" name="Address" class="form-inline pull-right form-group form-control" required>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <label for="#State" class="pull-left">Select State<span class="text-danger"> *</span></label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <select onchange="print_city('City', this.selectedIndex);" class="form-inline pull-right form-group form-control" id="state" name="state" required>                            	
                            </select>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <label for="#City" class="pull-left">Select City<span class="text-danger"> *</span></label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <select class="form-inline pull-right form-group form-control" id="City" name="city" required>
                                <option selected disabled>Select City</option>                                
                            </select>
                            <script language="javascript">print_state("state");</script>
                        </div>
                        <div class="col-md-12">
                        	<p class="text-danger">(*) Fields are Compulsory</p>
                        </div>
                        
                        <div class="col-md-6 col-sm-6">
                        	<input type="submit" value="Submit" class="form-inline pull-right form-group form-control button-primary">
                        </div>
                        <div class="col-md-6 col-sm-6">
                        	<input type="reset" value="Reset" class="form-inline pull-right form-group form-control button-primary">
                        </div>
                    </form>
                </div>
            </div>
        </div>



        <!-- @require footer -->
        <%@ include file = "includes/footer.jsp" %>
    </body>
</html>

<!DOCTYPE html>
<jsp:include page="SessionCheck.jsp"></jsp:include>
<html>
    <head>
        <title>Create Account</title>
        <%@ include file = "includes/head.jsp" %>
    </head>
    <body>

        <!-- @require header -->
		<%@ include file = "includes/header.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-sm-12 col-md-offset-3">
                    <h1 class="text-center">Create Account</h1>                                  
                    <form name="myform" action="AccountController" method="post" class="createAccount m-top">
                    	
                    	<div>
                    		
                    		
                    		<%
                    				 
                    			
                        			if(request.getAttribute("status")!=null)
                        			{
                        				if((Boolean)request.getAttribute("status")==true)
                        					out.println("<p class='alert alert-success text-center'>Customer Account Created successfully.</p>");
                        				else
                        					out.println("<p class='alert alert-danger text-center'>Customer does not exist. Please create customer first</p>");
                        			}
                        			
                    			
                    			%>
                    			
                    		
                    	</div>
                    
                        <div class="col-md-6 col-sm-6">
                            <label for="#CustomerID" class="pull-left">Customer ID<span class="text-danger"> *</span></label>
                           
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <input type="number" name="CustomerID" class="form-inline pull-right form-group form-control" id="CustomerID" required onblur="validateCustomerID()" >
                        </div>
                        
                        
                         <div class="col-md-6 col-sm-6">
                            <label for="#AccountType" class="pull-left">Account Type<span class="text-danger"> *</span></label>
                        </div>
                        
                        <div class="col-md-6 col-sm-6">
                            <select class="form-inline pull-right form-group form-control" name="AccountType" id="AccountType" required>
                           		<option disabled selected value> </option>
                                <option value=current>Current Account</option>
                                <option value=saving>Saving Account</option>
                                
                            </select>
                        </div>
                         <div class="col-md-6 col-sm-6">
                            <label for="#DepositAmont" class="pull-left">Deposit Amount<span class="text-danger"> *</span></label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <input type="number" name="DepositAmount" class="form-inline pull-right form-group form-control" id="DepositAmount" required>
                        </div>
                         <div class="col-md-12">
                        	<p class="text-danger">(*) Fields are Compulsary</p>
                        </div>
                         <div class="col-md-6 col-sm-6">
				<input type="hidden" name="source" value="createAccount"/>
                        	<input type="submit" value="Submit" class="form-inline pull-right form-group form-control button-primary">
                        </div>
                       <!--  <div class="col-md-6 col-sm-6">
                            <input type="text" name="Name" class="form-inline pull-right form-group form-control" id="CustomerSSNID" required>
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
                            <select class="form-inline pull-right form-group form-control" id="State" required>
                                <option>State 1</option>
                                <option>State 2</option>
                                <option>State 3</option>
                                <option>State 4</option>
                                <option>State 5</option>
                                <option>State 6</option>
                            </select>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <label for="#City" class="pull-left">Select City<span class="text-danger"> *</span></label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <select class="form-inline pull-right form-group form-control" id="City" required>
                                <option>City 1</option>
                                <option>City 2</option>
                                <option>City 3</option>
                                <option>City 4</option>
                                <option>City 5</option>
                                <option>City 6</option>
                            </select>
                        </div>
                        <div class="col-md-12">
                        	<p class="text-danger">(*) Fields are Compulsary</p>
                        </div>
                        
                        <div class="col-md-6 col-sm-6">
                        	<input type="submit" value="Submit" class="form-inline pull-right form-group form-control button-primary">
                        </div>
                        <div class="col-md-6 col-sm-6">
                        	<input type="reset" value="Reset" class="form-inline pull-right form-group form-control button-primary">
                        </div>-->
                    </form>
                </div>
            </div>
        </div>



        <!-- @require footer -->
        <%@ include file = "includes/footer.jsp" %>
        
    </body>
</html>

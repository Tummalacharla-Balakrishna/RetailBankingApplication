<jsp:include page="SessionCheck.jsp"></jsp:include>
<!DOCTYPE html>

<html>
    <head>
        <title>Delete a Customer</title>
        <%@ include file = "includes/head.jsp" %>
    </head>
    <body>
		<% String errMessage = (String)request.getAttribute("message"); %>
		<jsp:include page="SessionCheck.jsp"></jsp:include>
        <!-- @require header -->
        <%@ include file = "includes/header.jsp" %>
        
		<div class="delete-head container-fluid">
        	<h1 class="text-center">Delete Customer</h1>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-sm-12 col-md-offset-3">    
                    <form name="form" onsubmit="createCustomerValidate()" action="CustomerController" method="post" class="m-top">
                    <%
                    		Integer CustomerID = (Integer)request.getAttribute("CustomerID");
                    	if(errMessage != null) { 
                			 out.println(errMessage);
                		 } %>
                		 <div id="errorDiv"></div>
                    	<input type="hidden" name="source" value="deleteCustomer">
                    	<div class="col-md-6 col-sm-6">
                            <label for="#cust_id" class="pull-left">Customer ID<span class="text-danger"> *</span></label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <input type="text" name="CustomerId" class="form-inline pull-right form-group form-control" onblur="return validateUpdateScreenID(event)" id="cust_id" required>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <label for="#CustomerSSNID" class="pull-left">Customer SSNID<span class="text-danger"> *</span></label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <input type="text" name="CustomerSSNID" class="form-inline pull-right form-group form-control" id="CustomerSSNID" readonly>
                        </div>
                        
                        <div class="col-md-6 col-sm-6">
                            <label for="#Name" class="pull-left">Name<span class="text-danger"> *</span></label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <input type="text" name="Name" class="form-inline pull-right form-group form-control" id="Name" readonly>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <label for="#Age" class="pull-left">Age<span class="text-danger"> *</span></label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <input type="number" name="age" class="form-inline pull-right form-group form-control" id="Age" readonly>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <label for="#Address" class="pull-left">Address<span class="text-danger"> *</span></label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <input type="text" name="Address" class="form-inline pull-right form-group form-control" id="Address" readonly>
                        </div>                        
                        <div class="col-md-12">
                        	<p class="text-danger">(*) Fields are Compulsory</p>
                        </div>
                        
                        <div class="col-md-6 col-sm-6">
                        	<input type="submit" value="Confirm Delete" class="form-inline pull-right form-group form-control button-primary">
                        </div>
                        <div class="col-md-6 col-sm-6">
                        	<input type="reset" value="Cancel" class="form-inline pull-right form-group form-control button-primary">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- @require footer -->
        <%@ include file = "includes/footer.jsp" %>
    </body>
</html>
<script>
$(document).ready(function() {
	
	$('#cust_id').blur(function() {
		
		var cust_id=$("#cust_id").val();
		$.ajax({
			url : 'CustomerSearchByCID',
			data : {
				
				cust_id:cust_id				
			},
			type:'post',
			success : function(response) {
				typeof undefined === 'undefined';
				if(response.cust_ssn_id == undefined){
					$('#errorDiv').html("<p class='alert alert-danger text-center'>Given Customer ID does not exist!<p>");
				}
				$('#CustomerSSNID').val(response.cust_ssn_id);
				$('#Name').val(response.name);
				$('#Address').val(response.addr);
				$('#Age').val(response.age);
				
			},
			error:function(response){
				alert(response);
			}
			  });
	});
});
</script>

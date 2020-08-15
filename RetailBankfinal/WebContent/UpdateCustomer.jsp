<jsp:include page="SessionCheck.jsp"></jsp:include>
<!DOCTYPE html>
<html>
    <head>
        <title>Update Customer</title>
        <%@ include file = "includes/head.jsp" %>
    </head>
    <body>
    <% String errMessage = (String)request.getAttribute("message"); %>
    <%@page import="com.casestudy.retailbank.bean.CustomerPOJO"
 		 import="java.util.List"
  %>
    <%
		List<CustomerPOJO> cust_id_list = (List<CustomerPOJO>)request.getAttribute("cust_id_list");
        //CustomerPOJO customer = cust_id_list.get(0);
        %>
        <!-- @require header -->
		<%@ include file = "includes/header.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-sm-12 col-md-offset-3">
                    <h1 class="text-center">Update Customer</h1>
                    <form name="form" onsubmit="updateCustomerValidation()" action="CustomerController" method="post" class="m-top">
                    <%
                    		Integer CustomerID = (Integer)request.getAttribute("CustomerID");
                    	if(errMessage != null) { 
                			 out.println(errMessage);
                		 } %>
                		 <div id="errorDiv"></div>
                        <div class="row">
                        <input type="hidden" name="source" value="UpdateCustomer">
                            <div class="col-md-6 col-sm-6 form-group">
                                <label for="#cust_id_list" class="pull-left">Customer ID</label>
                            </div>
                            <div class="col-md-6 col-sm-6 form-group">                            	
                                <input type="text" id="cust_id_list" class="form-inline pull-right form-group form-control" onblur="return validateUpdateScreenID(event)" name="cust_id">
                                
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 col-sm-6 form-group">
                                <label for="#cust_ssn_id" class="pull-left">Customer SSNID</label>
                            </div>
                            <div class="col-md-6 col-sm-6 form-group">
                                <strong id="cust_ssn_id"></strong>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 col-sm-6 form-group">
                                <label class="pull-left">Old Customer Name</label>
                            </div>
                            <div class="col-md-6 col-sm-6 form-group">
                                <strong id="name"></strong>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 col-sm-6 form-group">
                                <label for="#NewName" class="pull-left">New Customer Name<span class="text-danger"> *</span></label>
                            </div>
                            <div class="col-md-6 col-sm-6">
                                <input type="text" name="NewName" class="form-inline pull-right form-group form-control" id="NewName" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 col-sm-6 form-group">
                                <label class="pull-left">Old Address</label>
                            </div>
                            <div class="col-md-6 col-sm-6 form-group">
                                <strong id="addr"></strong>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 col-sm-6 form-group">
                                <label for="#NewAddress" class="pull-left">New Address<span class="text-danger"> *</span></label>
                            </div>
                            <div class="col-md-6 col-sm-6">
                                <input type="text" name="NewAddress" class="form-inline pull-right form-group form-control" id="NewAddress" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 col-sm-6 form-group">
                                <label class="pull-left">Old Age</label>
                            </div>
                            <div class="col-md-6 col-sm-6 form-group">
                                <strong id="age"></strong>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 col-sm-6 form-group">
                                <label for="#NewAge" class="pull-left">New Age<span class="text-danger"> *</span></label>
                            </div>
                            <div class="col-md-6 col-sm-6">
                                <input type="number" name="NewAge" class="form-inline pull-right form-group form-control" id="NewAge" required>
                            </div>
                        </div>
                        <div class="row">
                        	<div class="col-md-12">
                        		<p class="text-danger">(*) Fields are Compulsory</p>
                        	</div>
                        	<div class="col-md-6 col-sm-6 col-md-offset-6">
                        		<input type="submit" value="Update" class="form-inline pull-right form-group form-control button-primary">
                        	</div>
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
	//alert("hi");
	$('#cust_id_list').blur(function() {
		//alert("change call");
		var cust_id=$("#cust_id_list").val();
		//alert(cust_id);
		//var source=$('#deleteAccount').val();
		$.ajax({
			url : 'CustomerSearchByCID',
			data : {
				
				cust_id:cust_id,
				//deleteAccount:source
			},
			type:'post',
			success : function(response) {
				//alert("success");
				//alert(response);
				typeof undefined === 'undefined';
				if(response.cust_ssn_id == undefined){
					$('#errorDiv').html("<p class='alert alert-danger text-center'>Given Customer ID does not exist!<p>");
				}
				
				$('#error_msg').text(response);
				$('#cust_ssn_id').text(response.cust_ssn_id);
				$('#name').text(response.name);
				$('#addr').text(response.addr);
				$('#age').text(response.age);
			},
			error:function(response){
				alert(response);
			}
			  });
	});
});

		

</script>

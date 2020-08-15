<jsp:include page="SessionCheck.jsp"></jsp:include>
<!DOCTYPE html>
<html>
    <head>
        <title>Delete Account</title>
        <%@ include file = "includes/head.jsp" %>
<%@page import="java.util.ArrayList" %>
       <%@page import=" com.casestudy.retailbank.service.AccountService" %> 
    </head>
    <body>

        <!-- @require header -->
		<%@ include file = "includes/header.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-sm-12 col-md-offset-3">
                    <h1 class="text-center">Delete Account</h1>
                   </br></br>
                    <form action="AccountController" method="post" class="DeleteAccount">
                    <div>
                    		
                    		
                    		<%
                    				 
                    			
                        			if(request.getAttribute("status")!=null)
                        			{
                        				if((Boolean)request.getAttribute("status")==true)
                        					out.println("<p class='alert alert-success text-center'>Customer Account Deleted successfully.</p>");
                        				else
                        					out.println("<p class='alert alert-danger text-center'>Account does not exist.</p>");
                        			}
                        			
                    			
                    			%>
                    			
                    		
                    	</div>
                    	
                     <div class="col-md-6 col-sm-6">
                            <label for="#AccountId" class="pull-left">Account ID</label>
                        </div>
                        
                        <div class="col-md-6 col-sm-6">
                            <select class="form-inline pull-right form-group form-control" id="AccountId" name="AccountId" required>
                                <option disabled selected value>--Select AccountId--</option>
                                
                                <% 
                                ArrayList<Integer> accountIdList;
                            	AccountService service = new AccountService();
                				accountIdList = service.getAllAccountId();
                             
                            		
                            		System.out.println(accountIdList);
                            		
                            		if(accountIdList!=null && accountIdList.size()>0)
                              		{
                            	  		 for(int i=0;i<accountIdList.size();i++)
                            	   		{
                            	%>
                            		   
                            		   <option value="<%= accountIdList.get(i) %>"><%=accountIdList.get(i) %></option>
                            		   <% 
                            	   }
                            	  // out.println("<h1>in</h1>");
                               }
                             %>
                                <option>222</option>
                            </select>
                        </div>
                    
                        <div class="col-md-6 col-sm-6">
                            <label for="#AccountType" class="pull-left">Account Type</label>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <input type="text" name="AccountType" class="form-inline pull-right form-group form-control" id="AccountType" onblur="validateAccountType()" readonly>
                        </div>
                        
                        
                       
                         <div class="col-md-6 col-sm-6">
				<input type="hidden" value="deleteAccount" name="source" id="deleteAccount">
                        	<input type="submit" value="Delete Account" class="form-inline pull-right form-group form-control button-primary">
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
	//alert("hi");
	$('#AccountId').change(function() {
		//alert("change call");
		var aid=$("#AccountId").val();
		//alert(aid);
		//var source=$('#deleteAccount').val();
		$.ajax({
			url : 'AccTypeSearch',
			data : {
				
				aid:aid,
				//deleteAccount:source
			},
			type:'post',
			success : function(response) {
				//alert("success");
				//alert(response);
				$('#AccountType').val(response);
				//$('#Balance').text(response.balance);
			}
			/*error:function(response){
				alert(response);
			},
			
			complete: function (response) {
			    alert(response);
			  }*/
		});
	});
});

		

</script>

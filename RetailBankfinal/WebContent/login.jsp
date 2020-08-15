<!DOCTYPE html>
<html>
<head>

<%@ include file = "includes/head.jsp" %>

<title>Login</title>
</head>
<body>
	<% String errMessage = (String)request.getAttribute("message"); %>	
	<form name="form" onsubmit="validate()" action="LoginController" method="post">
	<% if(errMessage != null) { %>
		<p class='alert alert-danger text-center'><% out.println(errMessage); %><p>
		<% } %>
		<div class="login">
		
			<div class="row top-header">
				<div class="col-sm-12" style="padding-top:10px;padding-bottom:10px">Login</div>
			</div>
			
			<input type="hidden" name="action" value="login">
			<div class="row">
				<div class="col-sm-12" style="padding-top:15px;">
					<input type="text" name="username" class="form-control" id="usr" placeholder="UserName" required>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12" style="padding-top:15px;"> 
					<input type="password" name="password" class="form-control" id="pwd" placeholder="Password" required>
				</div>
			</div>
			<div class="row" style="padding-top:15px;text-align:center;">
				<div class="col-sm-12 adjust" >
					<input type="submit" value="Login">
				</div>
			</div>
		
		</div>
	</form>
		

</body>
</html>

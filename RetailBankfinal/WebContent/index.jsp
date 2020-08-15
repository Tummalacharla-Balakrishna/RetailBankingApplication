<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file = "includes/head.jsp" %>
<title>Welcome to FEDCHOICE</title>
<style>

.jumbotron {
	margin-bottom: 0px;
}

.navbar {
margin-bottom: 0px;
}

</style>
</head>
<body>

<%@ include file = "includes/header.jsp" %>
<% String userName = (String)session.getAttribute("username"); %>
		<div id="banner_image">
            <div class="container">
                <center>
                	<div id="banner_content">   
                	<% if(userName == null) { %>                 	
                    	<a href="login.jsp" class="btn btn-danger btn-lg active">LOGIN</a>
                    	<% } %>
                    	<% if(userName != null) { %>                 	
                    	<a href="LoginController" class="btn btn-danger btn-lg active">LOGOUT</a>
                    	<% } %>
                	</div>
            	</center>
            </div>
        </div>
<%@ include file = "includes/footer.jsp" %>
</body>
</html>
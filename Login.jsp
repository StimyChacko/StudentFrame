# StudentFrame
Web application created using Spring integrate with Hibernate. Used Bootstrap css for webpage
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
  	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href='<c:url value="/resources/css/style.css"></c:url>'>
    
   	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script> 
   	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 

	<title>Sign in</title>
</head>
<style></style>
<body>
<form:form commandName="logindetails" action="${pageContext.request.contextPath}/login/adminlog" method="post">
       
<a href="#" data-toggle="modal" data-target="#login-modal">Login</a>

<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    	  <div class="modal-dialog">
				<div class="loginmodal-container">
					<h1>Login to Your Account</h1><br>
				  
					
					 <table>
            <tr>
                <td><label for="username">User Name: </label> </td>
                <td><form:input path="username" id="username" placeholder="Username"/></td>
                 <td><form:errors path="username" cssStyle="color:#ff0000"></form:errors></td>
            </tr>
            
            <tr>
                <td><label for="password">Password: </label> </td>
                <td><form:password path="password" id="password" Placeholder="Password"/></td>
                 <td><form:errors path="password" cssStyle="color:#ff0000"></form:errors></td>
            </tr>
				<tr><td>	</td><td>
					<input type="submit" name="login" class="login loginmodal-submit" value="Login">
				  </td></tr>
					</table>
				  <div class="login-help">
					<a href='<c:url value="/login/adminreg/"></c:url>'>Register</a> 
				  </div>
				</div>
			</div>
		  </div>
</form:form>
</body>
</html>

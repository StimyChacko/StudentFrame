<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
  	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href='<c:url value="/resources/css/stylereg.css"></c:url>'>
    
   	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script> 
   	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 

<title>Admin Registration</title>
</head>
<body>

<form:form commandName="admindetails" action="${pageContext.request.contextPath}/log/addadmin" method="post">
         <form:hidden path="adminId" id="adminid"/>
         
         
   <div class="container">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h3 class="panel-title">Please sign up for Admin Registration <small>It's free!</small></h3>
			 			</div>
			 			<div class="panel-body">
			    		<form role="form">
			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
                                    <label>Name</label>
			                <form:input path="name" name="name" id="name" class="form-control input-sm" placeholder=" Name"/>
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
                                    <label>User name</label>
			    						<form:input path="username" name="user_name" id="user_name" class="form-control input-sm" placeholder="User Name"/>
			    					</div>
			    				</div>
			    			</div>

			    			<div class="form-group">
                                    <label>Password</label>
			    				<form:password path="password" name="password" id="password" class="form-control input-sm" placeholder="Password"/>
			    			</div>

			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
                                    <label>Email</label>
			    						<form:input path="email" name="email" id="email" class="form-control input-sm" placeholder="Email"/>
			    					</div>
			    				</div>
			    				
			    			</div>
			    			
			    			<input type="submit" value="Register" class="btn btn-info btn-block">
			    		
			    		</form>
			    	</div>
	    		</div>
    		</div>
    	</div>
    </div>      
         
         
         
  </form:form>
</body>
</html>
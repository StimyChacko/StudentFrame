<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<meta name="viewport" content="width=device-width, initial-scale=1">
	
  	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href='<c:url value="/resources/css/listcss.css"></c:url>'>
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script> 
   	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
    
<title>Student Details</title>
</head>
<body>

<h1> Student Details </h1>
<div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
    
    <a href='<c:url value="/stud/addstudent"></c:url>' class="btn btn-primary btn-xs pull-right"><b>+</b> Add New Student</a>
   <table class="table table-striped custab">
    <thead>
        <tr>
            <th>Student Name</th>
            <th>Age</th>
            <th>Branch</th>
             <th>Mobile</th>
            <th class="text-center">Action</th>
        </tr>
    </thead>
            
            <c:forEach items="${studentdetails}" var="studentinfo">
           <tr>     <td>${studentinfo.studname}</td>
            <td>${studentinfo.studage}</td>
            <td>${studentinfo.studbranch}</td>
            <td>${studentinfo.stdaddress.mobile}</td>
                <td class="text-center"><a class='btn btn-primary btn-xs' href='<c:url value="/stud/addmark/${studentinfo.studId}"></c:url>'><span class="glyphicon glyphicon-pencil"></span> Add Marks</a> <a class='btn btn-success btn-xs' href='<c:url value="/stud/viewmore/${studentinfo.studId}"></c:url>'><span class="glyphicon glyphicon-zoom-in"></span> View More</a> <a class='btn btn-info btn-xs' href='<c:url value="/stud/updatestudent/${studentinfo.studId}"></c:url>'><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href='<c:url value="/stud/deletestudent/${studentinfo.studId}"></c:url>' class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Delete</a></td>
       </tr>    </c:forEach> 
            <tr>
             
    </table>
    </div>
</div>
</body>
</html>
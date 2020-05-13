<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.dealership.global.Constant" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BigRedCars - Cart</title>

<link rel="stylesheet" href="style/stylesheet.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


</head>
<body>

<c:choose> 
	<c:when test="${current_user == 'user'}">
		<jsp:include page="user_navBar.jsp"></jsp:include>
	</c:when>
	<c:when test="${current_user == 'dealer'}">
		<jsp:include page="dealer_navBar.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
		<jsp:include page="default_navBar.jsp"></jsp:include>
	</c:otherwise>
</c:choose>

<div class="card mb-3 mx-auto w-75">
  <img src="${autoCart.getPictures()[0]}" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">${autoCart.getMake()} ${autoCart.getModel()}</h5>
    <p class="card-text">$${autoCart.getPrice()}, ${autoCart.getMileage()}</p>
    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
  </div>
  <a href="#" class="btn btn-primary">Purchase</a>
  <a href="#" class="btn btn-warning">Remove</a>
</div>



</body>
</html>
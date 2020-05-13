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
<title><c:out value="${Constant.webName}"/> - User Home</title>

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


<div class="jumbotron jumbotron-fluid mb-0" style="background-image: url('images/placeholder/dealership_banner.jpg'); background-repeat: no-repeat; background-size: cover;">
  <div class="container">
  <div class="bg-light w-50 p-2 rounded-lg shadow" style="opacity: .9;">
  <h1 class="display-4">Welcome <c:out value="${user.getFirstName()}"/></h1>
    <p class="lead">Navigate to where you need to go from here</p>
    </div>
 
  </div>
</div>

<div class="row py-5">
<div class="col-md-1"></div>
	<div class="col bg-secondary shadow-lg rounded-lg text-light p-2">
		<h4>Manage Favorites</h4>
		<a href="user_manage_favorites.jsp"><img class="w-100 rounded-lg img-responsive" src="images/placeholder/user_favorites.jpg" alt=""></a>
	</div>
	<div class="col">
	<h4>Browse Vehicles</h4>
		<a href="browse_inventory.jsp"><img class="w-100 rounded-lg img-responsive" src="images/placeholder/dealer_inventory.jpg" alt=""></a>
	</div>
	<div class="col bg-secondary shadow-lg rounded-lg text-light p-2">
	<h4>View History</h4>
		<a href="user_view_history.jsp"><img class="w-100 rounded-lg img-responsive" src="images/placeholder/dealer_history.png" alt=""></a>
	</div>
	<div class="col-md-1"></div>
</div>


</body>
</html>
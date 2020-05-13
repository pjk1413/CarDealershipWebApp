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
<title>Insert title here</title>

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

<div class="row py-3">
          <div class="col-2 bg-light rounded-lg py-3 border border-muted">
            <h3 class="text-dark px-2 pt-2">Menu</h3>
            <div class="btn-group-vertical w-100">
                <button type="button" class="btn btn-primary mx-1 w-100">Add Vehicle</button>
                <button type="button" class="btn btn-primary mx-1 w-100">Remove Vehicle</button>
                <button type="button" class="btn btn-primary mx-1 w-100">Update Vehicle</button>
                <button type="button" class="btn btn-primary mx-1 w-100">View Vehicle</button>
              </div>
          </div>

          <div class="col-5">
            <div class="card">
                <div class="card-header">
                  Transactions
                </div>
                <div class="card-body">
                  <h5 class="card-title">Transactions</h5>
                  <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                  <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
              </div>
          </div>
          <div class="col-5">
            <div class="card">
                <div class="card-header">
                  Average Days on Market
                </div>
                <div class="card-body">
                  <h5 class="card-title">Average Days on Market</h5>
                  <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                  <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
              </div>
          </div>
      </div>


</body>
</html>
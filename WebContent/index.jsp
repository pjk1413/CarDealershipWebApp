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
<title><c:out value="${Constant.webName}"/></title>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/stylesheet.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body class="bg-off-center">

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

      <!--Search Box-->
    <div class="row w-50 mx-auto vh-100">
        <div class="col my-auto">
        <form class="my-auto p-5 rounded-pill op-bg-2" action="SearchServlet">
            <div class="row op-5">
                <div class="col">
                    <h3 class="w-50 text-light op-bg-1 p-1 rounded-pill mx-auto text-center border border-alert">Search Cars for Sale</h3>
                </div>
            </div>
            <div class="row ">
                
              <div class="col-5">
                <input name="make" id="make" type="text" class="form-control rounded-pill" placeholder="Any Make">
                <label for="make">Ex: Honda</label>
              </div>
              <div class="col-5">
                <input name="model" id="model" type="text" class="form-control rounded-pill" placeholder="Any Model">
                <label for="model">Ex: Accord</label>
              </div>
              <div class="col">
              <input type="submit" class="form-control rounded-pill" value="Search">
              </div>
            </div>
          </form>
        </div>
    </div>
	
</body>
</html>
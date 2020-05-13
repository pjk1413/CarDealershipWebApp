<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.dealership.global.Constant" %>
<%@page import="com.dealership.dealer.Dealer" %>
<%@page import="com.dealership.auto.Automobile" %>

<%
Dealer dealer = (Dealer)session.getAttribute("user");

%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${ Constant.webName }"/> - Manage Inventory</title>

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

	<div class="m-5 bg-secondary shadow rounded-lg p-2">
        <!--Contain brief overview of data on sales and figures-->
       <h4 class="text-light">Overview</h4>
    </div>


    <div class="p-5 shadow rounded-lg m-3">
        <h4>Inventory</h4>
    <table class="table table-hover">
        <thead>
          <tr>
            <th scope="col"></th>
            <th scope="col">Body Type</th>
            <th scope="col">Make</th>
            <th scope="col">Model</th>
            <th scope="col">Year</th>
            <th scope="col">Mileage</th>
            <th scope="col">Price</th>
            <th scope="col">Engine</th>
            <th scope="col">Transmission</th>
            <th scope="col">VIN</th>
            <th scope="col">Manage</th>

          </tr>
        </thead>
        <tbody>        
        
        <c:forEach var="VIN" items="${user.getInventory()}">
        <c:set var="car" value="${Automobile.load(VIN)}"/>
          <tr>
            <form action="">
            <th scope="row">1</th>
            <td>${car.getBodyType()}</td>
            <td>${car.getMake()}</td>
            <td>${car.getModel()}</td>
            <td>${car.getYear()}</td>
            <td>${car.getMileage()}</td>
            <td>${car.getPrice()}</td>
            <td>${car.getEngine()}</td>
            <td>${car.getTransmission()}</td>
            <td>${VIN}</td>
            
            <c:url value="RemoveAutomobileServlet" var="removeVehicle">
            	<c:param name="removeVIN" value="${VIN}"/>
            </c:url>
            <c:url value="UpdateAutomobileServlet" var="updateVehicle">
            	<c:param name="updateVIN" value="${VIN}"/>
            </c:url>
            
            
            <td>					
            	<a href="<c:out value="${updateVehicle}"/>" class="btn btn-warning d-inline-block">Update</a>
            	<a href="<c:out value="${removeVehicle}"/>" class="btn btn-danger d-inline-block">Remove</a>   
            </td>
            </form>
          </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>

</body>
</html>
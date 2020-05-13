<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.dealership.global.Constant"%>
<%@page import="com.dealership.auto.Automobile"%>

<!DOCTYPE html>
<html lang="en">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>

<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="style/stylesheet.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<title><c:out value="${Constant.webName}" /> - Add Vehicle</title>
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
	
	
	<div class="row mt-5">
	
		<div class="col-md-1"></div>
		<div class="col">
		<div class="border rounded-lg p-3 shadow">
			<h5 class="mb-1">Choose Pictures To Upload</h5>
			<form method="post" class="" action="SaveAutoServlet">
				<sub class="mb-3 ">Please copy the urls of the files to upload.  You may upload multiples comma seperated.</sub>

				<textarea name="photoUrl" id="photoUrl" class="form-control"></textarea>
				<input type="button" class="btn btn-primary mt-3" value="Preview Photos">
	
			</div>
			<div class="row mt-5">
				
					<input type="submit" class="btn btn-info" value="Add Automobile to Inventory">
				</form>
				</div>
	<!-- C:\\Users\\pjk14\\Desktop\\Java\\image\\automobile\\ -->
		</div>
		<div class="col">
			<div class="row">
				<div class="col">
					<c:forEach var="picture" varStatus="i" items="${newAutomobile.getPictures()}">
						<div class="col-md-4 rounded-lg shadow px-0 d-inline-block my-3">
							<img class="w-100" src="<c:out value="${picture}"/>">
						</div>
					
					</c:forEach>
				</div>
				
			</div>

	


		</div>



		<div class="col-md-1"></div>
	
	
	</div>
		
			

</body>
</html>
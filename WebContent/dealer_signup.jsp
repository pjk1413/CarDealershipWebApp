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
    <link rel="stylesheet" href="/car_dealership1.0/WebContent/style/stylesheet.css">
    <link rel="stylesheet" href="../style/stylesheet.css">
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

      <div class="row">
        <div class="col my-3">
            <h2 class="text-center">Welcome to the <c:out value="${Constant.webName}"/> Network</h2>
            <h5 class="text-center">Reach more customers with our extensive network</h4>
        </div>
      </div>
      
      <div class="row">
        <div class="col-sm-2"></div>
        <div class="col p-3 rounded-lg shadow-lg">
            <form class="mx-auto" action="SignUpDealerServlet" method="POST">
                <h5>Account Information</h5>
                <div class="form-row">
                
                  <div class="form-group col-md-6">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email">
                  </div>
                  <div class="form-group col-md-6">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password">
                  </div>
                </div>
 
                <h5>Contact Details</h5>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="firstName">First Name</label>
                        <input type="text" class="form-control" id="firstName" name="firstName">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="lastName">Last Name</label>
                        <input type="text" class="form-control" id="lastName" name="lastName">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="company">Company Name</label>
                        <input type="text" class="form-control" id="company" name="company">
                    </div>
        			
               
                </div>
                <div class="form-row text-center">
        				
        			<input type="submit" class="mx-auto btn btn-primary px-5">
        		</div>
                
               
			

				
				
			</form>

		</div>
		<div class="col-sm-2"></div>
		</div>
                
         
        
   
<script src="../script/script.js"></script>
</body>
</html>
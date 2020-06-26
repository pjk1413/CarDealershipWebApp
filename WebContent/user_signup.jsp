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
            <h2 class="text-center">Welcome to the <c:out value="${Constant.webName}"/> experience</h2>
            <h5 class="text-center">A comprehensive database of vehicles from around the country</h5>
        </div>
      </div>
      <div class="row">
          <div class="col-sm-1"></div>
        <div class="col">
            <form class="mx-auto" action="SignUpUserServlet" method="post">
                <hr class="my-4">
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
                <hr class="my-4">
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
        
                </div>
                <div class="form-group">
                  <label for="address">Address</label>
                  <input type="text" class="form-control" id="address" name="address" placeholder="1234 Main St">
                </div>
                <div class="form-group">
                  <label for="inputAddress2">Address 2</label>
                  <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
                </div>
                <div class="form-row">
                  <div class="form-group col-md-6">
                    <label for="city">City</label>
                    <input type="text" class="form-control" id="city" name="city">
                  </div>
                  <div class="form-group col-md-4">
                    <label for="state">State</label>
                    <select id="state" name="state" class="form-control">
                    	<option selected>Missouri</option>
                    	<c:forTokens items="Illinois, Iowa, Arkansas, Tennessee, Kansas, Nebraska" delims="," var="state">
                      	<option><c:out value="${ state }"/></option>
                      </c:forTokens>
                    </select>
                  </div>
                  <div class="form-group col-md-2">
                    <label for="zipcode">Zip</label>
                    <input type="text" class="form-control" id="zipcode" name="zipcode">
                  </div>
                </div>
                <hr class="my-4">
                <h5 class="mb-0">Payment Information</h5>
                <sub >Payment information is not required now, but can speed up your checkout process</sub>
                <div class="form-row mt-3">
                    <div class="form-group col-md-10">
                        <label for="creditCard">Credit Card Number</label>
                        <input type="text" class="form-control" id="creditCard" name="creditCard">
                    </div>
                    <div class="form-group col-md-2">
                        <label for="cvc">CVC</label>
                        <input type="text" class="form-control" id="cvc" name="cvc">
                    </div>
                </div>
                <button type="submit" class="btn btn-primary mb-5">Sign Up</button>
              </form>

        </div>
        
        <!--  Carousel of Pictures inspiring you to buy a car go here -->
        <div class="col">
            <div id="carouselExampleCaptions" class="carousel slide my-5" data-ride="carousel">
                <ol class="carousel-indicators">
                  <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                  <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                  <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner rounded-lg">
                  <div class="carousel-item active">
                    <img src="images/placeholder/signup1.jpg" class="d-block w-100" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                      <h5>Great for the whole family</h5>
                      <p>The process has never been easier and headache free.</p>
                    </div>
                  </div>
                  <div class="carousel-item">
                    <img src="../images/placeholder/signup2.jpg" class="d-block w-100" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                      <h5>Start a new chapter</h5>
                      <p>Find the perfect vehicle to start the next chapter in your life.</p>
                    </div>
                  </div>
                  <div class="carousel-item">
                    <img src="../images/placeholder/signup3.jpg" class="d-block w-100" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                      <h5>Budget Friendly</h5>
                      <p>Use our smart search feature to find exactly what you need.</p>
                    </div>
                  </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                  <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                  <span class="sr-only">Next</span>
                </a>
              </div>

        </div>
        <div class="col-sm-1"></div>
      </div>

</body>
</html>
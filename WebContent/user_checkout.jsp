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
<title><c:out value="${Constant.webName}"/> - Checkout</title>

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




<div class="py-1 text-center">
        <h3>Please enter your payment information below</h3>

      </div>
      <div class="row">
          <div class="col bg-warning mb-4" style="height: 25px;"></div>
      </div>
      <div class="row">
          <div class="col-md-2"></div>
        <div class="col">
            <h4>Preview Your Order</h2>
            <div class="card" style="width: 18rem;">
                <img src="${autoCart.getPictures()[0]}" class="card-img-top" alt="...">
                <div class="card-body">
                  <h5 class="card-title">${autoCart.getMake()} ${autoCart.getModel()}</h5>
                  <p class="card-text">${autoCart.getDescription()}</p>
                </div>
                <ul class="list-group list-group-flush">
                  <li class="list-group-item">Mileage: ${autoCart.getMileage()},000</li>
                  <li class="list-group-item">Discounts: None</li>
                  <li class="list-group-item">Total Price: ${autoCart.getPrice()}</li>
                </ul>
                <div class="card-body">
                  <a href="user_cart.jsp" class="card-link">View Item</a>
                  <a href="browse_inventory.jsp" class="card-link">Remove Item</a>
                </div>
              </div>

        </div>
        <div class="col">
      <form class="mx-auto" method="POST" action="UserCheckoutServlet">
        <hr class="my-4">
        <h5>Account Information</h5>
        <div class="form-row">
        
          <div class="form-group col-md-6">
            <label for="inputEmail4">Email</label>
            <input type="email" class="form-control" id="inputEmail4">
          </div>
          <div class="form-group col-md-6">
            <label for="inputPassword4">Password</label>
            <input type="password" class="form-control" id="inputPassword4">
          </div>
        </div>
        <hr class="my-4">
        <h5>Contact Details</h5>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputFirstName">First Name</label>
                <input type="text" class="form-control" id="inputFirstName">
            </div>
            <div class="form-group col-md-6">
                <label for="inputLastName">Last Name</label>
                <input type="text" class="form-control" id="inputLastName">
            </div>

        </div>
        <div class="form-group">
          <label for="inputAddress">Address</label>
          <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
        </div>
        <div class="form-group">
          <label for="inputAddress2">Address 2</label>
          <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
        </div>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="inputCity">City</label>
            <input type="text" class="form-control" id="inputCity">
          </div>
          <div class="form-group col-md-4">
            <label for="inputState">State</label>
            <select id="inputState" class="form-control">
              <option selected>Choose...</option>
              <option>...</option>
            </select>
          </div>
          <div class="form-group col-md-2">
            <label for="inputZip">Zip</label>
            <input type="text" class="form-control" id="inputZip">
          </div>
        </div>
        <hr class="my-4">
        <h5>Payment Information</h5>
        <div class="form-row">
            <div class="form-group col-md-10">
                <label for="inputCreditCard">Credit Card Number</label>
                <input type="text" class="form-control" id="inputCreditCard">
            </div>
            <div class="form-group col-md-2">
                <label for="inputCVC">CVC</label>
                <input type="text" class="form-control" id="inputCVC">
            </div>
        </div>
        <button type="submit" class="btn btn-primary mb-5">Checkout</button>
      </form>
    </div>
    <div class="col-md-2"></div>
    </div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.dealership.auto.Automobile" %>
<%@page import="java.util.ArrayList" %>

<%

%>

<%@page import="com.dealership.global.Constant" %>
<%@page import="com.dealership.auto.Engine" %>
<%@page import="com.dealership.auto.BodyType" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="ISO-8859-1">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><c:out value="${Constant.webName}"/> - Browse Inventory</title>
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

    <!--Display cars to browse-->
    <div class="container">
    
        <div class="row">
            <div class="col">
                <h3 class="my-3 text-center">Browse Available Cars Below</h3> 
            </div>
        </div>

        <div class="row">
          <div class="col-md-2"></div>
          <div class="col mb-0">
            <form class="p-3 shadow-lg rounded-lg bg-light mb-3">
              <div class="form-row">
                <div class="col">
                  <select type="text" class="form-control border-0 shadow-sm" placeholder="">
                    <option selected><c:out value="${search.make}"></c:out></option>
    					<c:forEach items="${Automobile.returnAllUnique('make')}" var="make">
        					<option>${make}</option>
    					</c:forEach>

                  </select>
                </div>
                <div class="col">
                  <select type="text" class="form-control border-0 shadow-sm" placeholder="">
                    <option selected><c:out value="${search.model}"/> </option>
                    	<c:forEach items="${Automobile.returnAllUnique('model')}" var="model">
        					<option>${model}</option>
    					</c:forEach>
                    
                  </select>
                </div>
              </div>
              <div class="form-row mt-3">
                <div class="col rounded-lg shadow-sm w-100 my-auto mx-auto bg-white">
                    <div>
                      <h6 class="text-center">Select Maximum Mileage</h6>
                    </div>
                    <div class="form-group">
                      <label class="float-left" for="begin">0</label>
                 
                      <label class="float-right" for="end">300</label>
                      <span id="begin"></span></span><input oninput="sliderDisplayValue()" class="w-100 slider" type="range" id="slider" name="slider" min="0" max="300" value="${search.maxMiles}"><span id="end"></span>
                      <sub>Slider in thousands of miles</sub><span class="float-right" id="display"></span>
                    </div>
                </div>
              </div>
              <div class="form-row mt-3">
                
                    <div class="col">
                      <input type="text" class="form-control border-0 shadow-sm" placeholder="Minimum Price" id="minPrice" name="minPrice">
                    </div>
                    <div class="col">
                      <input type="text" class="form-control border-0 shadow-sm" placeholder="Maximum Price" id="maxPrice" name="maxPrice">
                  
                </div>
              </div>
              <div class="form-row mt-3">

						<div
							class="ml-1 col-4 border-0 rounded-lg shadow-sm bg-white mr-1 pl-0">
							<div class="form-row">
								<div class="col">
									<div class="custom-control custom-checkbox p-2 ml-4">
										<input type="checkbox" class="custom-control-input"
											id="newCarsOnly" name="newCarsOnly"> <label
											class="custom-control-label" for="customControlAutosizing">New
											Vehicles Only</label>
									</div>
								</div>

							</div>
						</div>
						<div
							class="col border-0 rounded-lg shadow-sm bg-white ml-2 pr-0 mr-1">
							<div class="form-row">
								<div class="col">
									<h6 class="mb-0 p-2">Transmission</h6>
								</div>

								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio"
										name="inlineRadioOptions" id="automatic" value="Automatic">
									<label class="form-check-label" for="automatic">Automatic</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio"
										name="inlineRadioOptions" id="manual" value="Manual">
									<label class="form-check-label" for="manual">Manual</label>
								</div>
							</div>
						</div>

					</div>
          <div class="form-row mt-3">
            <div class="col">
              <select type="text" class="form-control border-0 shadow-sm" placeholder="">
                <option selected>Year</option>
                <c:forEach var="i" begin="1900" end="2020">
				<option><c:out value="${i}"></c:out></option>
				</c:forEach>
              </select>
            </div>
            <div class="col">
              <select type="text" class="form-control border-0 shadow-sm" placeholder="" id="engine" name="engine">
                <option selected>Engine</option>
                <c:set var="engines" value="${Engine.values()}"></c:set>
                <c:forEach var="type" items="${engines}">
                	<option><c:out value="${ type.toString() }"/></option>
                </c:forEach> 
              </select>
            </div>
            <div class="col">
              <select type="text" class="form-control border-0 shadow-sm" placeholder="" id="bodyType" name="bodyType">
                <option selected>Body Style</option>
                <c:set var="bodyTypes" value="${BodyType.values()}"></c:set>
                <c:forEach var="type" items="${bodyTypes}">
                	<option><c:out value="${type.toString()}"/></option>
                </c:forEach> 
              </select>
            </div>
          </div>
          <div class="row">
		<div class="col text-center">
			<button class="btn btn-primary mb-1 mt-3 w-100" type="submit">Filter Results</button>
		</div>
		</div>
            </form>
            
          </div>
          <div class="col-md-2"></div>

        </div>

		

<!-- This begins the display area.  Each card will be filled in with data based on the search criteria, or automatically when the page loads -->

        <div onload="rollThroughPictures()" class="row my-3">
        	<c:forEach items="${Automobile.loadAll()}" var="car">
            <div class="col-md-4">
              <!--This first card represents the proper card and will be our template that we use-->
                <div class="card shadow border-0" style="width: 18rem;">
                    <img src="${car.getPictures()[0]}" class="card-img-top" alt="...">
                    <!--  00000_cNA9GyWUrxl_600x450.jpg-->
             
                    <div class="card-body">
                      <h5 class="card-title"><c:out value="${car.getMake()} ${car.getModel()}"/></h5>
                      <p class="card-text">${car.getDescription()}</p>
                    </div>
                    <ul class="list-group list-group-flush">
                      <li id="test" class="list-group-item">Car Price: ${car.getPrice()}</li>
                      <li class="list-group-item">Car Mileage: ${car.getMileage()*1000}</li>
                      <li class="list-group-item">Transmission: ${car.getTransmission() }</li>
                    </ul>
                    <div class="card-body">
                    
                    <c:url value="AddAutoToCartServlet" var="selectCar">
                    	<c:param name="carVIN" value="${car.getVin()}"/>
                    </c:url>
                    
                      <a href="#" class="btn btn-info">View Details</a>
                      <a href="${selectCar}" class="btn btn-primary">Add to Cart</a>
                    </div>
                  </div>
            </div>
            </c:forEach>
            
        <div class="row my-3">
            
        
    </div>
    <div class="row my-3">
       
    </div>
    
	<script type="text/javascript" src="script/script.js"></script> 
</body>

</html>
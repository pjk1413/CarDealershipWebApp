<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.dealership.global.Constant"%>
<%@page import="com.dealership.auto.Engine"%>
<%@page import="com.dealership.auto.BodyType"%>

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

	<div class="row">
		<div class="col my-3">
			<h2 class="float=left ml-5">Add Vehicle To Inventory</h2>

		</div>
	</div>
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col p-3 border-0 shadow-sm rounded-lg">
			<form class="mx-auto" action="AddVehicleServlet" method="POST">

				<h5>Vehicle Information</h5>
				<sub>Enter your vehicles details below</sub>
				<hr class="">

				<div class="shadow-sm border rounded-lg p-2">
					<p>Basic Car Details</p>
					<div class="form-row">
					
						<!-- MAKE -->
						<div class="col  my-2">
							<input type="text" class="form-control" id="make" name="make" placeholder="Make" required>
						</div>
						
						<!-- MODEL -->
						<div class="col my-2">
							<input type="text" class="form-control" id="model" name="model" placeholder="Model" required>
						</div>
					</div>
					<div class="form-row">
					
						<!-- ENGINE -->
						<div class="col  my-2">

							<select id="engine" name="engine" class="form-control" required>
								<option selected>Engine</option>
								<c:set var="engines" value="${Engine.values()}"></c:set>
                <c:forEach var="type" items="${engines}">
                	<option><c:out value="${ type.toString() }"/></option>
                </c:forEach> 
							</select>
						</div>
						
						<!--  BODY TYPE -->
						<div class="col  my-2">

							<select id="bodyType" name="bodyType" class="form-control" required>
								<option selected>Body Type</option>
								
                <c:set var="bodyTypes" value="${BodyType.values()}"></c:set>
                <c:forEach var="type" items="${bodyTypes}">
                	<option><c:out value="${type.toString()}"/></option>
                </c:forEach> 
							</select>
						</div>
					</div>
				</div>

				<!-- TRANSMISSION -->
				<div class="form-row p-2">
					
					
					<div class="border shadow-sm rounded-lg my-3 p-2">
						<div class="row mt-2">
							<p class="mx-auto mb-1">Transmission</p>
						</div>
						<hr class="my-1 mb-2">
						<div class="form-row mr-2">
							<div class="col">
								<div class="custom-control custom-radio">
									<input type="radio" class="custom-control-input" id="automatic" name="automatic" value="automatic">
									<label class="custom-control-label" for="automatic">Automatic</label>
								</div>
							</div>
							<div class="col">
								<div class="custom-control custom-radio">
									<input type="radio" class="custom-control-input" id="manual" name="manual" value="manual">
									<label class="custom-control-label" for="manual">Manual</label>
								</div>
							</div>
						</div>
					</div>
					
					<!-- YEAR -->
					<div class="col p-2 shadow-sm border rounded-lg my-3 ml-2">
						<label class="mx-auto" for="year">Year</label> <select
							id="year" name="year" class="mx-auto form-control" required>
							<option selected>2020</option>
							<c:forEach var="i" begin="1900" end="2020">
								<option><c:out value="${i}"></c:out></option>
							</c:forEach>
						</select>
					</div>

				</div>
				
				
				<!-- MILEAGE -->
				<div class="form-row">
					<div
						class="col rounded-lg w-100 mx-auto bg-white my-2 border shadow-sm p-2">
						<div>
							<h6 class="text-center">Set Vehicle Mileage</h6>
						</div>
						<div class="form-group">
							<label class="float-left" for="begin">0</label> <label
								class="float-right" for="end">300</label> <span id="begin"></span></span>
							<input oninput="sliderDisplayValue()" class="w-100 slider"
								type="range" id="slider" name="slider" min="0" max="300" required><span
								id="end"></span>
							<!-- User slider id for mileage -->
							<sub class="my-2">Slider in thousands of miles</sub><span
								class="float-right" id="display">75,000 miles</span>
						</div>
					</div>
				</div>
				
				<!-- VIN NUMBER -->
				<div class="form-row border rounded-lg shadow-sm p-2 my-3">
					<div class="form-group col">
						<label for="inputFirstName">VIN</label>
						<input type="text" class="form-control" id="vin" name="vin" required>
					</div>
				</div>


				<!-- PRICE -->
				<div class="form-row border rounded-lg shadow-sm p-2 my-3">
					<div class="row w-100">
					<div class="col-4"> 
						<h6>Pricing Your Car</h6> </div>
					<div class="col-8"><sub class="">Use the button to find what others have priced
						similar vehicles</sub></div>
					</div>
			
					<div class="col-md-8">
						<input type="text" class="form-control  mx-auto" id="price"
							name="price" placeholder="List Price" required>
					</div>
					<div class="col-md-4">
						<button class="btn btn-primary float-right px-4">
							<a href="#" class="text-light">Pricing</a>
							<!-- Not currently operational -->
						</button>
					</div>
				</div>
				
				<!--  DESCRIPTION -->
				<div class="form-row p-2 my-2 rounded-lg shadow-sm border my-3">
					<label for="description">Description</label>
					<textarea class="form-control" id="description" name="description" rows="3"
						placeholder="Describe your car..."></textarea>
				</div>

				<button type="submit" class="btn btn-primary mb-5 mt-3">Continue...</button>

			</form>
		</div>
		<div class="col">
			
			<hr>
			<div id="carouselExampleCaptions" class="carousel slide my-5"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleCaptions" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
					<li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner rounded-lg">
					<div class="carousel-item active">
						<img src="images/placeholder/car1.jpg" class="d-block w-100"
							alt="...">
						<div class="carousel-caption d-none d-md-block">
							<h5>First slide label</h5>
							<p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
						</div>
					</div>
					<div class="carousel-item">
						<img src="images/placeholder/car2.jpg" class="d-block w-100"
							alt="...">
						<div class="carousel-caption d-none d-md-block">
							<h5>Second slide label</h5>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
						</div>
					</div>
					<div class="carousel-item">
						<img src="images/placeholder/car3.jpg" class="d-block w-100"
							alt="...">
						<div class="carousel-caption d-none d-md-block">
							<h5>Third slide label</h5>
							<p>Praesent commodo cursus magna, vel scelerisque nisl
								consectetur.</p>
						</div>
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleCaptions"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleCaptions"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>

		</div>
		<div class="col-sm-1"></div>
	</div>
	<script src="script/script.js"></script>
</body>

</html>
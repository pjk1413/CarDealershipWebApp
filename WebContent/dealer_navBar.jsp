<%@page import="com.dealership.dealer.Dealer" %>

<% 
	
	try {
		Dealer dealer = (Dealer)session.getAttribute("user");
		session.setAttribute("user", dealer);
		
	} catch(NullPointerException e) {
		e.getMessage();
	}

  Dealer dealer = (Dealer)session.getAttribute("user");
  session.setAttribute("user", dealer);

%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">BigRedCars</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
          <ul class="navbar-nav">
            <li class="nav-item active">
              <a class="nav-link" href="dealer_home.jsp">Home </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="dealer_add_vehicle.jsp">Add a Vehicle</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="dealer_manage_vehicles.jsp">Manage Inventory</a>
            </li>
            
          </ul>
        </div>
        <div class="collapse navbar-collapse float-right" id="navbarNavDropdown">
            <ul class="ml-auto navbar-nav">
            	<li class="btn btn-secondary mx-1 nav-item">
                  <a class="nav-link text-light" href="SignOutServlet">Sign Out</a>
                </li>
                <li class="btn btn-secondary mx-1 nav-item">
                  <a class="nav-link text-light" href="login.jsp">Account</a>
                </li>
            </ul>
        </div>
      </nav>
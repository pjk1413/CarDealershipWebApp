<%@page import="com.dealership.user.User" %>

<% 
	
	try {
		User user = (User)session.getAttribute("user");
		session.setAttribute("user", user);
		
	} catch(NullPointerException e) {
		e.getMessage();
	}

  User user = (User)session.getAttribute("user");
  session.setAttribute("user", user);

%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="user_home.jsp">BigRedCars</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
          <ul class="navbar-nav">
            <li class="nav-item active">
              <a class="nav-link" href="user_home.jsp">Home </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="browse_inventory.jsp">Browse</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="user_cart.jsp">View Cart</a> 					<!-- View car will need to ask that you are signed in if you are not -->
            </li>
            <li class="nav-item">
              <a class="nav-link" href="user_checkout.jsp">Checkout</a> 					<!-- View car will need to ask that you are signed in if you are not -->
            </li>

            
          </ul>
        </div>
        <div class="collapse navbar-collapse float-right" id="navbarNavDropdown">
            <ul class="ml-auto navbar-nav">
            	<li class="btn btn-info mx-1 nav-item">
                  <a class="nav-link text-light" href="SignOutServlet">Sign Out</a>
                </li>
                <li class="btn btn-secondary mx-1 nav-item">
                  <a class="nav-link text-light" href="user_home.jsp">Account</a>
                </li>
            </ul>
        </div>
      </nav>
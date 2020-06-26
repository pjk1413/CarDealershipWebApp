package com.dealership.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dealership.global.Address;
import com.dealership.user.User;

/**
 * Servlet implementation class SignUpUserServlet
 */
@WebServlet("/SignUpUserServlet")
public class SignUpUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Should be a doPost
		HttpSession session = request.getSession();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//User this constructor to automatically generate an id
		User user = new User(firstName, lastName, email, password);
		
		//set user properties
		Address address = new Address();
		address.setStreet(request.getParameter("address"));
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setZipcode(request.getParameter("zipcode"));
		
		user.setAddress(address);
		
		//Save user to database
		user.save();
		
		session.setAttribute("user", user);
		session.setAttribute("current_user", "user");
		
		RequestDispatcher rs = request.getRequestDispatcher("user_home.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

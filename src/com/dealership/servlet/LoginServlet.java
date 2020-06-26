package com.dealership.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dealership.admin.Admin;
import com.dealership.dealer.Dealer;
import com.dealership.user.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		ArrayList<User> userList = User.loadAll();
		ArrayList<Dealer> dealerList = Dealer.loadAll();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Dealer d = new Dealer();
		User u = new User();
		
		int current_user = 0;
		
		if (Admin.email.contentEquals(email) && Admin.password.contentEquals(password)) {
			session.setAttribute("current_user", "admin");
			current_user = 3;
		}
		
		if (!(dealerList == null || dealerList.size() == 0)) {
			//System.out.println("IN");
			for (Dealer dealer : dealerList) {
				//System.out.println(dealer.getEmail());
				if (dealer.getEmail().contentEquals(email) && dealer.getPassword().contentEquals(password)) {
					session.setAttribute("current_user", "dealer");
					session.setAttribute("user", dealer);
					current_user = 1;
					
					
					Dealer newDealer = (Dealer) session.getAttribute("user");
					//System.out.println(newDealer.getEmail() + newDealer.getFirstName());
				}
			}
		}
		
		if (userList != null) {
	
			for (User user : userList) {
			
				if (user.getEmail().contains(email) && user.getPassword().contains(password)) {
					session.setAttribute("current_user", "user");
					session.setAttribute("user", user);
					current_user = 2;
				}
			}
		}
			
		String path = "";
		
		if (current_user == 1) {
			path = "dealer_manage_vehicles.jsp";
		} else if (current_user == 2) {
			path = "user_home.jsp";
		} else {
			//if failed
			path = "login.jsp";
			session.setAttribute("login", "Check your username or password");
		}
		
		RequestDispatcher rs = request.getRequestDispatcher(path);
		rs.forward(request, response);

	}

}

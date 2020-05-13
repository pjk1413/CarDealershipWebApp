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

import com.dealership.auto.Automobile;
import com.dealership.user.User;

/**
 * Servlet implementation class AddAutoToCartServlet
 */
@WebServlet("/AddAutoToCartServlet")
public class AddAutoToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAutoToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String VIN = request.getParameter("carVIN");
		
		Automobile automobile = Automobile.load(VIN);
		
		User user = null;

		try {
			if(session.getAttribute("current_user").equals(null)) {
				
			}
			
		} catch (NullPointerException e) {
			RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
			rs.forward(request, response);
		}

		if (session.getAttribute("current_user").equals("user")) {
			user = (User)request.getAttribute("user");
			
			//ArrayList<String> favListTemp = user.getFavoriteList();
			//favListTemp.add(VIN);
			
			//user.setFavoriteList(favListTemp);
			
			session.setAttribute("autoCart", automobile);
			
			RequestDispatcher rs = request.getRequestDispatcher("user_checkout.jsp");
			rs.forward(request, response);
			
			
		} else {
			
			session.setAttribute("autoCart", automobile);
			
			RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
			rs.forward(request, response);
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

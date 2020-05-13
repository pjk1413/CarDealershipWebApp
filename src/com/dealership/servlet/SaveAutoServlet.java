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
import com.dealership.dealer.Dealer;

/**
 * Servlet implementation class SaveAutoServlet
 */
@WebServlet("/SaveAutoServlet")
public class SaveAutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveAutoServlet() {
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
		
		Automobile automobile = (Automobile)session.getAttribute("newAutomobile");
		
		Dealer dealer = (Dealer)session.getAttribute("user");
		
		String photoString = request.getParameter("photoUrl");
		
		String photoList[] = photoString.split(",");
		
		automobile.setPictures(Automobile.toArrayList(photoList));
		
		ArrayList<String> inventory = dealer.getInventory();
		inventory.add(automobile.getVin());
		
		dealer.setInventory(inventory);
		
		
		dealer.update(dealer);
		automobile.save();
		
		session.setAttribute("user", dealer);
		//session.setAttribute("newAutomobile", null);
		
		RequestDispatcher rs = request.getRequestDispatcher("dealer_home.jsp");
		rs.forward(request, response);
	}

}

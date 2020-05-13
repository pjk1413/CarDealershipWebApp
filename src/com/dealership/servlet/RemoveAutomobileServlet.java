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
 * Servlet implementation class RemoveAutomobileServlet
 */
@WebServlet("/RemoveAutomobileServlet")
public class RemoveAutomobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveAutomobileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		
		Dealer dealer = (Dealer)session.getAttribute("user");
		
		String VIN = request.getParameter("removeVIN");
		
		Automobile.delete(VIN);
		
		ArrayList<String> dealerInventory = dealer.getInventory();
		dealerInventory.remove(VIN);
		dealer.setInventory(dealerInventory);
		dealer.update(dealer);

		request.setAttribute("user", dealer);
		
		RequestDispatcher rs = request.getRequestDispatcher("dealer_manage_vehicles.jsp");
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

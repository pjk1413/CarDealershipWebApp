package com.dealership.servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dealership.auto.Automobile;
import com.dealership.auto.BodyType;
import com.dealership.auto.Engine;
import com.dealership.auto.Transmission;
import com.dealership.dealer.Dealer;
import com.dealership.global.Constant;

/**
 * Servlet implementation class AddVehicleServlet
 */
@WebServlet("/AddVehicleServlet")
public class AddVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVehicleServlet() {
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
		
		Dealer dealer = (Dealer)session.getAttribute("user");
		
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String year = request.getParameter("year");
		String vin = request.getParameter("vin");
		
		Automobile automobile = new Automobile(make, model, year, vin);
		System.out.println(automobile.getMake());
		request.getParameter("price");
		
		Double price = Double.parseDouble(request.getParameter("price"));
		//System.out.println(price);
		
		automobile.setPrice(price);
		//System.out.println(request.getParameter("slider"));
		automobile.setMileage(Constant.isNull(request.getParameter("slider"), 0));
		automobile.setDescription(request.getParameter("description"));
		automobile.setEngine(request.getParameter("engine"));
		automobile.setBodyType(request.getParameter("bodyType"));
		automobile.setNewVehicle(Boolean.valueOf("newCar"));
		
		if (Constant.isNull(request.getParameter("manual")).contentEquals("manual")) {
			automobile.setTransmission("Manual");
		} else if (Constant.isNull(request.getParameter("automatic")).contentEquals("automatic")) {
			automobile.setTransmission("Automatic");
		}
		
		session.setAttribute("newAutomobile", automobile);
		
		RequestDispatcher rs = request.getRequestDispatcher("dealer_add_vehicle_pictures.jsp");
		rs.forward(request, response);
		
		
	}

}

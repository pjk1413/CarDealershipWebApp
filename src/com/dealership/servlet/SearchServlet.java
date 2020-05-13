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

import com.dealership.auto.AutoSearch;
import com.dealership.global.Constant;


/**
 * Servlet implementation class SearchServ
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		int minYear = Constant.isNull(request.getParameter("minYear"), 1900);
		int maxMiles = Constant.isNull(request.getParameter("slider"), 300000);
		double minPrice = Constant.isNull(request.getParameter("minPrice"), 0.0);
		double maxPrice = Constant.isNull(request.getParameter("maxPrice"), 1000000.0);
		boolean newCarsOnly = Boolean.parseBoolean(request.getParameter("newCarsOnly"));
		String transmission = "";
		String engine = request.getParameter("engine");
		String bodyType = request.getParameter("bodyType");
		
		if (Constant.isNull(request.getParameter("manual")).contentEquals("manual")) {
			transmission = "Manual";
		} else if (Constant.isNull(request.getParameter("automatic")).contentEquals("automatic")) {
			transmission = "Automatic";
		}
		
		AutoSearch search = new AutoSearch();
		search.make = make;
		search.model = model;
		search.minYear = minYear;
		search.maxMiles = maxMiles;
		search.minPrice = minPrice;
		search.maxPrice = maxPrice;
		search.newCarsOnly = newCarsOnly;
		search.transmission = transmission;
		search.engine = engine;
		search.bodyType = bodyType;
		
		session.setAttribute("search", search);
		
		RequestDispatcher rs = request.getRequestDispatcher("browse_inventory.jsp");
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

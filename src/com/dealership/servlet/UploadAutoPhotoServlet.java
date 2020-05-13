package com.dealership.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dealership.auto.Automobile;

/**
 * Servlet implementation class UploadAutoPhotoServlet
 */
@WebServlet("/UploadAutoPhotoServlet")
public class UploadAutoPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadAutoPhotoServlet() {
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
		
		String photoString = request.getParameter("photoUrl");
		
		String photoList[] = photoString.split(",");
		
		automobile.setPictures(Automobile.toArrayList(photoList));
		
		session.setAttribute("newAutomobile", automobile);
		
		RequestDispatcher rs = request.getRequestDispatcher("dealer_add_vehicle_pictures.jsp");
		rs.forward(request, response);
		
		
	}

}

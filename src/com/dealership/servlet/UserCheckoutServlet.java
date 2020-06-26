package com.dealership.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dealership.auto.Automobile;
import com.dealership.dealer.Dealer;
import com.dealership.global.Transaction;
import com.dealership.user.User;

/**
 * Servlet implementation class UserCheckoutServlet
 */
@WebServlet("/UserCheckoutServlet")
public class UserCheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCheckoutServlet() {
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
		
		Automobile automobile = (Automobile)session.getAttribute("autoCart");
		User user = (User)session.getAttribute("user");
		
		ArrayList<Dealer> dealerList = Dealer.loadAll();
		
		

		for (Dealer dealer : dealerList) {
			System.out.println(dealer.getInventory());
			for (String vin : dealer.getInventory()) {

				if (vin.contentEquals(automobile.getVin())) {
					System.out.println("MATCH");
					Automobile tempAuto = new Automobile();
					ArrayList<String> tempHistory = user.getPurchaseHistory();
					ArrayList<String> tempTransaction = dealer.getTransactionHistory();
					ArrayList<String> tempList = dealer.getInventory();
				
					
					
					tempList.remove(vin);
					dealer.setInventory(tempList);
					
					ArrayList<Automobile> autoList = Automobile.loadAll();
					
					automobile.sellAutomobile(LocalDate.now().toString());
					
					for (Automobile auto : autoList) {
						if (vin.contentEquals(auto.getVin())) {
							tempAuto = auto;
							Automobile.delete(vin);
						}
					}
					
					Transaction transaction = new Transaction();
					transaction.setUserEmail(user.getEmail());
					transaction.setDealerEmail(dealer.getEmail());
					transaction.setPrice(automobile.getPrice());
					transaction.setAutomobileVin(vin);
					transaction.save();
					
					tempHistory.add(transaction.getAutomobileVin());
					tempTransaction.add(transaction.getAutomobileVin());

					Dealer.update(dealer);
					User.update(user);
					
					session.setAttribute("r", transaction);
					
					
					
				}
			}
		}
		
		RequestDispatcher rs = request.getRequestDispatcher("reciept.jsp");
		rs.forward(request, response);
		
	}

}

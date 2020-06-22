package it.ilker.apsw.beachclub.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ilker.apsw.beachclub.BeachBookingService;
import it.ilker.apsw.beachclub.models.Seat;

/**
 * Servlet implementation class LoginController
 */
@WebServlet({ "/SunbedsController", "/sunbeds" })
public class SunbedsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SunbedsController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/view/error.jsp";
		
		Map<String, Seat> seats;
		seats = BeachBookingService.getSeats();
		request.setAttribute("seats", seats);
		
		if(!seats.isEmpty() ) {
			address = "/results/seat/result.jsp";
		}
			
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

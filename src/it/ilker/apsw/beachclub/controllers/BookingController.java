package it.ilker.apsw.beachclub.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ilker.apsw.beachclub.BeachBookingService;
import it.ilker.apsw.beachclub.BeachBookingStorage;
import it.ilker.apsw.beachclub.models.Seat;

/**
 * Servlet implementation class LoginController
 */
@WebServlet({ "/BookingController", "/booking" })
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/beach-club/seat-search.html";
		response.sendRedirect(address);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/results/seat/booking-result.jsp";
		Integer seatId = Integer.parseInt(request.getParameter("bookingSeatId"));
		BeachBookingService bookingService = new BeachBookingStorage();
		Seat seatToBook = bookingService.findSeat(seatId.toString());
		
		bookingService.occupySeat(seatId); 
		
		/*
		 * switch(q.getStatus()) { case Database.RESULT: address =
		 * "/results/seat/result.jsp"; break; case Database.NORESULT: address =
		 * "/WEB-INF/view/noresult.jsp"; break; case Database.ERROR: address =
		 * "/WEB-INF/view/error.jsp"; break; default: address =
		 * "/WEB-INF/view/invalid.jsp"; }
		 */
			
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
}

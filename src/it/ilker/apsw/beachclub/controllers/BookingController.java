package it.ilker.apsw.beachclub.controllers;

import java.io.IOException;
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
		String seatId = request.getParameter("bookingSeatId");
		String operationType = request.getParameter("operationType");
		System.out.println(operationType);
		Seat seatToBook = BeachBookingService.findSeat(seatId.toString());
		
		if(operationType.equals(BeachBookingService.OCCUPY)) {
			BeachBookingService.occupySeat(seatToBook.getId());
		} else if(operationType.equals(BeachBookingService.FREE)) {
			BeachBookingService.freeSeat(seatToBook.getId());
		} else {
			System.out.println("Error getting the operation type!");
		}

		response.sendRedirect("/beach-club");
	}
}

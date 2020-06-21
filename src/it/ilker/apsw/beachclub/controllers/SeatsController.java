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
 * Servlet implementation class SeatsController
 */
@WebServlet({ "/SeatsController", "/show-seats" })
public class SeatsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeatsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/beach-club/seat-search.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seatId = request.getParameter("seatId");
		Seat seat = BeachBookingService.findSeat(seatId);
		request.setAttribute("seatId", seatId);
		String address;
		
		if(seat == null) {
			request.setAttribute("badSeatId", seatId);
			address = "/results/seat/unknown-seat.jsp";
		} else {
			address = "/results/seat/seat.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
}

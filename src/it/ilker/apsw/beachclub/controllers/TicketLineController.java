package it.ilker.apsw.beachclub.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ilker.apsw.beachclub.ClientSearchService;
import it.ilker.apsw.beachclub.TicketLineService;
import it.ilker.apsw.beachclub.models.Client;

/**
 * Servlet implementation class TicketLineController
 */
@WebServlet({"/TicketLineController", "/ticket-line"})
public class TicketLineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketLineController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.sendRedirect("/beach-club/ticket-line/ticket-line.jsp");
		
		String address = "/ticket-line/ticket-line.jsp";
		
		List<Client> line = TicketLineService.getLine();
		request.setAttribute("line", line);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("username") == null) {
			doGet(request, response);
		}
		
		System.out.println(request.getSession().getAttribute("username"));
		System.out.println(request.getSession().getAttribute("userID"));
		
		try {
			String userID = (String) request.getSession().getAttribute("userID");
			Client client = ClientSearchService.findClient(userID);
			
			if(TicketLineService.getLine().contains(client)) {
				TicketLineService.removeFromLine(client);
				System.out.println("REMOVED FROM LINE!");
			} else {
				TicketLineService.addToLine(client);
				System.out.println("ADDED TO LINE!");
			}
			request.setAttribute("line", TicketLineService.getLine());
		} catch(Exception exception) {
			System.out.println("Cannot find the user: " + exception.getLocalizedMessage());
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ticket-line/ticket-line.jsp");
		dispatcher.forward(request, response);
 	}
}

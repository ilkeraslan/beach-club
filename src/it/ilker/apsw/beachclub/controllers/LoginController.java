package it.ilker.apsw.beachclub.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ilker.apsw.beachclub.models.Query;

/**
 * Servlet implementation class LoginController
 */
@WebServlet({ "/LoginController", "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {     
		String address = "/auth/login.html";
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String address = "";
        String email = request.getParameter("loginEmail");
        String password = request.getParameter("loginPassword");
        String sql = "select * from users where email='" + email + "'" + " and password='" + password+ "'";
        Query query= new Query(sql);
        System.out.println(sql.toString());
        request.setAttribute("query", query);
        Database.execute(query);
        
        if(query.getStatus() == Database.RESULT ) {
        	System.out.println(query.getResult().toString());
        	if(query.getResult().isEmpty()) {
        		address = "/WEB-INF/results/unknown-seat.jsp"; // TODO change
        		System.out.println("Login failed " + query.getExceptionMessage());
        	} else {
        		address = "/WEB-INF/results/result.jsp";
        	}
        } else if(query.getStatus() == Database.NORESULT) {
        	address = "/WEB-INF/results/unknown-seat.jsp"; // TODO change
        } else {
        	address = "/WEB-INF/results/unknown-client.jsp"; // TODO change
        	System.out.println("Login failed " + query.getExceptionMessage());
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
	}
}

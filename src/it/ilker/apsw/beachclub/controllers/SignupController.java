package it.ilker.apsw.beachclub.controllers;

import java.io.IOException;
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
@WebServlet({ "/SignupController", "/signup" })
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {     
		String address = "/auth/signup.html";
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String address = "";
        String firstName = request.getParameter("signupFirstname");
        String lastName = request.getParameter("signupLastname");
        String email = request.getParameter("signupEmail");
        String password = request.getParameter("signupPassword");
        
        String sql = "insert into users (name, surname, email, password, role) values "
        		+ "('" + firstName + "', '" + lastName + "', '" + email + "', '" + password + "', 'user')";

        Query query= new Query(sql);
        System.out.println(sql.toString());
        request.setAttribute("query", query);
        Database.execute(query);
        
        if(query.getStatus() == Database.RESULT ) {
        	address = "/results/auth/error.html";
        } else if(query.getStatus() == Database.NORESULT) {
        	address = "/results/auth/success-signup.html";
        } else {
        	address = "/results/auth/error.html";
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
	}
}

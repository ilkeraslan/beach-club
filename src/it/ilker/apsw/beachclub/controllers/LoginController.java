package it.ilker.apsw.beachclub.controllers;

import java.io.IOException;

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
		request.getRequestDispatcher(address).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        String address = "";
        String email = request.getParameter("loginEmail");
        String password = request.getParameter("loginPassword");
        String username = "";
        
        String sql = "select * from users where email='" + email + "'" + " and password='" + password + "'";
        Query query= new Query(sql);
        Database.execute(query);
        
        if(query.getStatus() == Database.RESULT ) {
        	if(query.getResult().isEmpty() || query.getResult().size() == 1) {
        		address = "/results/auth/error.html";
        	} else {
                try {
                	username = query.getResult().get(1).get(1);
                	System.out.println(username);

                	request.getSession().setAttribute("username", username);
                	request.setAttribute("username", username);
                	request.login(username, password);
                	address = "index.jsp";
                } catch(ServletException exception) {
                	System.out.println("Login failed " + exception);
                	address = "/results/auth/error.html";
                }
        	}
        } else {
        	address = "/results/auth/error.html";
        }
        
        request.getRequestDispatcher(address).forward(request, response);
	}
}

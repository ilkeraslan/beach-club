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
		String address = "";
		String sql = "select * from sunbeds";

		Query q = new Query(sql);
		request.setAttribute("query", q);
		Database.execute(q);
		
		switch(q.getStatus()) {
		case Database.RESULT:
			address = "/results/seat/result.jsp";
			break;
		case Database.NORESULT:
			address = "/WEB-INF/view/noresult.jsp";
			break;
		case Database.ERROR:
			address = "/WEB-INF/view/error.jsp";
			break;
		default:
			address = "/WEB-INF/view/invalid.jsp";
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

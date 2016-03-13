package com.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActionController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String firstName = (String) request.getParameter("firstname");
			String lastName = (String) request.getParameter("lastname");
			String email = (String) request.getParameter("email");
			String password = (String) request.getParameter("password");
			boolean result = LoginHandler.insertRecords(firstName,lastName,email,password);
			if(result)
				getServletContext().getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
			else
				getServletContext().getRequestDispatcher("/loginfail.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

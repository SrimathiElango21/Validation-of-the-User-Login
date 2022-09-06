package com.validation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		String user = request.getParameter("usName");
		String password = request.getParameter("usPass");

		if (password.equals("Srimathi")) {
			session.setAttribute("user", user);
			response.sendRedirect("Welcome.jsp?name=" + user);
		}
	
		else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			out.println("<font color=red>Password is wrong.</font>");
			rd.include(request, response);
		}
		
		out.close();
	}
}
